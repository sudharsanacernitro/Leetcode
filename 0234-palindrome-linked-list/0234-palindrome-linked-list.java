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
        
        String result="";

        while(head!=null)
        {
            result+=head.val;
            head=head.next;
        }

        String rev=new StringBuilder(result).reverse().toString();

        return result.equals(rev);
    }
}