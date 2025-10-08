package cache;

public class CacheFactory {
    public static <K, V> Cache<K, V> getCache(int capacity, String type) {
        switch (type) {
            case "LRU":
                return new LRUCache<>(capacity, new LRUEvictionPolicy<>());
            default:
                throw new IllegalArgumentException("Unsupported policy");
        }
    }
}
