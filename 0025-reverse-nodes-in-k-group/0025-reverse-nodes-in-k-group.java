class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), temp = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode start = dummy;

        while (temp != null) {
            ListNode temp1 = temp;
            stack.clear();

            for (int i = 0; i < k && temp != null; i++) {
                stack.push(temp);
                temp = temp.next;
            }

           boolean isLast=(stack.size() < k)?true:false;

            while (!stack.isEmpty()) {

                ListNode curr=isLast?stack.remove(0):stack.pop();
                dummy.next = curr;
                dummy = dummy.next;
            }
        }

        dummy.next = null;
        return start.next;
    }
}
