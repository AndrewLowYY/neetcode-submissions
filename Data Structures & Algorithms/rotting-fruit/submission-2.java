class Solution {

    private record Plot(int x, int y) {};

    private static final int[] dX = {0, 1, 0, -1}, dY = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        Set<Plot> rottenOranges = new HashSet<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 2) {
                    rottenOranges.add(new Plot(x, y));
                }
            }
        }
        return bfs(grid, rottenOranges);
    }

    private int bfs(int[][] grid, Set<Plot> rottenOranges) {

        int minutes = 0;

        Queue<Plot> queue = new LinkedList<>();
        queue.addAll(rottenOranges);

        Set<Plot> nextBatch = new HashSet<>();
        while (!queue.isEmpty()) {
            Plot current = queue.poll();
            int curX = current.x();
            int curY = current.y();


            for (int i = 0; i < 4; i++) {
                int targetX = curX + dX[i];
                int targetY = curY + dY[i];

                if (targetX < 0 || targetX >= grid[0].length || targetY < 0 || targetY >= grid.length || grid[targetY][targetX] != 1) continue;
                grid[targetY][targetX] = 2;
                nextBatch.add(new Plot(targetX, targetY));
            }
            if (queue.isEmpty()) {
                minutes++;
                if (!nextBatch.isEmpty()) {
                    queue.addAll(nextBatch);
                    nextBatch.clear();
                } else {
                    minutes--;
                }
            }
        }

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) return -1;
            }
        }
        return minutes;
    }
}
