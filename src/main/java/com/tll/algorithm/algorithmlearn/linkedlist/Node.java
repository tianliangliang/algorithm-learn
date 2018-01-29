package com.tll.algorithm.algorithmlearn.linkedlist;

/**
 * 单链表结构
 **/
public class Node {
    //为了方便，使用public，就不需要get，set方法了
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
