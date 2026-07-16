class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.remove();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.remove();
        }
        return !queue.isEmpty() ? queue.peek() : -1;
    }
}
