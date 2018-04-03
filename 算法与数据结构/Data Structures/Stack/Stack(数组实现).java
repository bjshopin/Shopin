package com.zhangyong.DataStructures.Stack;

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

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 4; i++) {
            stack.push("Do You Love " + i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
