package two_pointers;

public class ReverseString_344 {

    public static void main(String[] args) {
        char[] myString = {'h', 'e', 'l', 'l', 'o'};

        var response = reverseString(myString);
        for (char c : response) {
            System.out.print(c);
        }
    }

    // two pointers
    public static char[] reverseString(char[] s) {
        int p1 = s.length - 1;
        int p2 = 0;

        // switching last/first in-place til 2 pointers meet
        while (p1 > p2) {
            var last = s[p1];
            var first = s[p2];
            s[p2] = last;
            s[p1] = first;

            p1--;
            p2++;
        }

        return s;
    }

    // wrong - must modify the input array in-place
    public static void reverseStringW(char[] s) {
        char[] r = new char[s.length];

        int p1 = s.length - 1;
        int p2 = 0;

        while (p1 >= 0) {
            var current = s[p1];
            r[p2] = current;

            p1--;
            p2++;
        }

        for (char c : r) {
            System.out.print(c);
        }
    }
}
