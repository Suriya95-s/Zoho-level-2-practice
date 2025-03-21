import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] X = new int[N];
//        int N = 1;
//        int K = 17;
//        int[] X = new int[N];
//        X[0] = 35;
        for(int i=0;i<N;i++)
        {
            X[i] =scan.nextInt();
        }
        List result = dryWall(N,K,X);
        System.out.println(result.toString());
    }

    static List dryWall(int n,int k,int[] X)
    {
        int i=0;
        int count=0;
        List ans = new ArrayList<>();
        while(i<n)
        {
            int dtime = X[i];
            i++;
            if(k == dtime)
            {
                ans.add(dtime);
                return ans;
            }
            else if(dtime > k)
            {
                while(dtime != 0)
                {
                    dtime = dtime - k;
                    count = count+1;
                    if(dtime<=k)
                    {
                        count= count+1;
                        dtime=0;
                    }
                }
            }
            else {
                 ans.add(dtime);
                 return ans;
            }
        }
         ans.add(count);
        return ans;
    }
}
