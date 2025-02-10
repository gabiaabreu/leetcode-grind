package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {9, 0, 5, 6, 1, 2, 4};

        var ordered = bubbleSort(nums);

        for(int n : ordered) {
            System.out.println(n);
        }
    }

    public static int[] bubbleSort(int[] nums) {
        int size = nums.length;
        boolean swapped;

        // full iterations
        for (int num : nums) {
            swapped = false;

            // number comparisons in iteration
            for (int i = 0; i < size - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    var big = nums[i];
                    var small = nums[i + 1];
                    nums[i] = small;
                    nums[i + 1] = big;

                    swapped = true;
                }
            }

            // if no number swapping in iteration, its already ordered
            if (!swapped) break;
        }

        return nums;
    }

}
