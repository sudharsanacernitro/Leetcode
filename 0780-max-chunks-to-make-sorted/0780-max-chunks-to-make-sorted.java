class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n=arr.length,count=0;
       
       int arrValue=0,indexValue=0;
        for(int i=0;i<n;i++)
        {
            arrValue+=arr[i];
            indexValue+=i;

            if(arrValue == indexValue)
            {
                count++;
            }
        }

      

        return count;
    }
}