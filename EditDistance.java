public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 ="ros";
        System.out.println(minEdit(s1,s2));
    }

    static int minEdit(String s1,String s2)
    {
        int n=s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<m+1;i++)
        {
            dp[0][i]=i;
        }

        for(int j=0;j<n+1;j++)
        {
            dp[j][0] = j;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}
//Time taken 20:07