public class MaximumAverageSubarray_643 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int[] negativeNum = {-1};
        int[] num = {5};
        int[] numss = {0, 1, 1, 3, 3};

        System.out.println(findMaxAverage(nums, 4));
        System.out.println(findMaxAverage(negativeNum, 1));
        System.out.println(findMaxAverage(num, 1));
        System.out.println(findMaxAverage(numss, 4));
    }

    // sliding window - fixed
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int l = 0; l < k; l++) {
            sum = sum + nums[l];
        }

        int maxSum = sum;

        for (int r = k; r < nums.length; r++) {
            sum = sum + nums[r] - nums[r - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static double findMaxAverageNotOptimized(int[] nums, int k) {
        double average = 0;
        int l = 0;
        int r = k;

        if (nums.length <= k) {
            int sum = 0;
            for (int num : nums) {
                sum = sum + num;
            }
            return (double) sum / nums.length;
        }

        while (r <= nums.length) {
            int sum = 0;
            for (int i = l; i < r; i++) {
                sum = sum + nums[i];
            }

            average = Math.max(average, ((double) sum / k));

            l++;
            r++;
        }

        return average;
    }
}
