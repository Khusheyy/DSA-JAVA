import java.lang.reflect.Array;
import java.util.ArrayList;

public class permutation101 {
    public static void main(String[] args) {
         ArrayList<String> ans = permutationslist("","abc");
         System.out.println(ans);
         System.out.println(permutationscount("","abc"));

}

    // we basically only print the number of possible ways
    // the string can be arranged by changing the positions of the chars
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s ,up.substring(1));
        }
    }


    static ArrayList<String> permutationslist(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationslist(f + ch + s ,up.substring(1)));
        }
        return ans;
    }

    //what if we wanna display the count , the number of answers we got
    static int permutationscount(String p, String up){
        if(up.isEmpty()){
            return 1;
            // thus returns 1 when up is empty , bc we found an ans in p,adds 1 to it
        }
        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            count = count + permutationscount(f + ch + s ,up.substring(1));
        }
        return count;
    }



}
