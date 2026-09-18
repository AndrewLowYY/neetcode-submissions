class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cumulativeCost = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            cumulativeCost[i] = Math.min(cumulativeCost[i - 2] + cost[i - 2], cumulativeCost[i - 1] + cost[i-1]);
        }

        return cumulativeCost[cost.length];
    }
}
