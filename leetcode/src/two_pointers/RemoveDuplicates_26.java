package two_pointers;

import java.util.HashMap;

public class RemoveDuplicates_26 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int response = removeDuplicates(nums);

        System.out.println(response);
    }

    // two pointers
    public static int removeDuplicates(int[] nums) {
        var numMap = new HashMap<Integer, Integer>();

        int p1 = 0;
        int c = 0;

        while (p1 < nums.length) {
            int current = nums[p1];

            if (!numMap.containsKey(current)) {
                nums[c] = current;
                numMap.put(current, 1);
                c++;
            }

            p1++;
        }

        return c;
    }
}
