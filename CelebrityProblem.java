public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat ={{0, 1, 0},
                      {0 ,0 ,0},
                      {0 ,1 ,0}};
        System.out.println(celebrity(mat));
    }
    public static int celebrity(int mat[][]) {

        //Most efficient and expected approach Two pointer approach with T.C-O(N) and S.C- O(1)
        int n=mat.length;
        int i=0,j=n-1;

        while(i<j)
        {
            if(mat[i][j] == 1)
            {
                i++;
            }
            else{
                j--;
            }
        }

        int c = j;

        for(int k = 0; k <n; k++)
        {
            if(c== k) continue;

            if(mat[c][k] != 0 || mat[k][c] == 0)
            {
                return -1;
            }
        }
        return c;

        //this is stack approach with time complexity O(N)and Space Complexity O(N)
//        Stack<Integer> stack = new Stack<>();
//        int n = mat.length;
//        for(int i=0;i<n;i++)
//        {
//            stack.push(i);
//        }
//
//        while(stack.size() > 1)
//        {
//            int a = stack.pop();
//            int b=stack.pop();
//            if(mat[a][b] != 0)
//            {
//                stack.push(b);
//            }
//            else{
//                stack.push(a);
//            }
//        }
//
//        int celeb = stack.pop();
//
//        //checking upto the index whether the celebrity of index knws someone (then he is not celeb)
//        //or whether someone knows him(if not he is not celeb)
//        for(int i=0;i<n;i++)
//        {
//            if(celeb==i)
//            {
//                continue;
//            }
//
//            if(mat[celeb][i] != 0 || mat[i][celeb] == 0)
//            {
//                return -1;
//            }
//        }
//        return celeb;



        //my first approach not efficient to pass all testcase
//        Stack<Integer> stack = new Stack<>();
//        int n=mat.length;
//        int ind=-1;
//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                if(mat[i][j]==1)
//                {
//                    if(!stack.isEmpty() && i==stack.peek())
//                    {
//                        stack.pop();
//                    }
//                    else {
//                        stack.push(j);
//                    }
//                }
//
//            }
//        }
//        if(stack.isEmpty())
//        {
//            return ind;
//        }
//        else{
//            ind = stack.pop();
//            return ind;
//        }
    }
}
