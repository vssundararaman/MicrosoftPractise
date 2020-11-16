package com.microsoft;

import com.common.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (2);
        head.next.next.next.next = new ListNode (1);
      //  head.next.next.next.next.next = new ListNode (1);

        System.out.println (isValidPalindrome (head));

    }

    static boolean isValidPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
