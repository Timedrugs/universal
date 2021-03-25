/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/24 7:46 下午
 */
public class 从头到尾打印链表offer06 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        从头到尾打印链表offer06 cl = new 从头到尾打印链表offer06();
        cl.reversePrint(node1);
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        int[] res = new int[len];
        while (head != null) {
            res[--len] = head.val;
            head = head.next;
        }
        return res;
    }


}
