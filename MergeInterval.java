import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    public static void main(String[] args) {
        int n=4;
        int[][] interval = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
       int[][] val = mergeInterval(interval);
       for(int i=0;i<val.length;i++)
       {

               System.out.print("["+val[i][0]+","+val[i][1]+"]");
       }
    }

    static int[][] mergeInterval(int[][] intervals)
    {
        int n= intervals.length;
        if(n<=1)
        {
            return intervals;
        }
        //sort the array
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        ArrayList<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        //traverse the intervals and check the end of first interval and start of second interval
        for(int[] interval : intervals)
        {
            if(interval[0] <= newInterval[1])
            {
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
