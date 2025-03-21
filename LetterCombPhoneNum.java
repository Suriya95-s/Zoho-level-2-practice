import java.util.ArrayList;
import java.util.List;

public class LetterCombPhoneNum {
    public static void main(String[] args) {
        mobPad(" ", "79");
        System.out.println(solve("","79"));
        System.out.println(mobPadCount("","23"));
        //edge case
        // if(digits.length() == 0)
        //        {
        //            ArrayList<String> list = new ArrayList<>();
        //            return list;
        //        }
        //        return solve("",digits);
    }

    static void mobPad(String proc, String unproc) {
        if (unproc.isEmpty()) {
            System.out.println(proc);
            return;
        }

        int digit = unproc.charAt(0) - '0';//convert "2" to 2

        int i=(digit-2) * 3;
        if(digit > 7)
        {
            i += 1;
        }
        int len = i+3;

        if(digit == 7 || digit == 9)
        {
            len += 1;
        }

        for(;i<len;i++)
        {
            char ch = (char) ('a' + i);
            mobPad(proc+ch,unproc.substring(1));
        }
    }

    static int mobPadCount(String proc, String unproc) {
        if (unproc.isEmpty()) {
            return 1;
        }

        int digit = unproc.charAt(0) - '0';//convert "2" to 2

        int i=(digit-2) * 3;
        if(digit > 7)
        {
            i += 1;
        }
        int len = i+3;

        if(digit == 7 || digit == 9)
        {
            len += 1;
        }
        int count =0;
        for(;i<len;i++)
        {
            char ch = (char) ('a' + i);
            count = count + mobPadCount(proc+ch,unproc.substring(1));
        }
        return count;
    }

    public static List<String> solve(String ans, String ip) {

        if (ip.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        int digit = ip.charAt(0) - '0';
        int i = (digit - 2) * 3;
        if (digit > 7) {
            i += 1;
        }
        int len = i + 3;
        if (digit == 7 || digit == 9) {
            len += 1;
        }

        ArrayList<String> list = new ArrayList<>();

        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            list.addAll(solve(ans + ch, ip.substring(1)));
        }
        return list;

    }
}