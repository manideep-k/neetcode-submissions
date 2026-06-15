class HitCounter {

    private final Queue<Integer> counter = new LinkedList<>();

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        counter.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!counter.isEmpty()) {
            int diff = timestamp - counter.peek();
            if (diff >= 300) {
                counter.remove();
            } else {
                break;
            }
        }
        return counter.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
