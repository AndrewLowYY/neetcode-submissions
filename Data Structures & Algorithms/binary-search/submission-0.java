class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

            middle = left + (right - left) / 2;
        }
        return -1;
    }
}
