package com.tll.algorithm.algorithmlearn.linkedlist;

/**
 * Created by tll on 01/02/2018 23:29
 **/
public class insertNum {
    public static void main(String[] args) {

        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        Node result = insertNum(head,10);

    }

    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (num >= pre.value && num <= cur.value) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value > num ? node : head;
    }
}
