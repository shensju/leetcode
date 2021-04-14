/**
 * @Author: shensju
 * @Date: 2021/4/14 22:56
 */
public class Solution0622 {

    /** 0622 Design Circular Queue **/
    class MyCircularQueue {

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

    /**
     * 时间复杂度：O(1)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 96.63% of Java online submissions for Design Circular Queue.
     * Memory Usage: 39.4 MB, less than 51.97% of Java online submissions for Design Circular Queue.
     */
}
