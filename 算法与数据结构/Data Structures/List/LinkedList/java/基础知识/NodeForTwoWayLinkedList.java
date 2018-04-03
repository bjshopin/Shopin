/**
 * @author littledream1502@gmail.com
 * @date 2017/11/26
 * @desc 双向链表节点;
 */
public class NodeForTwoWayLinkedList {
    int val;
    NodeForTwoWayLinkedList pre;
    NodeForTwoWayLinkedList next;

    NodeForTwoWayLinkedList() {

    }

    NodeForTwoWayLinkedList(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}
