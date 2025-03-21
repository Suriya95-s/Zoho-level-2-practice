import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums={0,2,3,4,6,8,9};
        List<String> list = summaryRanges(nums);
        System.out.println(list.toString());

    }
    public static  List<String> summaryRanges(int[] nums) {
        int n=nums.length;
//        if(n<=1)
//        {
//            List<String> list = new ArrayList<>();
//            String str = Arrays.toString(nums);
//            return list.add(str);
//        }

        int start =nums[0];
        int end=nums[0];
        List<String> result = new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            if(nums[i] == end+1)
            {
                end = nums[i];
            }
            else if(start==end)
            {
                result.add(start + "");
                start = nums[i];
                end= nums[i];
            }
            else{
                result.add(start +"->"+ end);
                start= nums[i];
                end=nums[i];
            }

            if(i+1==n && nums[i] != end+1)
            {
                end = nums[i];
                result.add(end+"");
            }
        }
        return result;
    }
}
