class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        for (int asteroid : asteroids) {
            if (mass < asteroid) return false;
            
            mass += asteroid;
            if (mass < 0) return true; 
        }
        
        return true;
    }
}
