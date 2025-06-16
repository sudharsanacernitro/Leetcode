class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        Stack<Integer> stack=new Stack<>();
        int n=arr.length,i=0;
        while(i<n)
        {
            if(stack.isEmpty() || stack.peek() <= arr[i])
            {
                stack.push(arr[i]);
            }
            else
            {
                int max=stack.pop();

                while(!stack.isEmpty() && stack.peek() > arr[i])
                {
                    stack.pop();
                }
                stack.push(max);
            }
            i++;

            
        }

        return stack.size();
    }
}