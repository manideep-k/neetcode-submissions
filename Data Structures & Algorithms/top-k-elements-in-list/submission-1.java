class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int num : nums) {
            count.compute(num, (key, value) -> {
                if (value == null) {
                    value = 0;
                }
                return value + 1;
            });
        }

        for (int i = 0; i <= freq.length - 1; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] topK = new int[k];
        int kPointer = k;
        for (int i = freq.length - 1; i > 0; i--) {
            if (freq[i].isEmpty()) {
                continue;
            }
            for (Integer num : freq[i]) {
                topK[kPointer - 1] = num;
                kPointer = kPointer - 1;
                // Return topK elements
                if (kPointer == 0) {
                    return topK;
                }
            }
        }
        return topK;
    }
}
