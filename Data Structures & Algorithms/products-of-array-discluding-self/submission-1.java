class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        leftToRight[0] = nums[0];
        rightToLeft[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] = nums[i] * leftToRight[i - 1];
            rightToLeft[nums.length - 1 - i] = nums[nums.length - 1 - i] * rightToLeft[nums.length - i];
        }

        int[] result = new int[nums.length];

        result[0] = rightToLeft[1];
        result[nums.length - 1] = leftToRight[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = leftToRight[i - 1] * rightToLeft[i + 1];
        }
        return result;
    }
}  
