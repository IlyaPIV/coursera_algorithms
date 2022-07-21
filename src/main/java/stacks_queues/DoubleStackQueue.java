package stacks_queues;

import java.util.Stack;

public class DoubleStackQueue<T> {

    private Stack<T> stackOne = new Stack<>();
    private Stack<T> stackTwo = new Stack<>();
    private int size;

    public void queue(T value){
        stackOne.push(value);
        size++;
    }

    public T dequeue() {
        if (stackTwo.empty()) {
            for (T val:
                 stackOne) {
                stackTwo.push(stackOne.pop());
            }
        }
        T res = null;
        if (!isEmpty()) {
            res = stackTwo.pop();
            size--;
        }

        return res;

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
