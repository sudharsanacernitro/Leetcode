class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(List<Integer> lst:wall)
        {

            int consecutiveWidth=0;
            for (int i = 0; i < lst.size() - 1; i++) 
            {
                consecutiveWidth += lst.get(i);
                hm.put(consecutiveWidth,hm.getOrDefault(consecutiveWidth,0)+1);
            }

        }

        int maxValue=0;

        for(int key:hm.keySet())
        {
            if(hm.get(key) > maxValue)
            maxValue=hm.get(key);
        }

        return wall.size()-maxValue;
    }
}