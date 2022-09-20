
class Solutions {
	public static final int GRID_SIZE = 9;

	public static Boolean checkGrid(char[][] board, int row,int col, char val) {
		row = row - row % 3;
		col = col-col%3;
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (board[i][j] == val) {
					return true;
				}
			}
		}
		return false;
	}

	public static Boolean checkRow(char[][] board, int row, char val) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val) {
				return true;
			}
		}
		return false;
	}

	public static Boolean checkCol(char[][] board, int col, char val) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == val) {
				return true;
			}
		}
		return false;
	}

	public static Boolean isValidPlacement(char[][] board, int row, int col, char val) {
		return !checkGrid(board,row,col,val)&&!checkRow(board,row,val)&&!checkCol(board,col,val);
	}
	
	private static void printBoard(char[][] board) {
	    for (int row = 0; row < GRID_SIZE; row++) {
	      if (row % 3 == 0 && row != 0) {
	        System.out.println("-----------");
	      }
	      for (int column = 0; column < GRID_SIZE; column++) {
	        if (column % 3 == 0 && column != 0) {
	          System.out.print("|");
	        }
	        System.out.print(board[row][column]);
	      }
	      System.out.println();
	    }
	  }

	public static Boolean solveBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValidPlacement(board, i, j, num)) {
							board[i][j] = num;
							if (solveBoard(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void solveSudoku(char[][] board) {
		solveBoard(board);
	}

	public static void main(String[] args) {
		String[][] boards = { { "5", "3", ".", ".", "7", ".", ".", ".", "." },
				{ "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
				{ "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
				{ "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
				{ ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
		
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = boards[i][j].charAt(0);
			}
		}
		printBoard(board);
		System.out.println();
		solveSudoku(board);
		printBoard(board);

	}

}
