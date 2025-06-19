class Solution {
    public int numberOfBeams(String[] bank) {
        
        int n=bank.length;

        int prev=0,curr=0,sum=0;
        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1)
            {
                for(char j : bank[i].toCharArray())
                {
                    if(j=='1')
                    prev++;
                }
                System.out.println(prev);
                continue;
            }

            for(char j:bank[i].toCharArray())
            {
                if(j=='1') curr++;
            }
            System.out.println(curr);
            // break;

            if(curr == 0) continue;
            sum+=(curr*prev);
            prev=curr;

            curr=0;
        }

        return sum;
    }
}