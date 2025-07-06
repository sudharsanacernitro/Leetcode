class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n=rooms.size();

        Queue<Integer> q=new LinkedList<>();

        for(int i:rooms.get(0)) q.add(i);

        boolean[] visited=new boolean[n];

        visited[0] = true;
        int count = 1;

        while(!q.isEmpty())
        {           
            int size=q.size();

            for(int i=0;i<size;i++){
                int curr=q.poll();

                if(visited[curr]) continue;

                 count++;
                visited[curr]=true;

                for(int key:rooms.get(curr))
                {
                    if (!visited[key]) 
                    q.add(key);
                }
            }  
            
        }

        return count == n;
    }
}