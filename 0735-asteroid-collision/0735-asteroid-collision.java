class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
      Stack<Integer> stack=new Stack<>();

        int n=asteroids.length;

      for(int i=0;i<n;i++)
      {
        int currComet=asteroids[i];

        if(stack.isEmpty())
        {
            stack.push(currComet);
            continue;
        }

        boolean currCometWon=true;

        // if(stack.peek() > 0 && currComet > 0) stack.push(currComet);
        while(!stack.isEmpty() && stack.peek() > 0 && currComet < 0)
        {
            // currCometWon=false;
            int weightOfPeekComet=Math.abs(stack.peek());
            int weightOfCurrComet=Math.abs(currComet);

            if(weightOfPeekComet < weightOfCurrComet)
            {
                stack.pop();
            }

            else if(weightOfPeekComet > weightOfCurrComet)
            {
                currCometWon=false;
                 break;
            }

            else
            {
                 currCometWon=false;
                stack.pop();
                break;
            }
        }

        if(currCometWon) stack.push(currComet);

      }

      System.out.println(stack.toString());


        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.get(i); 
        }

        

        return result;


    }

}