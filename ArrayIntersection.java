import java.util.ArrayList;
import java.util.List;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 ={1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8,20};
        System.out.println(checkArrIntersect(arr1,arr2));
    }

    static List<Integer> checkArrIntersect(int[] arr1, int[] arr2)
    {
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList();
        while (i<=arr1.length-1 && j<=arr2.length-1)
        {
            if(arr1[i] == arr2[j])
            {
                list.add(arr1[i]);
            }
            if(arr1[i] < arr2[j])
            {
                i++;
            }
            else{
                j++;
            }
        }
        return list;
    }
}
