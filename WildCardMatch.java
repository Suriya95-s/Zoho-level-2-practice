public class WildCardMatch {
    public static void main(String[] args) {
        String s1 = "*";
        String s2 = "aa";
        System.out.println(matchCard(s1,s2));
    }

    static boolean matchCard(String s1,String s2)
    {
        int n=s1.length();
        int m =s2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        //here if the first char is * it take 0 length as true also so make it true
        for(int i=1;i<n+1;i++)
        {
            if(s1.charAt(i-1) == '*')
            {
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1) == '?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1) == '*')
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        if(dp[n][m] == 1)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
//50:25.2 - 30mins