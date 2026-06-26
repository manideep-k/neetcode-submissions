class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int L = 0;
        int R = matrix.length - 1;
        while (L <= R) {
            int mid = (R + L) / 2;
            int[] row = matrix[mid];
            System.out.println(Arrays.toString(row));
            if (row[0] <= target && target <= row[row.length - 1]) {
                return binarySearch(row, target);
            } else if (row[0] > target) {
                R = mid - 1;
            } else if (row[0] < target) {
                L = mid + 1;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = (R + L) / 2;
            int val = nums[mid];
            if (val > target) {
                R = mid - 1;
            } else if (val < target) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
