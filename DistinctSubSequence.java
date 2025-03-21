public class DistinctSubSequence {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        System.out.println(distSeq(s1,s2));
    }

    static int distSeq(String s1,String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<n+1;i++)
        {
            dp[0][i] = 1;
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s2.charAt(i-1) == s1.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
// 25 mins