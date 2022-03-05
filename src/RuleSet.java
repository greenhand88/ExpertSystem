import java.util.ArrayList;
import java.util.HashSet;

public class RuleSet {
    ArrayList<Rule>list;
    public RuleSet(){
        list=new ArrayList<>();
    }
    public void init(){
        list.add(new Rule(new ArrayList<String>(){{add("头疼");}},"感冒"));
        list.add(new Rule(new ArrayList<String>(){{add("喉喽疼");}},"咽喉炎"));
        list.add(new Rule(new ArrayList<String>(){{add("肚子疼");}},"肠胃炎"));
        list.add(new Rule(new ArrayList<String>(){{add("头晕");add("喉喽疼");}},"流感"));
        list.add(new Rule(new ArrayList<String>(){{add("头疼");add("喉喽疼");}},"发烧"));
        list.add(new Rule(new ArrayList<String>(){{add("感冒");add("发烧");}},"没救了!"));
    }
    public String ratiocinate(HashSet<String>set){
        String result=new String();
        int count=0;
        while(true){
            int p=0;
            for(Rule rule:list){
                if(rule.match(set)){
                    result=rule.result;
                    set.add(result);//如果匹配则把推理出的内容加到里面
                    p++;
                }
            }
            if(p==count)//发现推理完成
                break;
            else
                count=p;
        }
        return result;
    }
}
