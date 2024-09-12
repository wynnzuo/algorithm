package list;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 1->2->1   1->2->3->2->1
 */
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 使用栈结构
    // 额外空间复杂度O(N)
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        //压栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 使用栈结构+快慢指针
    // 额外空间复杂度O(N) 比上一种省一半空间
    // 只压栈后一半的数
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        //压栈
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need O(1) extra space
    // 使用快慢指针+反转后半部分链表形式 双端对比
    // 1 -> 2 -> 3 <- 2 <- 1
    // 1 -> 2 <- 2 <- 1
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) return true;
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; //n1->mid
            n2 = n2.next.next;//n2->end
        }
        n2 = n1.next;// n2 -> right part first node
        n1.next = null;// mid.next -> null
        Node n3 = null;
        while (n2 != null) {// right part convert
            n3 = n2.next;// n3->save next node
            n2.next = n1;// next of right node convert
            n1 = n2;// n1 move
            n2 = n3;// n2 move
        }
        n3 = n1;// n3 -> save last node
        n2 = head; // n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
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
        System.out.println(isPalindrome3(node1));
    }
}
