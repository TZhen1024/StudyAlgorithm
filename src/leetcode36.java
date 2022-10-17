public class leetcode36 {
    public static void main(String[] args) throws Exception {
        char[][] board1 = {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board1));
            
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            int[] numsInR = {1,1,1,1,1,1,1,1,1};
            int[] numsInC = {1,1,1,1,1,1,1,1,1};
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if((--numsInR[board[i][j] - '0' - 1] < 0))
                        return false;
                }
                if(board[j][i] != '.') {
                    if((--numsInC[board[j][i] - '0' - 1] < 0))
                        return false; 
                }
            }
        }
        for(int i = 0; i < 9; i = i + 3) {
            for(int j = 0; j < 9; j = j + 3) {
                int[] nums = {1,1,1,1,1,1,1,1,1};
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        if(board[i + m][j + n] != '.') {
                            if(--nums[board[i + m][j + n] - '0' - 1] < 0) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
