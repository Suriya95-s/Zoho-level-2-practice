import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isSolve(board));
    }

    static boolean isSolve(char[][] board)
    {
        Set<String> seen = new HashSet<>();
        int n=board.length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                char num = board[i][j];
                if(num != '.')
                {
                    String rowKey ="row"+i+"-"+num;
                    String colKey  ="col"+j+"-"+num;
                    String BoxVal = "box"+(i/3)+(j/3)+"-"+num;

                    if(!seen.add(rowKey)||!seen.add(colKey)||!seen.add(BoxVal))
                    {
                        return false;
                    }
                }


            }
        }
        return true;
    }
}
