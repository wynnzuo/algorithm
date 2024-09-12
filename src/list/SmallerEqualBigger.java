package list;

/**
 * 将单链表按某值划分左边小,中间相等,右边大的形式
 */
public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 插入数组分区
     * 额外空间复杂度O(N)
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) return head;
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int min = -1;
        int max = nodeArr.length;
        int index = 0;
        while (index < max) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, index++, ++min);
            } else if (nodeArr[index].value > pivot) {
                swap(nodeArr, index, --max);
            } else {
                index++;
            }
        }
    }

    private static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 六个指针分别指向 小于 等于 大于 三个区的头尾节点
     * 额外空间复杂度O(1)
     */
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;// small head
        Node sT = null;//small tail
        Node eH = null;//equal head
        Node eT = null;//equal tail
        Node mH = null; //big head
        Node mT = null;//big tail
        Node next = null;// save next node
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        //三个区域连接起来
        if (sH != null) {
            sT.next = eH;
            eT = eT == null ? sH : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH == null ? eH : mH);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node cur = listPartition2(node1, 2);
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}
