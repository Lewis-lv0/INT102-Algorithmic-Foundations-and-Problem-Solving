/*
 * @Author: Yixing
 * @Date: 2021-03-14 11:37:27
 * @Description: String Pattern Searching Algorithms taught in INT102
 */

public class StringPatternSearch {

    /**
     * @description: brute force method The time complexity is (n-m+1)m = O(nm)
     * @param {String} text
     * @param {String} pattern
     * @return {*}
     */
    public static void StrMatch(String text, String pattern) {
        String[] txt = text.split("");
        String[] pat = pattern.split("");
        for (int i = 0; i < txt.length - pat.length + 1; i++) {
            int j = 0;
            while (pat[j].equals(txt[i + j])) {
                j++;
                if (j == pat.length) {
                    System.out.println("The String is found!");
                    return;
                }
            }
        }
        System.out.println("The String is not found!");
    }

    /**
     * @description: Horspool's algorithm construct shift table
     * @param {String} text
     * @param {String} pattern
     * @return whether it contains pattern string
     */
    public static void Horspool(String text, String pattern) {
        int[] ShiftTable = ShiftTable(pattern);
        char[] s = text.toCharArray();
        char[] p = pattern.toCharArray();
        int k = 0, length = p.length;
        for (int i = length - 1; i < s.length;) {
            k = 0;
            while ((k < length) && (p[length - 1 - k] == s[i - k])) {
                k++;
            }
            if (k == length) {
                System.out.println("The pattern has been found!");
                return;
            } else {
                i += ShiftTable[s[i]];
            }
        }
        System.out.println("The string pattern has not been found!");
    }

    /**
     * @description: Construct shift table for Horspool's algorithm
     * @param {String} pattern
     * @return {int[]} table
     */
    private static int[] ShiftTable(String pattern) {
        int size = 127; // 127 characters in ASCII reference
        char[] p = pattern.toCharArray();
        int length = p.length;
        int[] table = new int[size];
        // initialize the values to be the length of the pattern
        for (int i = 0; i < size; i++) {
            table[i] = length;
        }
        // construct the shift table
        for (int i = 0; i < p.length - 1; i++) {
            table[p[i]] = length - i - 1;
        }
        return table;
    }


    // test demo
    public static void main(String[] args) {
        String text = "I am a handsome guy! I love my gf!";
        String pattern = "handsome";
        StrMatch(text, pattern);
        Horspool(text, pattern);
    }

}
