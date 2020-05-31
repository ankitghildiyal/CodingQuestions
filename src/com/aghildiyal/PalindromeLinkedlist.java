package com.aghildiyal;


/**
 * Problem - Determine if LinkedList is Palindrome.
 * Algorithm does it in O(N) time and O(1) space.
 * Test against LeetCode 234. Palindrome Linked List.
 */
public class PalindromeLinkedlist {

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        int length = length(head);
        return compare(head, head, length, length);
    }

    private boolean compare(ListNode start, ListNode end, int mid, int length){
        if(end == null){
            return true;
        }else{
            boolean prevResult = compare(start, end.next, mid-1, length);
            if(prevResult && mid <= length/2){
                if(start.val != end.val){
                    return false;
                }else{
                    start.val = start.next.val;
                    start.next = start.next.next;
                }
            }
            return prevResult;
        }

    }

    private int length(ListNode head){
        ListNode headCopy = head;
        int length=0;
        while(headCopy != null){
            length++;
            headCopy = headCopy.next;
        }
        return length;
    }


}
