import java.lang.reflect.Array;
import java.util.*;
public class subseq {
    public static void main(String[] args) {
        ArrayList<String> ans = subseqascii("","abc");
        System.out.println(ans);
    }

    static void subseq(String p,String up){
        //base case
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        //here every char has 2 possibility either take it or leave it
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

    //you can also take an arraylist as well
    static ArrayList<String> subseqret(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subseqret(p+ch,up.substring(1));
        ArrayList<String> right = subseqret(p,up.substring(1));
        left.addAll(right);
        return left;

        //[abc, ab, ac, a, bc, b, c, ]
        //this will add all the possible subsets to the list
    }

    //to find the ascii of any charecter just do (ch+0); or (int)ch


    static ArrayList<String> subseqascii(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> first = subseqascii(p + ch, up.substring(1));
        ArrayList<String> second = subseqascii(p, up.substring(1));
        ArrayList<String> third = subseqascii(p + (ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;

        //output:
        //[abc, ab, ab99, ac, a, a99, a98c, a98, a9899, bc, b, b99, c, , 99, 98c, 98, 9899, 97bc, 97b, 97b99, 97c, 97, 9799, 9798c, 9798, 979899]
    }


}
