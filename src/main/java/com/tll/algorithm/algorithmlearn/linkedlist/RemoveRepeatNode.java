package com.tll.algorithm.algorithmlearn.linkedlist;

import java.util.HashSet;

/**
 * Created by tll on 28/01/2018 23:47
 **/
public class RemoveRepeatNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur.next.next = new Node(i);
            cur = cur.next.next;
        }

        Node pre = head;
        System.out.println("*****删除重复值之前*****");

        while (pre != null) {
            System.out.print(pre.value + ",");
            pre = pre.next;
        }

        System.out.println();
        removeRep(head);

        System.out.println("*****删除重复值之后*****");
        Node after = head;
        while (after != null) {
            System.out.print(after.value + ",");
            after = after.next;
        }
        System.out.println();

    }


    public static void removeRep(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        hashSet.add(head.value);
        while (cur != null) {
            if (hashSet.contains(cur.value))
                pre.next = cur.next;
            else {
                hashSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}


class Node {
    //为了方便，使用public，就不需要get，set方法了
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
