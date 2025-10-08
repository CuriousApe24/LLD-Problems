package cache;

public class CacheDemo {
    public static void main(String[] args) {
        Cache<Integer, String> cache = CacheFactory.getCache(2, "LRU");

        cache.put(1, "A");
        cache.put(2, "B");
        System.out.println(cache.get(1)); // A
        cache.put(3, "C"); // evicts 2
        System.out.println(cache.get(2));
    }
}
