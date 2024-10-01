import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// letter combination of a phone number
public class question {
    public static void main(String[] args) {
//        ArrayList<String> ans = displaylist("","12");
//        System.out.println(ans.size());
//        System.out.println(displaycount("","12"));
        System.out.println(letterCombinations("23"));

    }

    static void display(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';//this will convert '2' to 2
        for (int i = (digit-1)*3 ; i < (digit*3) ; i++) {
            char ch = (char) ('a' + i);
            display(p+ch,up.substring(1));
        }
    }

    static ArrayList<String> displaylist(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';//this will convert '2' to 2
        for (int i = (digit-1)*3 ; i < digit*3 ; i++) {
            char ch = (char) ('a' + i);
            list.addAll(displaylist(p+ch,up.substring(1)));
        }
        return list;
    }
    static int displaycount(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';//this will convert '2' to 2
        for (int i = (digit-1)*3 ; i < (digit*3) ; i++) {
            char ch = (char) ('a' + i);
            count = count + displaycount(p+ch,up.substring(1));
        }
        return count;
    }


    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        backtrack(digits,0,hm,new StringBuilder(),ans);
        return ans;
    }

    static void backtrack(String digits, int i, HashMap<Character, String> hm, StringBuilder sb, List<String> ans) {
        //base condition
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String curr = hm.get(digits.charAt(i));
        for (int k = 0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            backtrack(digits,i+1,hm,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
