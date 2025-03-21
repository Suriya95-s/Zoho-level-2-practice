import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RayMatrix {
    static char[][] aMatrix;
    static Set<String> atomPos = new HashSet<>();
    static int rows;
    static int cols;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        rows = scan.nextInt();
        cols = scan.nextInt();
        aMatrix = new char[rows][cols];
        for(int i=0;i<rows;i++)
        {
            Arrays.fill(aMatrix[i],'-');
        }
        int noAtoms = scan.nextInt();
        for(int i=0;i<noAtoms;i++)
        {
            int rowposv = scan.nextInt();
            int colposv = scan.nextInt();
            int rowIndex = convertRow(rowposv);
            int colIndex = colposv -1;
            AtomPosition(rowIndex,colIndex);
        }

        int noRays = scan.nextInt();
        for(int i=0;i<noRays;i++)
        {
            String ray = scan.next();
            processRay(ray);
        }

        for(int i=0;i<aMatrix.length;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(aMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int convertRow(int rowpos)
    {
        return rows - rowpos;
    }

    private static void AtomPosition(int rInd,int cInd)
    {
        aMatrix[rInd][cInd]='X';
        atomPos.add(rInd + "," + cInd);
    }

    private static void processRay(String rayPos)
    {
        if(rayPos.startsWith("R"))
        {
            int rowInd = convertRow(Integer.parseInt(rayPos.substring(1)));
            for(int c=0;c<cols;c++)
            {
                //check hit
                if(atomPos.contains(rowInd + "," + c))
                {
                    aMatrix[rowInd][c] = 'H';
                    break;
                }
                //check reflection
                if(isReflect(rowInd,c))
                {
                    aMatrix[rowInd][c] = 'R';
                    break;
                }
                if(isRefract(rowInd,c))
                {
                    aMatrix[rowInd][c] = 'F';
                    break;
                }
            }
        }

        else if(rayPos.startsWith("C"))
        {
            int colInd = convertRow(Integer.parseInt(rayPos.substring(1)))-1;
            for(int r=rows-1;r>=0;r--)
            {
                //check hit
                if(atomPos.contains(r + "," + colInd))
                {
                    aMatrix[r][colInd] = 'H';
                    break;
                }
                //check reflection
                if(isReflect(r,colInd))
                {
                    aMatrix[r][colInd] = 'R';
                    break;
                }
                if(isRefract(r,colInd))
                {
                    aMatrix[r][colInd] = 'F';
                    break;
                }
            }
        }
    }
    //refraction if two atoms are diagonally adjacent
    private static boolean isRefract(int rowInd, int c) {
        return ((atomPos.contains((rowInd - 1)+","+(c-1))) ||
                (atomPos.contains((rowInd - 1)+","+(c+1))) ||
                (atomPos.contains((rowInd + 1)+","+(c-1))) ||
                (atomPos.contains((rowInd + 1)+","+(c+1)))
        );
    }

    //reflection if two atoms are  at both diagonals
    private static boolean isReflect(int rowInd, int c) {
        return (((atomPos.contains((rowInd - 1)+","+(c-1))) &&
                (atomPos.contains((rowInd - 1)+","+(c+1))) )||
                ((atomPos.contains((rowInd + 1)+","+(c-1))) &&
                (atomPos.contains((rowInd + 1)+","+(c+1))))
                );
    }
}
