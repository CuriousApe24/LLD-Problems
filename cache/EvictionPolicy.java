package cache;

public interface EvictionPolicy<K> {
    public void keyAccessed(K key);
    public K evictKey();
}
