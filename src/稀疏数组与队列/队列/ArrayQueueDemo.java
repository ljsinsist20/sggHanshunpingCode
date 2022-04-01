package 稀疏数组与队列.队列;

import java.util.Scanner;

/**
 * @author ：ljs
 * @date ：Created in 2022/3/14 21:47
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loap = true;
        while (loap) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loap = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    int res = queue.showHead();
                    System.out.printf("队列头的数据是%d\n", res);
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class ArrayQueue {
    private int maxSize; //最大容量
    private int front; // 头指针
    private int rear; //尾指针
    private int[] arr; //数组

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向头数据的前一个位置
        rear = -1; //指向最后一个数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}
