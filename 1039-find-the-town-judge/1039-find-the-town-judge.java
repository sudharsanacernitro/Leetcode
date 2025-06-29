class Solution {
    public int findJudge(int n, int[][] trust) {
        
       int[] out=new int[n+1];
       int[] in=new int[n+1];

       if(n==1) return 1;

       for(int[] i:trust)
       {
        int u=i[0];
        int v=i[1];

        out[u]=out[u]+1;
        in[v]=in[v]+1;
       }

       for(int i=0;i<n+1;i++)
       {
        if(in[i] == n-1 && out[i] == 0)
        return i;
       }

       return -1;
    }
}