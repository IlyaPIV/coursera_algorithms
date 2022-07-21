package stacks_queues;

import java.util.Stack;

public class StackWithMax {

    private final Stack<Integer> stack = new Stack<>();
    private int size;

    public void push(int value){
        size++;
        stack.push(value);

    }

    public int pop(){
        int value = Integer.MIN_VALUE;

        if (!stack.isEmpty()) {
            size--;
            value = stack.pop();
        }
        return value;
    }

    public boolean empty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int max(){
        int maxVal = Integer.MIN_VALUE;
        for (int value:
             stack) {
            maxVal = Math.max(maxVal, value);
        }
        return maxVal;
    }
}
