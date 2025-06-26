class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int right=0;
        int left=0;

        for(int i:weights)
        {
            right+=i;
            left=Math.max(i,left);
        }

        while(left <= right)
        {
            int mid=left+(right-left)/2;

            boolean isPossible=canFit(weights,mid,days);

            if(isPossible)
            {
                right=mid-1;
                
            }
            else
            {
                left=mid+1;
            }
        }

        return left;

    }

    boolean canFit(int[] weights,int shipWeight,int days)
    {
        int currSum=0;
        int trip=1;

        for(int i:weights)
        {
            if(currSum+i > shipWeight)
            {
                trip++;
                currSum=0;
            }
             currSum+=i;

        }

        System.out.println(shipWeight +" "+trip);

        return trip <= days;

    }
}