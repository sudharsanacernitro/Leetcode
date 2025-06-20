class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0,sum=0;

       while(l1 !=null || l2 !=null)
       {
        int v1=l1==null?0:l1.val;
        int v2= l2==null?0:l2.val;

        sum=v1+v2+carry;

        carry=sum/10;

        sum=sum%10;

        ListNode temp=new ListNode(sum);

        dummyHead.next=temp;

        dummyHead=dummyHead.next;

        if(l1 != null)
        l1=l1.next;

        if(l2 !=null)
        l2=l2.next;
        
       }

       if(carry > 0)
       {
         ListNode temp=new ListNode(carry);

        dummyHead.next=temp;

        dummyHead=dummyHead.next;
       }

      

        ListNode result = tail.next;
        dummyHead.next = null;
        return result;
    }
}