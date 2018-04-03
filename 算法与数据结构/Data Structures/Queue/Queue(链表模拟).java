/**
 * <p>ClassName:Queue</p>
 * <p>Description:	用链表实现 Queue </p>
 *
 * @author littledream1502@gmail.com
 * @version 1.0
 * @date 2018/4/2 21:19
 */
public class Queue<T> {

    private class Node<T> {
        T data;
        Node next;

        Node() {
            super();
        }

        Node(T data) {
            this.data = data;
        }
    }

    //维护头结点;
    private Node first;
    //维护尾节点;
    private Node last;
    //队列中元素个数;
    int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 进队
     *
     * @param data
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);
        /**
         * 首次入队;
         * 同时维护头结点与尾节点
         */
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            /**
             * 非首次入队;
             * 更新尾节点指向;
             */
            last.next = newNode;
            last = newNode;
        }
        ++N;
    }

    /**
     * @return
     */
    public Node<T> dequeue() {
        Node<T> tNode = new Node<T>();
        tNode = first;
        first = first.next;
        --N;
        return tNode;
    }
}
