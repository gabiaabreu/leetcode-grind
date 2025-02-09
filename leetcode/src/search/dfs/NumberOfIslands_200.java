package search.dfs;

public class NumberOfIslands_200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // find first 1. its not visited yet
                // find next 1. it might be already visited, so we check
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // found another island (1 and not visited)
                    islands++;

                    // in each call to dfs, it will find the whole island and mark all as visited
                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }

    public static void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j, grid, visited); // down
        dfs(i - 1, j, grid, visited); // up
        dfs(i, j + 1, grid, visited); // right
        dfs(i, j - 1, grid, visited); // left
    }
}
