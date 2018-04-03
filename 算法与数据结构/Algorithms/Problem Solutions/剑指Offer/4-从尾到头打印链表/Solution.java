import java.util.ArrayList;

/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 翻转链表并打印每一个节点的值;
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode node = resverListNode(listNode);
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    /**
     * 翻转链表;
     *
     * @param root
     * @return 1-->2-->3--4>
     */
    public ListNode resverListNode(ListNode root) {
        ListNode pre = null;
        ListNode current = root;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        root = pre;
        return root;
    }
}
