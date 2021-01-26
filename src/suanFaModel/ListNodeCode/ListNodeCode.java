/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.ListNodeCode;


import java.util.List;

/**
 * 链表
 *
 * @author xiaokuo
 * @since 2021/1/14 5:32 下午
 */
public class ListNodeCode {

    public static void main(String[] args) {

    }

    /**
     * 2
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     *  请你将两个数相加，并以相同形式返回一个表示和的链表。
     *  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *  //输入：l1 = [2,4,3], l2 = [5,6,4]
     * //输出：[7,0,8]
     * //解释：342 + 465 = 807.
     *
     */


    /**
     * 题目：输入一个链表，输出该链表中倒数第k个结点。 例如： 1 2 3 4 5 6
     *
     * @param head
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode node = null;

        if (l1.val > l2.val) {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        } else {
            node = l1;
            node.next = mergeTwoLists(l2, l1.next);
        }

        return  node;
    }



    /**
     * 翻转k组链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode a = head, b = head;
        while (k-- > 0) {
            if (b == null) {
                return head;
            }

            b = b.next;
        }

        ListNode newHead = reverseKGroupHelper(a, b);
        a.next = reverseKGroup(b, k);

        return newHead;
    }

    private ListNode reverseKGroupHelper(ListNode a, ListNode b) {

        ListNode cur = a;
        ListNode pre = null, tmp;

        while (cur != b) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 2个递增链表公共节点
     */


}
