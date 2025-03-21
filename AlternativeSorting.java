import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternativeSorting {
    public static void main(String[] args) {
        int[] arr = {7, 1, 2, 3, 4, 5, 6};
        System.out.println(sortAlt(arr));
    }

    static List<Integer> sortAlt(int[] arr)
    {
        int n=arr.length;
        int start=0;
        int end = n-1;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);

        while(start<end)
        {
            result.add(arr[end--]);
            result.add(arr[start++]);
        }
        if(n%2 != 0)
        {
            result.add(arr[start]);
        }
        return result;
    }
}
