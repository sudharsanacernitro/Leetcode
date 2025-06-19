class Solution {
    public int partitionArray(int[] nums, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i:nums) pq.add(i);


        int count=0;

        while(!pq.isEmpty())
        {
            int start=pq.poll();

            while(!pq.isEmpty() && pq.peek()-start <= k) pq.poll();
            count++;

            
        }

        return count;

    }
}