package search.binary_search;

public class BinarySearch_704 {

    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) { // mid too low -> search to the right
                left = mid + 1;
            } else { // mid too high -> search to the left
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int curr = array[mid];

        if (curr == target) {
            return mid;
        } else if (curr > target) { // mid too high -> search to the left
            return binarySearchRecursive(array, target, left, mid - 1);
        } else { // mid too low -> search to the right
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }
}
