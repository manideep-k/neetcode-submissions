class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        System.out.println(Arrays.toString(piles));
        int L = 0;
        int R = max(piles);
        int minK = 0;
        while (L <= R) {
            int k = (L + R) / 2;
            int timeTaken = timeTakenToEat(piles, k);
            if (timeTaken <= h) {
                minK = k;
                R = k - 1;
            } else {
                L = k + 1;
            }
        }
        return minK;
    }

    private static int max(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    private static int timeTakenToEat(int[] piles, int k) {
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
