class Solution {
    public int largestRectangleArea(int[] heights) {
      
      Stack<Integer> stack=new Stack<>();

      int maxArea=0;

        int n=heights.length;

        int left[]=new int[n];
        int right[]=new int[n];


      for(int i=n-1;i >= 0;i--)
      {
        while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
        {
            stack.pop();
        }

        right[i]= stack.isEmpty() ? n : stack.peek();

        stack.push(i);

      }
stack.clear();
      for(int i=0;i < n;i++)
      {
        while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
        {
            stack.pop();
        }

        left[i]=stack.isEmpty()?-1:stack.peek();

        stack.push(i);

      }

     for(int i=0;i<n;i++)
     {
        int width=right[i] - left[i] - 1;;
        int height=heights[i];

        maxArea=Math.max(maxArea,width*height);
     }

      return maxArea;
    }
}
