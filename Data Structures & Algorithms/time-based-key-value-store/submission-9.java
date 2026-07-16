class TimeMap {

    private final Map<String, Pair[]> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        map.compute(key, (k, v) -> {
            List<Pair> list;
            if (v == null) {
                v = new Pair[0];
            }
            list = new ArrayList<>(Arrays.asList(v));
            list.add(new Pair(timestamp, value));
            return list.toArray(new Pair[0]);
        });
    }

    public String get(String key, int timestamp) {
        Pair[] values = map.get(key);
        if (values == null) {
            return "";
        } else {
            int L = 0;
            int R = values.length - 1;
            Pair res = null;
            while (L <= R) {
                int mid = (R + L) / 2;
                int val = values[mid].left;
                if (timestamp < val) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                    res = values[mid];
                }
            }
            return res != null ? res.right : "";
        }
    }

    private record Pair(Integer left, String right) {

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }

    }
}
