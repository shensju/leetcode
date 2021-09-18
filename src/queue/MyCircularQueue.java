package queue;

/**
 * @Author: shensju
 * @Date: 2021/9/18 23:47
 */
public class MyCircularQueue {

    private int[] data;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = rear = 0;
    }

    public boolean enQueue(int value) {
        if ((rear + 1) % data.length == front) // 队列已满
            return false;
        data[rear] = value;
        rear = (rear + 1) % data.length;
        return true;
    }

    public boolean deQueue() {
        if (front == rear)
            return false;
        front = (front + 1) % data.length;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return data[(rear - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return front == rear ? true : false;
    }

    public boolean isFull() {
        return (rear + 1) % data.length == front ? true : false;
    }

}
