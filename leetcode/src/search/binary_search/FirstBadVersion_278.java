package search.binary_search;

public class FirstBadVersion_278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(9));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static boolean isBadVersion(int v) {
        return v >= 4;
    }
}
