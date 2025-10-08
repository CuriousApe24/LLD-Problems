package cache;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K,V> implements Cache<K,V> {
    private ConcurrentHashMap<K,V> map;
    private int CAPACITY;
    private final EvictionPolicy<K> evictionPolicy;

    public LRUCache(int cap, EvictionPolicy<K> evict){
        this.CAPACITY= cap;
        evictionPolicy = evict;
        map = new ConcurrentHashMap<>();
    }
    
    @Override
    public V get(K key){
        if(!map.containsKey(key)) return null;
        evictionPolicy.keyAccessed(key);
        return map.get(key);
    }
    @Override 
    public void put(K key, V val){
        if(map.containsKey(key)){
            evictionPolicy.keyAccessed(key);
            map.put(key, val);
            return;
        }
        if(map.size()>= CAPACITY){
            K evicted = evictionPolicy.evictKey();
            if(evicted != null){
                map.remove(evicted);
            }
        }
        map.put(key, val);
        evictionPolicy.keyAccessed(key);
    }


}
