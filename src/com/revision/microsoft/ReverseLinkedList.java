package com.revision.microsoft;

import com.common.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverse (head);
        head.next.next = head;
        head.next = null;
        return result;

    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

}
