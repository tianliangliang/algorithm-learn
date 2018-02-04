package com.tll.algorithm.algorithmlearn.linkedlist;

/**
 * Created by tll on 05/02/2018 00:14
 **/
public class merge {
    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node cur = head1;
        for (int i = 0; i < 6; i += 2) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        Node head2 = new Node(0);
        Node cur2 = head2;
        for (int i = 1; i < 7; i += 2) {
            cur2.next = new Node(i);
            cur2 = cur2.next;
        }

        Node node = mergeNode(head1, head2);
    }

    public static Node mergeNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;

        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
