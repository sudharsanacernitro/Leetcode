class LRUCache {

    int capacity=0;

    HashMap<Integer,Integer> hm=new HashMap<>();
    Deque<Integer> q=new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {

        if(!hm.containsKey(key)) return -1;

        q.remove(key);
        q.addFirst(key);

        return hm.get(key);
        
    }
    
    public void put(int key, int value) {

        if(hm.containsKey(key))
        {
            q.remove(key);
            q.addFirst(key);
            hm.put(key,value);
        }
        else{
                if(q.size() < capacity)
                {
                    q.addFirst(key);
                    hm.put(key,value);
                }
                else{
                    int k=q.pollLast();
                    hm.remove(k);

                    q.addFirst(key);
                    hm.put(key,value);
                }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */