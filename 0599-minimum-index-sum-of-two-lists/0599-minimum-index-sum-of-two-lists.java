import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> hm = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        TreeMap<Integer, List<String>> tm = new TreeMap<>();

        for (int i = 0; i < list2.length; i++) {
            if (hm.containsKey(list2[i])) {
                int sum = hm.get(list2[i]) + i;
                if (min >= sum) {
                    min = sum;
                    List<String> list = tm.getOrDefault(min, new ArrayList<>());
                    list.add(list2[i]);
                    tm.put(min, list);
                }
            }
        }

        return tm.get(min).toArray(new String[0]);
    }
}
