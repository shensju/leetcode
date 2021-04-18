/**
 * @Author: shensju
 * @Date: 2021/4/18 23:41
 */
public class Solution0641 {

    /** 0641 Design Circular Deque **/
    class MyCircularDeque {

        private int[] arr;
        private int front;
        private int rear;
        private int capacity;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k + 1];
            front = rear = 0;
            capacity = k + 1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull())
                return false;
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull())
                return false;
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty())
                return false;
            front = (front + 1) % capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty())
                return false;
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty())
                return -1;
            return arr[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())
                return -1;
            return arr[(rear - 1 + capacity) % capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return front == rear;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

    /**
     * Runtime: 4 ms, faster than 98.74% of Java online submissions for Design Circular Deque.
     * Memory Usage: 39.6 MB, less than 30.07% of Java online submissions for Design Circular Deque.
     */
}
