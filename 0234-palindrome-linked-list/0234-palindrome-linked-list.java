/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
       ListNode slow=head,fast=head;

       while(fast!=null && fast.next != null)
       {
        slow=slow.next;
        fast=fast.next.next;
       }

       ListNode secondHalf=slow;

       secondHalf=reverseList(secondHalf);

        while(secondHalf!=null)
        {
           if(head.val != secondHalf.val) return false;

           head=head.next;
           secondHalf=secondHalf.next;
        }
       return true;

    }

     ListNode reverseList(ListNode head)
    {
        ListNode prev=null,next=null;

        while(head!=null)
        {
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }

        return prev;
    }
}