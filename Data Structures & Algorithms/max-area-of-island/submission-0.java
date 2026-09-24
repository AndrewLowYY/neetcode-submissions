class Solution {

    private static final int[] dCol = {1, 0, -1, 0};
    private static final int[] dRow = {0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for(int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    maxArea = Math.max(dfs(grid, x, y), maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (grid[y][x] == 0) {
            return 0;
        }

        // visit coordinate, add area to running count
        grid[y][x] = 0;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dRow[i];
            int newY = y + dCol[i];

            if (newX < 0 || newX >= grid[0].length || newY < 0 || newY >= grid.length) continue;

            area += dfs(grid, newX, newY);
        }

        return area;

    }
}
