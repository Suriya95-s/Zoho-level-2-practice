import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//class to store row,col,time
class Pair{
    int row;
    int col;
    int tm;
    Pair(int _r,int _c,int _t)
    {
        this.row = _r;
        this.col = _c;
        this.tm = _t;
    }
}
public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangeRot(grid));
    }

    public static int orangeRot(int[][] grid)
    {
        //sizes of the matrix
        int n = grid.length;
        int m = grid[0].length;
        //fresh orange counter
        int cntFresh=0;
        //we need a queue to store the values and we use a datastructure class to store row,col and time
        Queue<Pair> q = new LinkedList<>();
        //also create a visited array to mark the visited rotten nodes
        int[][] visited = new int[n][m];
        //now iterate the the matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1)
                {
                    visited[i][j]=0;
                    cntFresh++;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }

        // now we can iterate over the queue but first we can define the delta row and delta col
        int[] drow = {-1,0,1,0};
        int[] dcol ={0,1,0,-1};
        //calculating max time
        int tmx =0;
        //define variables to store row,col,time
        int r=0,c=0,t=0;
        int cnt=0;
        while(!q.isEmpty())
        {
            r=q.peek().row;
            c=q.peek().col;
            t=q.peek().tm;
            q.remove();
            tmx = Math.max(tmx,t);
            int nrow=0,ncol=0;
            //checking a value of r in four direction using delta values we check for 4 direction so
            for(int i=0;i<4;i++)
            {
                nrow = r + drow[i];
                ncol = c + dcol[i];

                //check the conditions
                if(nrow>=0 && nrow<n && ncol>=0 && ncol <m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0)
                {
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=2;
                    cnt++;
                }
            }
        }

        //check cnt anc cntFresh to check all the frsh oranges are roten or not
        if(cnt==cntFresh)
        {
            return tmx;
        }
        return -1;
    }
}
