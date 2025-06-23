/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        // 补全递归终止条件
        if (head == null || head.next == null) return head;
        
        // 找到中间节点并分割链表
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null; // 关键：断开左右链表连接
        
        // 递归排序左右子链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        
        // 合并两个有序链表
        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head.next; // 调整快指针起始位置
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // 移除递归调用
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        // 简化合并逻辑，直接返回头节点
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return dummy.next; // 直接返回合并后的头节点
    }
}
// @lc code=end

