class Solution {
    public int totalFruit(int[] fruits) {
        
        int maxLength=0;

        HashMap<Integer,Integer> hm=new HashMap<>();

        int i=0,n=fruits.length;
        int left=0;
        while(i < n)
        {
            int type=fruits[i];

            if(!hm.containsKey(type) && hm.size() == 2)
            {
                while(hm.size() != 1)
                {
                    int removeNum=fruits[left++];
                    hm.put(removeNum,hm.get(removeNum)-1);

                    if(hm.getOrDefault(removeNum,0) == 0) hm.remove(removeNum);
                }
            }

            hm.put(type,hm.getOrDefault(type,0)+1);
            maxLength=Math.max(maxLength,i-left+1);
            i++;
        }

        return maxLength;
    }
}