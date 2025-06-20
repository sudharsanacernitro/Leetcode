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
    public void reorderList(ListNode head) {

        ListNode temp=head,fast=head;

        while(fast!=null && fast.next!=null)
        {
            temp=temp.next;
            fast=fast.next.next;
        }

        ListNode second=temp.next;
         temp.next=null;

        ListNode rev=rev(second);

        while( rev!=null)
        {
            ListNode headNext=head.next;
            ListNode revNext=rev.next;
            head.next=rev;
            
            rev.next=headNext;
           
           head=headNext;
           rev=revNext;

        }
        // rev.next=null;

    }

    ListNode rev(ListNode head)
    {
        ListNode next=null,prev=null;

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