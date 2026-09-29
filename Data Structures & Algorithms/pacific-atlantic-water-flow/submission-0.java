class Solution {

    private record Point(int row, int col) {};

    private static final int[] dRow = {1, 0, -1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Point> atl = new HashSet<>();
        Set<Point> pac = new HashSet<>();

        for (int i = 0; i < heights.length; i++) {
            System.out.println("traversing row " + i);
            dfs(i, 0, heights, pac, new boolean[heights.length][heights[0].length]);
            dfs(i, heights[0].length - 1, heights, atl, new boolean[heights.length][heights[0].length]);
        }

        for (int i = 0; i < heights[0].length; i++) {
            dfs (0, i, heights, pac, new boolean[heights.length][heights[0].length]);
            dfs (heights.length - 1, i, heights, atl, new boolean[heights.length][heights[0].length]);
        }
        atl.retainAll(pac);
        return atl.stream()
            .map(point -> List.of(point.row(), point.col()))
            .toList();
        
    }

    private void dfs(int row, int col, int[][] heights, Set<Point> ocean, boolean[][] visited) {
        visited[row][col] = true;
        ocean.add(new Point(row, col));
        for (int i = 0; i < 4; i++) {
            int targetRow = row + dRow[i];
            int targetCol = col + dCol[i];
            if (targetRow < 0 || targetRow >= heights.length || targetCol < 0 || targetCol >= heights[0].length || heights[row][col] > heights[targetRow][targetCol] || visited[targetRow][targetCol]) {
                continue;
            }
            dfs(targetRow, targetCol, heights, ocean, visited);
        }
    }


}
