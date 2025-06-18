/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LRUCache {
    private HashMap<Integer, Integer> cache;
    private int capacity;
    private List<Integer> lruList;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.lruList = new LinkedList<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Integer res = cache.get(key);
            // 移除指定对象
            lruList.remove((Integer) key);
            lruList.addFirst(key);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            // 若键已存在，先从 lruList 中移除该键
            lruList.remove((Integer) key);
        } else if(cache.size() == this.capacity) {
            // 若键不存在且缓存已满，移除 lruList 最后一个元素及其在 cache 中的映射
            Integer lastKey = lruList.removeLast();
            cache.remove(lastKey);
        }
        // 添加或更新缓存
        cache.put(key, value);
        lruList.addFirst(key);
    }
}