class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
