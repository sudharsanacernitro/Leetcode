class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack=new Stack<>();

        int length=temperatures.length-1;
        int result[]=new int[length+1];

        result[length]=0;

        stack.push(length);

        length-=1;

        while(length >= 0)
        {
            int curr=length;

            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[curr]) stack.pop();

            if(stack.isEmpty()) result[length]=0;

            else result[length]=stack.peek()-curr;

            stack.push(curr);

            length--;
        }

        return result;

    }
}