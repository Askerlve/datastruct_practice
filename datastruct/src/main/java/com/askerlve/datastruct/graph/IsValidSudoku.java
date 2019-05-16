package com.askerlve.datastruct.graph;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Askerlve
 * @Description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 1:数字 1-9 在每一行只能出现一次。
 * 2.数字 1-9 在每一列只能出现一次。
 * 3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @date 2019/5/16上午9:46
 */
public class IsValidSudoku {

    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            Arrays.fill(rows, new HashMap<>());
            Arrays.fill(columns, new HashMap<>());
            Arrays.fill(boxes, new HashMap<>());
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                String rowKey = i + "row" + num;
                String colKey = j + "col" + num;
                int groupIndex = i / 3 + j / 3 * 3;
                String groupKey = groupIndex + "group" + num;
                //寻找是否有重复的数字
                if (map.getOrDefault(rowKey, false)
                        || map.getOrDefault(colKey, false)
                        || map.getOrDefault(groupKey, false)) {
                    return false;
                }
                //更新遍历记录
                map.put(rowKey, true);
                map.put(colKey, true);
                map.put(groupKey, true);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] flag = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int num = board[i][j]-'1';
                int row = i;
                int col = j;
                int k = (i)/3;
                int m = (j)/3;
                int ge = 3*k+m;
                if((flag[num][row]&1)!=0)
                    return false;
                flag[num][row] += 1;
                if((flag[num][col]&2)!=0)
                    return false;
                flag[num][col] += 2;
                if((flag[num][ge]&4)!=0)
                    return false;
                flag[num][ge] += 4;
            }
        }
        return true;
    }

}
