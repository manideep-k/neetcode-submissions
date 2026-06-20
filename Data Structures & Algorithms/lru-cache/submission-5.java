class LRUCache {
    private final LinkedList<CacheObj> cache; 
    private final HashMap<Integer, CacheObj> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheObj cacheObj = map.get(key);  // O(1) lookup
        cache.remove(cacheObj);            // O(n) — unavoidable with java.util.LinkedList
        cache.addLast(cacheObj);           // O(1)
        return cacheObj.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheObj existing = map.get(key);
            cache.remove(existing);        // remove old position
        } else if (cache.size() == this.capacity) {
            CacheObj lru = cache.removeFirst();  // evict least recently used
            map.remove(lru.key);
        }
        CacheObj newObj = new CacheObj(key, value);
        cache.addLast(newObj);             // most recently used goes to end
        map.put(key, newObj);
    }


    public static class CacheObj {
        final int key;
        final int value;

        public CacheObj(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (this.getClass() != that.getClass()) {
                return false;
            }
            return Objects.equals(this.key, ((CacheObj) that).key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
