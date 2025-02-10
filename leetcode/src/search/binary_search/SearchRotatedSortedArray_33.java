package search.binary_search;

public class SearchRotatedSortedArray_33 {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                // left part is ordered
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // right part is ordered
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
