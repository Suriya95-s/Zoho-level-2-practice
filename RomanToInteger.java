import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
//        System.out.println(convertRomToInt("MCMXC"));ans not proper
        System.out.println(convertRomToInt("MDCL"));
        System.out.println(convertRomToInt("LVIII"));
    }

    static int convertRomToInt(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int value =0;
        for (int i=0;i<str.length();i++) {
            if (map.containsKey(str.charAt(i))) {
                value += map.get(str.charAt(i));
            }
        }
        return value;
    }
}
