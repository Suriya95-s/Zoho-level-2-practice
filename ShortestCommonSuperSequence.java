public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        System.out.println(LongComSubseq(s1,s2));
    }

    //Apply LCS - Longest Common Subsequence first
    static String LongComSubseq(String s1,String s2)
    {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        String res = ShortComSuperseq(dp,n,m,s1,s2);
        return res;
    }

    // find shortest common super sequence by backtracking the dp table and applying some logic

    static String ShortComSuperseq(int[][] dp,int n, int m, String s1,String s2)
    {
        int i=n,j=m;
        StringBuilder scs = new StringBuilder();
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                scs.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
            {
                scs.append(s1.charAt(i-1));
                i--;
            }
            else{
                scs.append(s2.charAt(j-1));
                j--;
            }
        }

        while(i>0)
        {
            scs.append(s1.charAt(i-1));
            i--;
        }

        while(j>0)
        {
            scs.append(s2.charAt(j-1));
            j--;
        }

        return scs.reverse().toString();
    }
}
