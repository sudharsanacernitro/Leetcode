class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length(),max=0;
        for(int i=0;i<n;i++)
        {
            HashSet<Character> hs=new HashSet<>();
            int j=i;
            while(j <n && !hs.contains(s.charAt(j)))
            {
                hs.add(s.charAt(j));
                j++;
            }

            if(max < j-i)
            {
                max=j-i;
            }
        }

        return max;

    }
}