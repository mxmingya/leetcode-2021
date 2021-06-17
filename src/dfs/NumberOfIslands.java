package dfs;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;

    }

    void dfs(char[][] grid, int x, int y) {
        // return when hit boundaries
        if (x < 0  || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        // process each cell
        grid[x][y] = '0';

        // dfs
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x , y - 1);
    }

    public static void main(String[] args) {
        char[][] test = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
        new NumberOfIslands().numIslands(test);

    }
}
