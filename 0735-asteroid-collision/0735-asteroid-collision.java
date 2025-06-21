class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
           
                        int currComet=asteroids[i];

        if (stack.isEmpty()) {
                stack.push(currComet);
                continue;
            }

             int peek=stack.peek();



            // Same direction or non-colliding cases
            if ((peek > 0 && currComet > 0) || 
                (peek < 0 && currComet < 0) || 
                (peek < 0 && currComet > 0)) {
                stack.push(currComet);
                continue;
            }

            boolean currCometWon=true;

            while(!stack.isEmpty() && stack.peek() > 0 && currComet < 0 )
            {
                 peek=stack.pop();

               
                if (Math.abs(peek) == Math.abs(currComet)) {
                    currCometWon = false;
                    break; // both explode
                }

                if (Math.abs(peek) > Math.abs(currComet)) {
                    stack.push(peek); // current comet destroyed
                    currCometWon = false;
                    break;
                }

            }

            if(currCometWon) stack.push(currComet);

        }

        System.out.println(stack.toString());

        int result[]=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty())
        {
            result[i++]=stack.remove(0);
        }
        return result;

    }
}