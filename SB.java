import java.util.*;
public class SB {
    public static void main(String[] args) {
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i <26 ; i++) {
            char ch = (char) ('a' + i);
            obj.append(ch);
        }
        System.out.println(obj.toString());
       String name = "madam";
        System.out.println(ispalin(name));

    }
    static boolean ispalin(String str){
        str = str.toLowerCase();
        if( str==null || str.length()==0 ){
            return true;
        }
        for (int i = 0; i <str.length() / 2 ; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()- 1-i);

            if(start!=end){
                return false;
            }
        }
        return true;
    }
}
