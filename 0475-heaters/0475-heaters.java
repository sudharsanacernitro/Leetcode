class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxDistance = 0;

        for (int house : houses) {
            int dist = findMinDistance(house, heaters);
            maxDistance = Math.max(maxDistance, dist);
        }

        return maxDistance;
    }

    private int findMinDistance(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        int minDist = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int dist = Math.abs(heaters[mid] - house);
            minDist = Math.min(minDist, dist);

            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minDist;
    }
}
