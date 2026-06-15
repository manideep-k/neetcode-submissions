class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        int[] prev = null;
        for (int i = 0; i <= intervals.length - 1; i++) {
            int[] interval = intervals[i];
            // lastEnd - curStart <= 0 ---> Overlapped
            if (prev == null || prev[1] < interval[0]) {
                // No overlap — start a new interval
                prev = interval;
                System.out.println("Added: " + Arrays.toString(prev));
                output.add(prev);
            } else {
                // Overlap — extend the current merged interval
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
