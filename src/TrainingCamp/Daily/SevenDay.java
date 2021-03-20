package TrainingCamp.Daily;

/**
 * @author xiaokuo
 * @since 2021/3/14 4:07 下午
 */
public class SevenDay {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        int value = 1;
        boolean param_1 = obj.insertFront(value);
        boolean param_2 = obj.insertLast(2);
        int param_51 = obj.getFront();

        boolean param_3 = obj.deleteFront();

        int param_52 = obj.getFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
    }

}

class MyCircularDeque {

    int[] arr;
    int head = 0;
    int tail = 0;
    int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        tail = k - 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        //头指针左移
        head = head == 0 ? arr.length - 1 : head - 1;
        size++;
        arr[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        //尾指针右移
        tail = tail == arr.length - 1 ? 0 : tail + 1;
        arr[tail] = value;
        size++;
        return  true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }

        head = head == arr.length - 1 ? 0 :head + 1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }

        tail = tail == 0 ? arr.length - 1 : tail - 1;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {

        if(isEmpty()){
            return -1;
        }

        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }

        return arr[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */