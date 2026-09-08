class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            Integer targetIdx = map.get(target - num);
            if (targetIdx != null) {
                return new int[]{targetIdx, i};
            }
            map.put(num, i);
        }

        return null;
    }
}
