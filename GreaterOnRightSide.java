import java.util.Arrays;

public class GreaterOnRightSide {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int[] result = nextGreat(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] nextGreat(int[] arr)
    {   int n = arr.length;
        if(n<=1)
        {
            return arr;
        }
        int rightgreat =-1;
        int currval =-1;
        for(int i=n-1;i>=0;i--)
        {
            rightgreat = Math.max(currval,rightgreat);
            currval = arr[i];
            arr[i] = rightgreat;
        }
        return arr;
    }
}
