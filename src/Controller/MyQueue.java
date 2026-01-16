package Controller;

/**
 * MyQueue class - Generic queue implementation using circular array.
 * Supports FIFO (First In First Out) operations with dynamic resizing.
 *
 * @param <T> The type of elements stored in the queue
 * @author myMemo Team
 * @version 1.0
 */
public class MyQueue<T> {

    /** Array to store queue elements */
    private Object[] data;
    /** Index of the front element */
    private int front;
    /** Index of the rear element */
    private int rear;
    /** Current number of elements in queue */
    private int size;

    /**
     * Constructs an empty queue with initial capacity of 10.
     */
    public MyQueue() {
        data = new Object[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * Automatically resizes the array if capacity is reached.
     *
     * @param item The element to enqueue
     */
    public void enqueue(T item) {
        if (size == data.length) {
            resize();
        }
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The front element, or null if queue is empty
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if queue contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Doubles the capacity of the underlying array.
     * Reorganizes elements in circular queue to linear order.
     */
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
    
    /**
     * Removes a specific item from the queue.
     * Maintains queue order by temporarily dequeueing and re-enqueueing.
     *
     * @param item The item to remove
     * @return true if item was found and removed, false otherwise
     */
    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }

        int count = size;
        boolean found = false;

        // Loop through the queue
        for (int i = 0; i < count; i++) {
            T current = this.dequeue();
            if (current.equals(item) && !found) {
                found = true;
                continue;
            }
            this.enqueue(current);
        }

        return found;
    }
}
