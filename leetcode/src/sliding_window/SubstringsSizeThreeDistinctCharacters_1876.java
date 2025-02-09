package sliding_window;

public class SubstringsSizeThreeDistinctCharacters_1876 {
    public static void main(String[] args) {
        var s = "aababcabc";

        System.out.println(countGoodSubstrings(s));
    }

    // sliding window - fixed
    public static int countGoodSubstrings(String s) {
        int c = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            if (c1 != c2 && c2 != c3 && c1 != c3) {
                c++;
            }
        }

        return c;
    }
}
