package com.askerlve.datastruct.graph;

/**
 * @author Askerlve
 * @Description: 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * @date 2019/5/15上午9:32
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        //遍历二维数组
        for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    //遇到1就把与它相邻的1变为0 count++
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid , int i , int j){
        if(i >=0 && i < grid.length && j >= 0 && j < grid[0].length){
            if(grid[i][j] == '1'){
                grid[i][j] = '0';
                dfs(grid,i,j+1);
                dfs(grid,i,j-1);
                dfs(grid,i+1,j);
                dfs(grid,i-1,j);
            }
        }
    }

}
