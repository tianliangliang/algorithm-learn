package com.tll.algorithm.algorithmlearn.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tll on 30/01/2018 23:20
 **/
public class ConvertSearchTreeToList {
    public static void main(String[] args) {

        BdNode head = new BdNode(1);
        BdNode pre = head;
        pre.left = null;
        BdNode cur = null;
        for (int i = 2; i < 10; i++) {
            cur = new BdNode(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        BdNode resule = convert(head);


    }

    /**
     * 搜索二叉树转双向链表
     *
     * @param head
     * @return
     */
    public static BdNode convert(BdNode head) {
        Queue<BdNode> queue = new LinkedList<>();
        inOrerToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        BdNode pre = head;
        pre.left = null;
        BdNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public static void inOrerToQueue(BdNode head, Queue<BdNode> queue) {
        if (head == null)
            return;
        inOrerToQueue(head.left, queue);
        queue.offer(head);
        inOrerToQueue(head.right, queue);
    }
}
