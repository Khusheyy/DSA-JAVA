import java.util.*;
import java.util.Arrays;

public class Comparison {
    public static void main(String[] args) {
       // String  a = "kunal";
        //String b = "kunal";
        //System.out.println(a==b);
        // returns true bc a and b both point to kunal in the string pool in heap
        //== operator will bascially check for the refrerence
        // variable to be pointing to the same object

//    String name1 = new String("kunal");
//    String name2 = new String("kunal").intern();
//
//    //System.out.println(name1==name2);
//    //prints false bc both are not pointing to the same object
//    String name = new String("kunal").intern();
//
//    System.out.println(name2==name);


//        System.out.println(78);
//        System.out.println(Arrays.toString(new int[]{2,3,4,5,6}));
//
//        //pretty printing
//        float num = 234.72188f;
//        System.out.printf("the formattted number is %.2f",num);
//        System.out.println();
//        System.out.printf("the value of pie:  %.2f",Math.PI);
//        System.out.println();
//        System.out.printf("heloo my name is %s and i am %s", "kittu" , "cool");
//      // place holders types in java

//        There are many format specifiers we can use. Here are some common ones:
//
//                %c - Character
//                %d - Decimal number (base 10)
//                %e - Exponential floating-point number
//                %f - Floating-point number
//                %i - Integer (base 10)
//                %o - Octal number (base 8)
//                %s - String
//                %u - Unsigned decimal (integer) number
//                %x - Hexadecimal number (base 16)
//                %t - Date/time
//                %n - Newline
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println((char)('a'+1));
        System.out.println("a"+ 2);
        //here the int will be converted to Integer wrapper class that calls .tostring()

        System.out.println("kunal"+ new ArrayList<>());
        System.out.println("hiii"+new Integer(67));
        System.out.println(new ArrayList<>() +""+ new Integer(56));
        //only works if there is a string among them

        String series="";
        for (int i = 0; i <26 ; i++) {
            char ch = (char)('a'+ i);
            //System.out.println(ch);
            series = series + ch;
            System.out.println(series);
        }
        //System.out.println(series);
        // ere we are creating new objects again and again , thus uses more memory and thus is not effective
        // a, ab,abc,abcd.abcde,.....,abcdef....y HAVE NO REFRENCE VARIABLE POINTING TO THEM
        //O(N2)

    }
}
