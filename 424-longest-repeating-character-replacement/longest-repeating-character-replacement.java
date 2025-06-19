class Solution {
    public int characterReplacement(String s, int k) {
        
         HashMap<Character,Integer> hm=new HashMap<>();
        
        char arr[]=s.toCharArray();

        int left=0,maxFreq=0,max=0;
        
        for(int right=0;right<arr.length;right++)
        {
            char add=arr[right];
            
            hm.put(add,hm.getOrDefault(add,0)+1);

             maxFreq=Math.max(maxFreq,hm.get(add));

             while((right-left+1) -maxFreq > k)
             {
                char remove=arr[left];
                hm.put(remove,hm.get(remove)-1);
                left++;
             }

             
                max=Math.max(max,(right-left+1));
             
            
           
        }
        
        return max;
    }
}