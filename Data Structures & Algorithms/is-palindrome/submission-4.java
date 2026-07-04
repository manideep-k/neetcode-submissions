class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int L = 0;
        int R = arr.length - 1;
        while (L < R) {
            // If we were to use for-loop we would have to write a complex logic
            // for (int R = arr.length - 1; ...) will result in us reassigning the R value within the loop which is not at all ideal.
            while (L < R && !isAlphaNumeric(arr[L])) {
                L++;
            }
            // Without the L < R condition in these sub-while loops, it would run infinitely as it has no bound on where to stop.
            while (L < R && !isAlphaNumeric(arr[R])) {
                R--;
            }
            // Making sure to convert it to lower case before checking as 'a' and 'A' are same according to the question.
            // We could have made the string toLowerCase() and then checked but that would require another for loop which is not ideal.
            char lChar = Character.toLowerCase(arr[L]);
            char rChar = Character.toLowerCase(arr[R]);
            if (lChar != rChar) {
                return false;
            }
            // Instead of a traditional for-loop using while, so need to seek the pointers L & R
            L++;
            R--;
        }
        return true;
    }


    // [a-z] = [97-122]
    // [A-Z] = [65-90]
    // [0-9] = [48-57]
    private static boolean isAlphaNumeric(char c) {
        return (97 <= (int) c && (int) c <= 122) ||
                (65 <= (int) c && (int) c <= 90) ||
                (48 <= (int) c && (int) c <= 57);
    }
}
