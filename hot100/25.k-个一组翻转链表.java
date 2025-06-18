/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            // 找到当前组的最后一个节点
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }

            ListNode nextGroup = end.next;
            // 切断当前组与后续节点的连接
            end.next = null;
            // 记录当前组的头节点
            ListNode start = prev.next;
            // 反转当前组的节点
            prev.next = reverse(start);
            // 连接反转后的组与后续节点
            start.next = nextGroup;
            // 更新 prev 和 head 指针
            prev = start;
            head = nextGroup;
        }
        return dummy.next;
    }

    // 反转链表的辅助函数
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
// @lc code=end

