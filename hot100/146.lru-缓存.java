/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class Node {
        int key,value;
        Node pre,next;
        Node(int k,int v){
            key = k;
            value = v;
        }
    }
    private final int capacity;
    private final Node dummy = new Node(0,0);
    private final Map<Integer,Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.pre = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
            return ;
        }
        node = new Node(key,value);
        keyToNode.put(key,node);
        pushFront(node);
        if(keyToNode.size() > capacity){
            Node backNode = dummy.pre;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
        return ;
    }
    private Node getNode(int key){
        if(!keyToNode.containsKey(key)){
            return null;
        }
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }
    private void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
    }
    private void pushFront(Node x){
        x.next = dummy.next;
        x.pre = dummy;
        x.next.pre = x;
        x.pre.next = x;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

