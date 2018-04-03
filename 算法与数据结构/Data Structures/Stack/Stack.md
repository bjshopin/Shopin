<!-- GFM-TOC -->
* [Stack 介绍](#stack-介绍)
    * [1. Stack简介](#1-stack简介)
    * [2.实现方式](#2实现方式)
        * [2.1 用数组实现](#21-用数组实现)
        * [2.2 用链表实现](#22-用链表实现)
<!-- GFM-TOC -->

# Stack 介绍
## 1. Stack简介
```
   Stack是一种具有先进后出的数据结构,大致长下面的样子;
```
![](https://mmbiz.qpic.cn/mmbiz_jpg/6fuT3emWI5LkeM7Tv8xW0tnI4yibWAOicgTYfab3IIOK5ibgOWZCibYQAn7Ix1bSichic1zaxAaIegoibojyfs343F4KQ/640?tp=webp&wxfrom=5&wx_lazy=1)
## 2.实现方式
```
  JDK中Stack的实现继承与Vector,原理上是以数组实现,
  我们在此不谈论JDK怎么实现的,我们接下来分别以数组和链表来实现Stack;
```
### 2.1 用数组实现

 - 用动态数组(扩容机制)的最后一位来模拟stack的push和pop;
```
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 用数组实现栈
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {

    private T[] a;
    private int n;

    /**
     * 初始化一个空栈;
     */
    public Stack() {
        a = (T[]) new Object[2];
        n = 0;
    }

    /**
     * 判断栈内是否存在元素;
     *
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 返回栈内现在元素个数;
     *
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * 栈大小扩容;
     *
     * @param capacity
     */
    private void resize(int capacity) {

        //assert关键字在于 对capacity>=n 这个逻辑进行判断,如果成立则接着执行,否则抛出异常，需要开启 VMoptions: -ea;
        assert capacity >= n;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 压入元素
     */
    public void push(T data) {
        /**
         * 如果此时栈满,则扩容2倍;
         */
        if (n == a.length) resize(2 * a.length);
        a[n++] = data;
    }

    /**
     * 弹出并返回栈顶元素
     *
     * @return T
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack UnderFlow");
        }
        T data = a[n - 1];
        
        //防止对象游离,help gc
        a[n - 1] = null;
        n--;
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return data;
    }

    /**
     * 返回但不弹出栈顶元素
     *
     * @return T
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack UnderFlow");
        }
        return a[n - 1];
    }

    /**
     * 用内部类实现迭代器接口,实现从栈顶往栈底的先进后出迭代,没有实现remove()方法;
     */
    private class ReverseArrayIterator implements Iterator<T> {

        private int i;

        public ReverseArrayIterator() {
            i = n - 1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("不支持移除操作");
        }
    }

    @Override
    public Iterator<T> iterator() {
        /**
         * 返回自定义的可以实现从栈顶到栈底的先进后出的迭代器;
         */
        return new ReverseArrayIterator();
    }
}
```
### 2.2 用链表实现

 - 维护链表的头结点来模拟stack的push和pop();
```
import java.util.Iterator;
import java.util.NoSuchElementException;
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

```
