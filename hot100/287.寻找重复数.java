/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 * 把数组看作一个链表，数组元素的值作为下一个节点的索引。
 * 由于存在重复元素，必然会形成一个环，重复的数就是环的入口。
 * 快慢指针法可以找到环的入口。

* 快慢指针相遇：快指针一次移动两步，慢指针一次移动一步，它们会在环内相遇。

* 寻找环的入口：相遇后，将其中一个指针重置到数组开头，
  两个指针都以一步的速度移动，再次相遇的位置就是环的入口，即重复的数。
*/

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // 初始化快慢指针
        int slow = nums[0];
        int fast = nums[nums[0]];
        // 快慢指针相遇
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 重置一个指针到数组开头
        fast = 0;
        // 两个指针以相同速度移动，再次相遇的位置就是重复的数
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end

