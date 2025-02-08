package two_pointers;

public class TwoSumII_167 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};

        var sumNumbers = twoSum(numbers, 9);
        for (int n : sumNumbers) {
            System.out.print(n);
        }
    }

    // two pointers
    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;

        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];

            if (sum == target) {
                return new int[]{p1 + 1, p2 + 1};
            }
            else if (sum < target) {
                p1++;
            }
            else {
                p2--;
            }
        }

        return new int[]{};
    }
}
