import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
//        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] result = setZeros(matrix);

        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<result[0].length;j++)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] setZeros(int[][] matrix)
    {
        int m = matrix.length;
        int n= matrix[0].length;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0 && visited[i][j] ==0)
                {
                    visited[i][j]=1;
                   for(int k=0;k<m;k++)
                   {
                       if(matrix[k][j] ==0 && visited[k][j]==0)
                       {
                           break;
                       }
                       matrix[k][j]=0;
                       visited[k][j]=1;
                   }
                   for(int l=0;l<n;l++)
                   {
                       if(matrix[i][l] == 0 && visited[i][l] == 0)
                       {
                           break;
                       }
                       matrix[i][l] =0;
                       visited[i][l]=1;
                   }
                }
            }
        }
        return matrix;
    }

//    static void dfs(int i,int j, int[][]matrix,int[][] visited)
//    {
//        if(i<0 || i >= matrix.length ||j<0 || j>= matrix[0].length || visited[i][j] == 1 )
//        {
//            return;
//        }
//        if(matrix[i][j] == 0)
//        {
//            return;
//        }
//        matrix[i][j]=0;
//        visited[i][j] =1;
//
//    }
}
