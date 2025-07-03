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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null){
            // 找到当前组的最后一个节点
            ListNode end = prev;
            for(int i=0;i<k;i++){
                end = end.next;
                if(end == null) return dummy.next;
            }
            ListNode nextGrounp = end.next;
            end.next = null;
            ListNode start = prev.next;
            prev.next = reverseList(start);
            start.next = nextGrounp;
            prev = start;
            head = nextGrounp;
        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nxtn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxtn;
        }
        return prev;
    }
}
// @lc code=end

