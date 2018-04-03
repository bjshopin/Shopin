import java.util.Stack;
/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 用两个栈实现队列
 */
public class Solution {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    /**
     * 队列入队
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 队列出队
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        Integer integer = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return integer;
    }

}
