import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class Main extends JFrame {
    private JCheckBox[] checkBoxs = null;
    public Main(){
        setLayout(new BorderLayout(9, 4));
        Panel optionPanel = new Panel(new GridLayout(4, 5, 4, 4));
        RuleSet set=new RuleSet();
        set.init();
        int length = set.list.size();
        HashSet<String>cs=new HashSet<>();
        for (int i = 0; i < length; i++)
            for(String s:set.list.get(i).conditions)
                cs.add(s);
        checkBoxs = new JCheckBox[cs.size()];
        int index=0;
        for (String s:cs) {
                checkBoxs[index]=new JCheckBox(s);
                optionPanel.add(checkBoxs[index]);
                index++;
        }
        add(optionPanel, BorderLayout.CENTER);

        JButton btn = new JButton("推理");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                HashSet<String> database = new HashSet<>();
                for (int i = 0; i < checkBoxs.length; i++) {
                    if (checkBoxs[i].isSelected()) {
                        database.add(checkBoxs[i].getText());
                        System.out.print(checkBoxs[i].getText() + "\t");
                    }
                }
                System.out.println();
                System.out.println(database);
                String conclusion = set.ratiocinate(database);
                if(conclusion==null)
                    conclusion="未知病症";
                System.out.println(conclusion);
                JOptionPane.showMessageDialog(null,  "\n=>" + conclusion, "推理的结果是", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("简单病情推理");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
