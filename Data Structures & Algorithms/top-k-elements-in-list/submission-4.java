class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        
        for (int num : nums) {
            count.compute(num, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return v + 1;
            });
        }
        for (int i = 0; i <= freq.length - 1; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int value = entry.getValue();
            freq[value].add(num);
        }

        int[] topK = new int[k];
        int kPointer = k;
        for (int i = freq.length - 1; i >= 0 ; i--) {
            List<Integer> elem = freq[i];
            if (elem.isEmpty()) {
                continue;
            }
            for (Integer num : elem) {
                topK[kPointer - 1] = num;
                kPointer--;
                if (kPointer == 0) {
                    return topK;
                }
            }
        }
        return topK;
    }
}
