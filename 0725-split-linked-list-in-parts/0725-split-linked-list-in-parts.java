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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int length=0;

        ListNode temp=head;
        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }

        int eachSize=length/k;
        int extra=length%k;

        ListNode[] result=new ListNode[k];

        temp=head;
        for(int i=0;i<k;i++)
        {
            
            ListNode prev=temp;
             result[i] = temp;

            int j=0;
            while(j < eachSize + (i < extra ? 1 : 0))
            {
                prev=temp;
                if(temp!=null)
                temp=temp.next;
                j++;
            }

           

            if(prev!=null) 
            prev.next=null;
 
        }
        return result;
    }
}