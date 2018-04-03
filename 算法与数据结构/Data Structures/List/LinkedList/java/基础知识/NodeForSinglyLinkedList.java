/**
 * @author littledream1502@gmail.com
 * @date 2017/11/26
 * @desc 单向链表节点
 */
public class NodeForSinglyLinkedList {
    int val;
    NodeForSinglyLinkedList next;

    /**
     * 空构造器;
     */
    NodeForSinglyLinkedList() {

    }

    /**
     * 权值构造器;
     * @param val
     */
    NodeForSinglyLinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "节点:{"+
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
