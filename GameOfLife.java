public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        lifeOrDeath(board);
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] directions = {{1,0},{-1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static void lifeOrDeath(int[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 1)
                {
                    int activecell = getActiveCell(board,i,j);
                    if(activecell<2||activecell>3)
                    {
                        board[i][j] = -2;
                    }
                }
                else if(board[i][j] == 0)
                {
                    int activeneighbor = getActiveCell(board,i,j);
                    if(activeneighbor == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
        updateBoard(board);
        return;
    }

    private static void updateBoard(int[][] board) {
        for(int i=0;i< board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==-2)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j]==3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }

    static int getActiveCell(int[][] board,int r,int c)
    {
        int activeCount=0;
        for(int[] direction : directions)
        {
            int nrow = r + direction[0];
            int ncol = c + direction[1];

            if(nrow >=0 && nrow<board.length && ncol >=0 && ncol < board[0].length && (board[nrow][ncol]==-2 || board[nrow][ncol] == 1))
            {
                activeCount++;
            }
        }
        return activeCount;
    }
}
