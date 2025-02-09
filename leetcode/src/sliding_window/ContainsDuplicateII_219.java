package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int r = 0; r < nums.length; r++) {
            if (window.contains(nums[r])) {
                return true;
            }

            window.add(nums[r]);

            if (window.size() > k) {
                window.remove(nums[r - k]);
            }
        }

        return false;
    }
}
