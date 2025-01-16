package home;

import java.util.HashSet;

public class SudokuBoard {
    //Sodaku board simple solution: Each row must contain the digits 1-9 without repetition.
    //Each column must contain the digits 1-9 without repetition.
    //Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i =0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    String str = "(" + board[i][j] + ")";
                    if (!seen.add(str + i) ||
                            !seen.add(j + str) ||
                            !seen.add(i / 3 + str + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuBoard sb = new SudokuBoard();
        char[][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sb.isValidSudoku(board));
    }
}
