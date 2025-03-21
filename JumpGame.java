public class JumpGame {
    public static void main(String[] args) {
        int[] nums ={3,2,1,0,4};
        System.out.println(maxJump(nums));
    }

    static boolean maxJump(int[] nums)
    {
        int n=nums.length;
        if(nums.length <=1)
        {
            return true;
        }
        int des = n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]+i >= des)
            {
                des = i;
            }
        }
        return des == 0;
    }
}
