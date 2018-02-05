package com.tll.algorithm.algorithmlearn.linkedlist;

/**
 * Created by tll on 06/02/2018 00:32
 **/
public class relocate {
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

        relocateNode(head);

        System.out.println("*****删除重复值之后*****");

        Node after = head;
        while (after != null) {
            System.out.print(after.value + ",");
            after = after.next;
        }
        System.out.println();
    }

    public static void relocateNode(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }

        right = mid.next;
        mid.next = null;

        Node next;
        Node left = head;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }

}
