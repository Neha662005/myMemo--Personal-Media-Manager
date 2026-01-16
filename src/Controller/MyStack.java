package Controller;

/**
 * MyStack class - Generic stack implementation using array.
 * Supports LIFO (Last In First Out) operations with dynamic resizing.
 *
 * @param <T> The type of elements stored in the stack
 * @author myMemo Team
 * @version 1.0
 */
public class MyStack<T> {

    /** Array to store stack elements */
    private Object[] stack;
    /** Index of the top element */
    private int top;

    /**
     * Constructs an empty stack with initial capacity of 10.
     */
    public MyStack() {
        stack = new Object[10];
        top = -1;
    }

    /**
     * Pushes an element onto the stack.
     * Automatically resizes the array if capacity is reached.
     *
     * @param item The element to push
     */
    public void push(T item) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = item;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The top element, or null if stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) stack[top];
        stack[top] = null;
        top--;
        return item;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The top element, or null if stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) stack[top];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if stack contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The count of elements in the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Removes all elements from the stack.
     * Clears all references to allow garbage collection.
     */
    public void clear() {
        while (top != -1) {
            stack[top] = null;
            top--;
        }
    }

    /**
     * Doubles the capacity of the underlying array.
     */
    private void resize() {
        Object[] newStack = new Object[stack.length * 2];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}
