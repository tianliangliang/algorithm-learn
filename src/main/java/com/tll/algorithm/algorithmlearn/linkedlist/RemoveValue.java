package com.tll.algorithm.algorithmlearn.linkedlist;

import java.util.Stack;

/**
 * Created by tll on 30/01/2018 00:34
 **/
public class RemoveValue {
    public static void main(String[] args) {


        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        Node pre = head;
        System.out.println("*****删除重复值之前*****");

        while (pre != null) {
            System.out.print(pre.value + ",");
            pre = pre.next;
        }
        System.out.println();

        Node result = deleteAppointValue2(head, 3);

        System.out.println("*****删除重复值之后*****");

        Node after = result;
        while (after != null) {
            System.out.print(after.value + ",");
            after = after.next;
        }
        System.out.println();


    }

    /**
     * 解法一
     * <p>
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * @param head
     * @param number
     * @return
     */
    public static Node deleteAppointValue1(Node head, int number) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != number) {
                stack.push(head);
            }
            head = head.next;
        }

        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 解法二
     * <p>
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * @param head
     * @param number
     * @return
     */
    public static Node deleteAppointValue2(Node head, int number) {
        Node pre = null;
        while (head != null) {
            if (head.value != number) {
                pre = head;
                break;
            }
            head = head.next;
        }

        Node cur = head.next;
        while (cur != null && pre != null) {
            if (cur.value == number) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}