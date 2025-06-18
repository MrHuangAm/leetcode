/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
import java.util.PriorityQueue;

class MedianFinder {
    // 最大堆，存储较小的一半元素
    private PriorityQueue<Integer> maxHeap;
    // 最小堆，存储较大的一半元素
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // 若两个堆元素数量相等，先插入最大堆，再将最大堆堆顶元素移到最小堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            // 若最大堆元素数量比最小堆少 1，先插入最小堆，再将最小堆堆顶元素移到最大堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // 两个堆元素数量相等，中位数是两个堆堆顶元素的平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 最大堆元素数量比最小堆少 1，中位数是最小堆的堆顶元素
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

