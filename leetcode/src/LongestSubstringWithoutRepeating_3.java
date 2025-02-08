import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating_3 {
    public static void main(String[] args) {
        var s = "abcabcbb";
        var ss = "bbbbb";
        var sss = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(ss));
        System.out.println(lengthOfLongestSubstring(sss));
    }

    // sliding window - dynamic
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int l = 0;
        int r = 0;

        Set<Character> charSet = new HashSet<>();

        while (r < s.length()) {
            var curr = s.charAt(r);

            // if right letter is already in set
            // shrink left until all of the same letter has been removed
            while (charSet.contains(curr)) {
                charSet.remove(s.charAt(l));
                l++;
            }

            // if its not, add to set and calc max length
            charSet.add(curr);
            length = Math.max(length, r - l + 1);

            // keep expanding right
            r++;
        }

        return length;
    }
}
