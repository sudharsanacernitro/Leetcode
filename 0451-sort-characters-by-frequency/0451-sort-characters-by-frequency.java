class Solution {
    public String frequencySort(String s) {
        class Pair
        {
            int freq;
            char chr;
            Pair(char chr,int freq)
            {
                this.chr=chr;
                this.freq=freq;
            }
        }

        char arr[]=s.toCharArray();
        Arrays.sort(arr);

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);

        int i=0;
        while(i<arr.length)
        {
            int j=i+1;

            while(j<arr.length && arr[i] == arr[j])
            {
                j++;
            }

            pq.add(new Pair(arr[i],j-i));
            i=j;
        }

        String result="";
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();

            result+=String.valueOf(curr.chr).repeat(curr.freq)+"";
        }

        return result;

    }
}