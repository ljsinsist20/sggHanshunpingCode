package 链表;

/**
 * @author ：ljs
 * @date ：Created in 2022/3/17 18:31
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * @param startNo   第几个小孩开始
     * @param countNum  数几下
     * @param nums      初始小孩数量
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        //helper指向最后一个节点
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //first，helper移动k-1次
        for (int i = 1; i <= startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //核心
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 1; i <= countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
}
