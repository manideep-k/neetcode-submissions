class Solution {
    public int search(int[] nums, int target) {
        /*
         * 1 2 3 4 5 6  | l=1,m=3,r=6 L-(m>l && m<r)(l<r)
         * 6  1 2 3 4 5 | l=6,m=2,r=5 R-(m<l && m<r)(l>r)
         * 5 6  1 2 3 4 | l=5,m=1,r=4 R-(m<l && m<r)(l>r)
         * 4 5 6  1 2 3 | l=4,m=6,r=3 R-(m>l && m>r)(l>r)
         * 3 4 5 6  1 2 | l=3,m=5,r=2 R-(m>l && m>r)(l>r)
         * 2 3 4 5 6  1 | l=2,m=4,r=1 R-(m>l && m>r)(l>r)
         * 1 2 3 4 5 6  | l=1,m=3,r=6 L-(m>l && m<r)(l<r)
         * L
         *  m>l && m<r
         * R
         *  m<l && m<r
         *  m>l && m>r
         */
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            int numM = nums[M];
            int numL = nums[L];
            int numR = nums[R];
            if (target == numM) {
                return M;
            }
            if (numM >= numL && numM <= numR) {
                if (target < numM) {
                    System.out.println("Condition 1(R)");
                    R = M - 1;
                } else {
                    System.out.println("Condition 1(L)");
                    L = M + 1;
                }
            } else if (numM <= numL && numM <= numR) {
                if (target >= numM && target <= numR) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            } else if (numM >= numL && numM >= numR) {
                if (target <= numM && target >= numL) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            }
        }
        return -1;
    }
}
