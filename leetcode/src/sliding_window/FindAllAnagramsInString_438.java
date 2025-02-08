package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString_438 {
    public static void main(String[] args) {
        var s = "cbaebabacd";
        var p = "abc";

        var result = findAnagrams(s, p);
        for (var n : result) {
            System.out.println(n);
        }
    }

    // sliding window - fixed
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        if (s.length() < p.length()) return indexes;

        // map of target word letters + how many times they appear
        var goalMap = new HashMap<Character, Integer>();
        for (char c : p.toCharArray()) {
            goalMap.put(c, goalMap.getOrDefault(c, 0) + 1);
        }

        var searchMap = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            var right = s.charAt(r);
            searchMap.put(right, searchMap.getOrDefault(right, 0) + 1);

            // if window in the right size
            if (r - l == p.length() - 1) {
                if (searchMap.equals(goalMap)) { // found anagram
                    indexes.add(l);
                }

                // if not anagram, move window ->
                // remove 1 occurrence of left char, which will be left out
                var left = s.charAt(l);
                searchMap.put(left, searchMap.getOrDefault(left, 0) - 1);

                // if left char occurrence is now 0, remove from map
                if (searchMap.get(left) == 0) {
                    searchMap.remove(left);
                }

                // move left and right indexes
                l++;
            }
            r++;
        }

        return indexes;
    }
}
