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
        ListNode l1 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        l1.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(9);
        ListNode l20 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        l2.next = l20;
        l20.next = l21;

        ListNodeCode cl = new ListNodeCode();
        printListNode(cl.addTwoNumbers(l1, l2)); //100998
    }

    /**
     * 2 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 输入：l1 = [2,4,3], l2 = [5,6,4] //输出：[7,0,8] //解释：342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int count = 0;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while(l1 != null || l2 != null || count != 0){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + count;
            tmp.next = new ListNode(sum % 10);
            count = sum / 10;
            tmp   = tmp.next;

            if(l1 != null){
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }
        }

        return  res.next;
    }


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

        return node;
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

    /**
     * 判断链表是否有环
     * 题目：一个链表，判断其是否又环。
     * 如果一个链表有环，那么用一个指针遍历将永远也走不到尽头。使用两个指针遍历：first每次走一步，second每次走两步。若链表有环则它们一定会相遇。
     *
     * @param head
     */

    /**
     * 在O(1)时间删除链表结点
     * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点。（剑指offer，第13题）
     *
     * @return
     */

    /**
     * 题目：输入一个链表，输出该链表中倒数第k个结点。
     * 例如： 1 2 3 4 5 6
     *
     * @param head
     */


    /**
     * 打印链表
     *
     * @param head
     */
    private static void printListNode(ListNode head) {

        while (head != null) {
            System.out.println(head.val);
            if (head.next == null) {
                break;
            }
            head.val = head.next.val;
            head = head.next;
        }
    }

}
