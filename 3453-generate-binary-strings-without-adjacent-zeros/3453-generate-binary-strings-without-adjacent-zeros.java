class Solution {

    public List<String> validStrings(int n) {

        HashSet<String> res = new HashSet<>();

        dfs( res,"",n);

        return new ArrayList<>(res);

    }

    void dfs(HashSet<String> result , String curr , int size)
    {
        if( size == curr.length())
        {
            result.add(curr);
            return;
        }

        dfs(result , curr+'1' ,size);

        if( curr.length() == 0 || curr.charAt( curr.length() -1) != '0')
        dfs(result , curr+'0' , size);
    }
}