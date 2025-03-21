import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //take the transpose of the matrix
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse the row in the matrix
        for(int i=0;i<n;i++)
        {
            if(n%2==0)
            {
                for(int j=0;j<(n/2);j++)
                {
                    int temp = matrix[i][n-j-1];
                    matrix[i][n-j-1] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
            else{
                for(int j=0;j<=(n/2);j++)
                {
                    int temp = matrix[i][n-j-1];
                    matrix[i][n-j-1] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
