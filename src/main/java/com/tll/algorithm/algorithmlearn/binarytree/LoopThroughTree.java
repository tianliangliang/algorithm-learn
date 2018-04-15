package com.tll.algorithm.algorithmlearn.binarytree;

/**
 * Created by tll on 07/02/2018 00:25
 **/
public class LoopThroughTree {


    private static final sun.misc.Unsafe U;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final long ABASE;
    private static final int ASHIFT;

    static {
        try {
            U = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentHashMap.class;
            SIZECTL = U.objectFieldOffset
                    (k.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = U.objectFieldOffset
                    (k.getDeclaredField("transferIndex"));
            BASECOUNT = U.objectFieldOffset
                    (k.getDeclaredField("baseCount"));
            CELLSBUSY = U.objectFieldOffset
                    (k.getDeclaredField("cellsBusy"));
            Class<?> ck = CounterCell.class;
            CELLVALUE = U.objectFieldOffset
                    (ck.getDeclaredField("value"));
            Class<?> ak = Node[].class;
            ABASE = U.arrayBaseOffset(ak);
            int scale = U.arrayIndexScale(ak);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        binaryTreeNode.left = new BinaryTreeNode(2);
        binaryTreeNode.left.left = new BinaryTreeNode(3);
        binaryTreeNode.left.right = new BinaryTreeNode(4);
        binaryTreeNode.right = new BinaryTreeNode(6);
        binaryTreeNode.right.left = new BinaryTreeNode(7);


        preOrderRecur(binaryTreeNode);
        System.out.println("*************8");
        inOrderRecur(binaryTreeNode);
        System.out.println("*************8");
        posOrderRecur(binaryTreeNode);


    }

    /**
     * 先序
     *
     * @param head
     */
    public static void preOrderRecur(BinaryTreeNode head) {
        if (head == null) return;

        System.out.print(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序
     *
     * @param head
     */
    public static void inOrderRecur(BinaryTreeNode head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value);
        inOrderRecur(head.right);
    }

    /**
     * 后序
     *
     * @param head
     */
    public static void posOrderRecur(BinaryTreeNode head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value);
    }
}


    public int size() {
        long n = sumCount();
        return ((n < 0L) ? 0 :
                (n > (long) Integer.MAX_VALUE) ? Integer.MAX_VALUE :
                        (int) n);
    }

    /**
     * Returns the number of mappings. This method should be used
     * instead of {@link #size} because a ConcurrentHashMap may
     * contain more mappings than can be represented as an int. The
     * value returned is an estimate; the actual count may differ if
     * there are concurrent insertions or removals.
     *
     * @return the number of mappings
     * @since 1.8
     */
    public long mappingCount() {
        long n = sumCount();
        return (n < 0L) ? 0L : n; // ignore transient negative values
    }

    final long sumCount() {
        CounterCell[] as = counterCells;
        CounterCell a;
        long sum = baseCount;
        if (as != null) {
            for (int i = 0; i < as.length; ++i) {
                if ((a = as[i]) != null)
                    sum += a.value;//所有counter的值求和
            }
        }
        return sum;
    }