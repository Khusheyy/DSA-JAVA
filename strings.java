public class strings {
    //approach 1
    static void skip_apple(String p, String og) {
        //base case

        if (og.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = og.charAt(0);

        if (ch == 'a') {
            skip_apple(p, og.substring(1));
        } else {
            skip_apple(p+ ch, og.substring(1));
        }
    }


    //approach 2
    //herw we take only one parameter string as our argument, here we RETURN  the answer via recursion calls
    static String skipA(String name){
        if (name.isEmpty()) {
            return "";
        }

        char ch = name.charAt(0);

        if (ch == 'a') {
             return skipA(name.substring(1));
        } else {
            return  ch + skipA(name.substring(1));
        }

    }

    static String skip_apple(String name){
        if (name.isEmpty()) {
            return "";
        }


        if (name.startsWith("apple")) {
            return skip_apple(name.substring(5));
        } else {
            return  name.charAt(0) + skip_apple(name.substring(1));
        }

    }

    static String skipAppNotApple(String name){
        if (name.isEmpty()) {
            return "";
        }


        if (name.startsWith("app") && !name.startsWith("apple")) {
            return skipAppNotApple(name.substring(3));
        } else {
            return  name.charAt(0) + skipAppNotApple(name.substring(1));
        }

    }


    public static void main(String[] args) {
        String name = "baccad";
        System.out.println(skipAppNotApple("baccappfgh"));
    }
}
