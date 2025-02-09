package sliding_window;

public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(7, nums));
    }

    // sliding window - dynamic
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (r < nums.length) {
            sum = sum + nums[r];

            // second while = condition given
            // if condition already met, start to shrink
            while (sum >= target) {
                // only alters minLength if current length is smaller
                minLength = Math.min(minLength, r - l + 1);
                sum = sum - nums[l];

                l++;
            }

            r++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
