import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberSystem {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        int n = 10;
        System.out.println(FindNth(n));
    }

    static String FindNth(int n)
    {
        if(n<=0)
        {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("3");
        queue.add("4");
        String result ="";
        for(int i=1;i<=n;i++)
        {
            result = queue.poll();
            queue.add(result+"3");
            queue.add(result+"4");
        }
        return result;
    }
}
