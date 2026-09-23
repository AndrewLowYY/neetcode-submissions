class Solution {

    private int[] dCol = {1, 0, -1, 0};
    private int[] dRow = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    dfs(grid, x, y);
                    counter++;
                }
            }
        }

        return counter;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (grid[y][x] == '1') {
            grid[y][x] = '0';
        } else {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + dRow[i];
            int newY = y + dCol[i];

            if (newX >= grid[0].length || newX < 0 || newY >= grid.length || newY < 0) {
                continue;
            }
            dfs(grid, newX, newY);
        }
    }
}
