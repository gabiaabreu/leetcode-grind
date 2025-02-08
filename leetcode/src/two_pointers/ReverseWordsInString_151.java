package two_pointers;

public class ReverseWordsInString_151 {

    public static void main(String[] args) {
        String s = "a good   example";
        String s2 = "  hello world  ";

        System.out.println(reverseWords(s));
        System.out.println(reverseWords(s2));
    }

    // two pointers
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        // slower alternative
        // String[] words = Arrays.stream(s.split("\\s+"))
        //        .filter(str -> !str.isEmpty())
        //        .toArray(String[]::new);

        var p1 = 0;
        var p2 = words.length - 1;

        while (p1 < p2) {
            var firstWord = words[p1];
            var lastWord = words[p2];

            words[p1] = lastWord;
            words[p2] = firstWord;

            p1++;
            p2--;
        }

        return String.join(" ", words);
    }
}
