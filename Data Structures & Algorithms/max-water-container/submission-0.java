class Solution {
    public int maxArea(int[] heights) {
        int leftIdx = 0;
        int rightIdx = heights.length - 1;

        int maxVol = 0;

        while (leftIdx < rightIdx) {
            int currentVol = Math.min(heights[leftIdx], heights[rightIdx]) * (rightIdx - leftIdx);
            maxVol = Math.max(maxVol, currentVol);

            if (heights[leftIdx] < heights[rightIdx]) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return maxVol;
    }
}
