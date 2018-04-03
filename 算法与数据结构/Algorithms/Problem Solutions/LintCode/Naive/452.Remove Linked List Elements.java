/**
 * URL:http://www.lintcode.com/en/problem/remove-linked-list-elements/
 * Question: Remove all elements from a linked list of integers that have value val.
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 * */
 
 /** 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
         if (head == null) return null;
        if (head.val == val) head = head.next;
       ListNode p = head, q = head.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        
        return head;
    }
}
