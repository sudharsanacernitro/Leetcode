class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();

        List<Integer> lst=new ArrayList<>();

        int count=0;

        for(Character i:p.toCharArray())
        {
            hm1.put(i,hm1.getOrDefault(i,0)+1);
        }
        boolean startRemove=false;

        int k=p.length();

        for(int i=0;i<s.length();i++)
        {
            char addChar=s.charAt(i);

            if( i>= k)
            {
                char removeChar=s.charAt(i-k);
                hm2.put(removeChar,hm2.get(removeChar)-1);
                 if (hm2.get(removeChar) == 0) {
                    hm2.remove(removeChar); 
                }
            }

            hm2.put(addChar,hm2.getOrDefault(addChar,0)+1);

        if (i >= k - 1) {
            boolean flag=true;

             for(char key:hm1.keySet())
             {
                if(hm2.containsKey(key) && hm2.get(key).equals(hm1.get(key)) )continue;

                flag=false;
                
             }  

             if(flag) lst.add(i-k+1); }
        }

        return lst;
    }
}