import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>ClassName:Stack</p>
 * <p>Description:	</p>
 * <p>Company: www.shopin.net</p>
 *
 * @author zhangyong@shopin.cn
 * @version 1.0
 * @Date 2018/3/31 21:40
 */
public class Stack<T>  {

    //栈顶元素
    private Node<T> first;
    // 栈内元素数量;
    private int N;

    /**
     * 构造节点类;
     *
     * @param <T>
     */
    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 初始化空栈;
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * 判断栈是否为空;
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 返回栈内元素个数;
     *
     * @return N
     */
    public int size() {
        return N;
    }

    /**
     * 压人元素;
     *
     * @param data
     */
    public void push(T data) {
        Node<T> oldFirst = first;
        first = new Node<T>(data);
        first.next = oldFirst;
        //更新栈内元素个数;
        ++N;
    }

    /**
     * 弹出元素
     *
     * @return T
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈内元素已空");
        }
        Node<T> value = first;
        first = first.next;
        //更新栈内元素个数;
        --N;
        return value.data;
    }

    /**
     * 返回但不弹出栈顶元素;
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈内元素已空");
        }
        return first.data;
    }

    /**
     * 返回当前Stack的迭代器;
     * @return
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    /**
     * 实现Iterator接口用于迭代
     *
     * @param <T>
     */
    public class ListIterator<T> implements Iterator<T> {

        /**
         * 当前迭代的元素'指针';
         */
        private Node<T> current;

        /**
         * 获取当前Stack的迭代器,current指向first位置;
         *
         * @param first
         */
        public ListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * 遍历当前指针的下一个元素;
         *
         * @return
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("栈已经没有元素可以遍历了");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "first=" + first +
                ", N=" + N +
                '}';
    }
}
