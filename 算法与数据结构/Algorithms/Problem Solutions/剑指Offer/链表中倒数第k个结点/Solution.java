/**
 * @author 
 * @date 2018/1/11 9:43
 * @desc 一个链表倒数第K个节点
 */
public class Solution {

    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {

            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        /**
         * step 1:创建2个节点,都指向头结点;
         */
        ListNode first = head;
        ListNode second = head;
        /**
         * step 2:让第二个节点指向第K个节点;
         */
        for (int i = 0; i < k; i++) {
            /**
             * 如果出现链表长度<k的情况,方法直接返回;
             */
            if (second == null) {
                return null;
            }
            second = second.next;
        }
        /**
         * step 3: 两个指针同时向后扫描,当second到达链表结尾时,first即指向第K个节点;
         */
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }
}
