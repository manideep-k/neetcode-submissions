class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int L = 0;
        int R = Arrays.stream(piles).max().getAsInt();
        int minK = 0;
        while (L <= R) {
            int k = L + (R - L) / 2;
            int guess = getEatingSpeed(piles, k);
            if (guess <= h) {
                minK = k;
                R = k - 1;
            } else {
                L = k + 1;
            }
        }
        return minK;
    }
    
    private static int getEatingSpeed(int[] piles, int k) {
        if (k == 0) {
            return Integer.MAX_VALUE;
        }
        int hours = 0;
        for (int pile : piles) {
            hours = hours + Math.ceilDiv(pile, k);
        }
        return hours;
    }
}
