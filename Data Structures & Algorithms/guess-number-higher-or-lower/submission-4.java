/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int L = 1;
        int R = n;
        while (L <= R) {
            int num = L + (R - L) / 2;
            int res = guess(num);
            if (res > 0) {
                L = num + 1;
            } else if (res < 0) {
                R = num - 1;
            } else {
                return num;
            }
        }
        return -1;
    }
}