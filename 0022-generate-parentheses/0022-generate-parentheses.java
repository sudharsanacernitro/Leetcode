class Solution {

    List<String> result=new ArrayList<>();

    void dfs(int n,String str,int open,int close)
    {
        if(str.length() == n*2 && open == close) 
        {
            result.add(str);
            return;
        }

        if(open > close)
        {
            dfs(n,str+')',open,close+1);
        }

        if(open < n)
        {
            dfs(n,str+'(',open+1,close);
        }
    }
    public List<String> generateParenthesis(int n) {
        dfs(n,"",0,0);
        return result;
    }
}