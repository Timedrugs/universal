/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

import suanFaModel.HashMapAndSetCode.HashCode;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/12 1:24 下午
 */
public class FiveDay {

    public static void main(String[] args) {
        FiveDay cl = new FiveDay();
        ListNode l1 = new ListNode(1);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(6);
        l1.next = l10;
        l10.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l20 = new ListNode(3);
        ListNode l21 = new ListNode(5);
        l2.next = l20;
        l20.next = l21;

        printListNode(cl.mergeTwoLists(l1, l2));
    }
    
    /**
     * 21
     * 将两个升序链表合并为一个新的 升序 链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (l1 != null && l2 != null){

            if (l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }else{
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        head.next = l1 != null ? l1 : l2;
        return tmp.next;
    }

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
