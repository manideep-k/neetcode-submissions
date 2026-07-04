class Solution {
    public boolean isPalindrome(String s) {
        int L = 0;
        char[] chAr = s.toLowerCase().toCharArray();
        for (int R = s.length() - 1; R >= 0; R--) {
            System.out.println("R: " + R);
            L = skipAndGetPos(chAr, L, Op.inc);
            R = skipAndGetPos(chAr, R, Op.dec);
            System.out.println("L: " + L + ", lPos: " + L);
            System.out.println("R: " + R + ", rPos: " + R);
            char lChar = chAr[L];
            char rChar = chAr[R];
            if (!isAlphaNumeric(lChar) && !isAlphaNumeric(rChar)) {
                return true;
            }
            if (lChar != rChar) {
                System.out.println("L: " + L + ", char: " + lChar);
                System.out.println("R: " + R + ", char: " + rChar);
                return false;
            }
            if (L == R) {
                return true;
            }
            L++;
        }
        return true;
    }

    private static int skipAndGetPos(char[] arr, int pos, Op op) {
        char val = arr[pos];
        boolean skipped = false;
        while (!isAlphaNumeric(val)) {
            skipped = true;
            val = arr[pos];
            if (Op.inc.equals(op)) {
                if (pos == arr.length - 1) {
                    return pos;
                }
                pos++;
            } else {
                if (pos == 0) {
                    return pos;
                }
                pos--;
            }
        }
        if (!skipped) {
            return pos;
        }
        return Op.inc.equals(op) ? pos - 1 : pos + 1;
    }


    // [a-z] = [97-122]
    // [A-Z] = [65-90]
    // [0-9] = [48-57]
    private static boolean isAlphaNumeric(char c) {
        return (97 <= (int) c && (int) c <= 122) ||
                (65 <= (int) c && (int) c <= 90) ||
                (48 <= (int) c && (int) c <= 57);
    }

    private enum Op {
        inc, dec
    }
}
