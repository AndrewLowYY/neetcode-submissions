class Solution {
    private static final int INF = 2147483647;
    
    private static final int[] dX = {0, 1, 0, -1};
    private static final int[] dY = {1, 0, -1, 0};

    private record Point(int x, int y, int dist) {};

    public void islandsAndTreasure(int[][] grid) {

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 0) {
                    bfs(grid, x, y);
                }
            }
        }

    }

    public void bfs(int[][] grid, int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.offer(new Point(x, y, 0));
        while(!queue.isEmpty()) {
            Point current = queue.poll();

            int curX = current.x();
            int curY = current.y();

            if (visited[curY][curX]) continue;

            // visit point
            visited[curY][curX] = true;
            grid[curY][curX] = Math.min(grid[curY][curX], current.dist());

            for (int i = 0; i < 4; i++) {
                int targetX = current.x() + dX[i];
                int targetY = current.y() + dY[i];

                if (targetX < 0 || targetX >= grid[0].length || targetY < 0 || targetY >= grid.length || visited[targetY][targetX] || grid[targetY][targetX] <= 0 || grid[targetY][targetX] < current.dist()) continue;

                queue.offer(new Point(targetX, targetY, current.dist() + 1));
            }
        }

    }
}
