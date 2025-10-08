package cache;

import java.util.concurrent.ConcurrentHashMap;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{
        private class  Node {
            K key;
            Node prev, next;
            Node(K key){
                this.key = key;
            }
        }
        /* mruNode <->B <->A <->lruNode */
        private ConcurrentHashMap<K,Node> map;
        private Node lruNode;
        private Node mruNode;
        private final Object lock = new Object();
        
        public LRUEvictionPolicy(){
            lruNode = new Node(null);
            mruNode = new Node(null);
            mruNode.next = lruNode;
            lruNode.prev = mruNode;
            map = new ConcurrentHashMap<>();
        }

        @Override
        public void keyAccessed(K key){
            synchronized(lock){
                if(map.containsKey(key)) removeFromDLL(map.get(key));
                Node node = new Node(key);
                insertNodeAtMru(node);
                map.put(key, node);
            }
        }

        @Override
        public K evictKey(){
            synchronized(lock){
                if (mruNode.next == lruNode) {
                    return null; // No elements
                }
                Node node =  lruNode.prev;
                removeFromDLL(node);
                map.remove(node.key);
                return node.key;
            }
        }

        private void removeFromDLL(Node node){
            Node next = node.next;
            node.prev.next = next;
            next.prev = node.prev;
        }
        private void insertNodeAtMru(Node node){
            Node next = mruNode.next;
            next.prev = node;
            node.next = next;
            node.prev = mruNode;
            mruNode.next = node;
        }

        
}
