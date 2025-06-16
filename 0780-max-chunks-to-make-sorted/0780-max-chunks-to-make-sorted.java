class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int count=0,i=0;
        while(i < n)
        {   
            if(stack.isEmpty() || arr[i]> stack.peek())
            {
                stack.push(arr[i]);
            }

            else{
            
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