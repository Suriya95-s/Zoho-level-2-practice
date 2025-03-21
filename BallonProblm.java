import java.util.*;

public class BallonProblm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        char[] ballon = new char[N];
        for(int i=0;i<ballon.length;i++)
        {
            ballon[i] = scan.next().charAt(0);
        }

        List result = oddBallonOut(ballon);
        System.out.println(result.toString());

    }

    static List oddBallonOut(char[] ballon)
    {
        int n = ballon.length;
        List<Character> list = new ArrayList<>();
        Map<Character,Integer> bmap = new HashMap<>();
        for(char i : ballon)
        {
            bmap.put(i,bmap.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Character,Integer> map : bmap.entrySet())
        {
            if(map.getValue() % 2 != 0)
            {
                list.add(map.getKey());
            }
        }
        return list;
    }
}
