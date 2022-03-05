import java.util.ArrayList;
import java.util.HashSet;


public class Rule {
    ArrayList<String> conditions;
    String result;
    public Rule(ArrayList<String>list,String s){
        conditions=list;
        s=result;
    }
    public boolean match(HashSet<String>k){
        for(String s:conditions){
            if(!k.contains(s))
                return false;
        }
        return true;
    }
}
