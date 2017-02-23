
import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {
	char player1= 'x';
	char player2= 'o';
	char [][] board ;
	
	
	public TicTacToe( int n) {
		board = new char [n][n];	
		
	}

	/** 
	 * This is for set or reset the board back to all empty values.
	 */
	public void initializeBoard(){
		for (int row=0; row < board.length; row++){
			
			Arrays.fill(board[row],' ');
		}
	
	}
	/**
	 * This is for printing the current board.
	 */
	public void printBoard(){
		
		
		for (int row=0; row < board.length; row++){
			for (int col=0; col < board[row].length; col++ ){
				System.out.print( board[row][col]);
				if (col < board[row].length-1){
					System.out.print("|");
				}
				
			}
			String line = "";
			if (row < board.length-1){
				for (int i=0; i<board.length; i++){
					line+="--";
				}
				System.out.print("\n"+ line+"\n");
			}
		}
	}
	
	
	/**
	 * check is full or not
	 * 
	 */
	public boolean isBoardFull(){
		for (int row=0; row<board.length; row++){
			for (int col=0; col<board[row].length; col++){
				if (board[row][col] == ' '){
					return false;
				}
				
			}
		}
		System.out.println("This board is full, please re-start the game ");
		return true;
	}
	
	
	/**
	 * 
	 * check if there's a winner or not
	 */
	public boolean checkForWin(){
		
		
		if (checkForWinByRow() || checkForWinByDiagal() || checkForWinByCol()){
			System.out.println(" you win !! ");
			return true; 
		}
		
		return false;
	}
	
	private boolean checkForWinByRow() {
		for (int row = 0; row < board.length; row++) {
			char temp = board[row][0];
			boolean isWin = true;
			for (int col = 1; col < board[0].length; col++) {
				if (board[row][col] != temp || board[row][col] == ' ') {
					isWin = false;
				}
			}
			if (isWin) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkForWinByCol() {
		for (int col = 0; col < board.length; col++) {
			char temp = board[0][col];
			boolean isWin = true;
			for (int row = 1; row < board[0].length; row++) {
				if (board[row][col] != temp || board[row][col] == ' ') {
					isWin = false;
				}
			}
			if (isWin) {
				return true;
			}
			
		}
		return false;
	}
	
	private boolean checkForWinByDiagal() {
		char temp = board[0][0];
		boolean isWin = true;
        for (int row = 1; row < board.length; row++) {
        	if (temp != board[row][row] || board[row][row] == ' ') {
        		isWin = false;
        	}
        }
        if (isWin) {
        	return true;
        }
        isWin = true;
        int length = board.length;
        temp = board[0][length - 1];
        for (int row = 1; row < length; row++) {
        	if (temp != board[row][length - 1 - row] || board[row][length - 1 - row] == ' ') {
        		isWin = false;
        	}
        }
        return isWin;
	}
	
	/**
	 * change player marks back and forth
	 * 
	 */
	public char changePlayer(){
		int counter=0;
		for (int row=0; row<board.length; row++){
			for (int col=0; col<board[row].length; col++){
				if(board[row][col] != ' '){
					counter++;
				}
			}	
		}
		if (counter%2==0){
			return player1;
		}
		return player2;
		
	}
	
	
	/**
	 * place the mark of the current player at the cell specified by row and col. 
	 */
	public boolean placeMark(char player, int row, int col){
		if (board[row][col] == ' '){
		 board[row][col] = player;
		 return true;
		}
		System.out.println(" you should mark on other space, it is full !");
		return false;
	} 
	public static void main(String[] args) {
		TicTacToe test= new TicTacToe(3);
		test.initializeBoard();
		test.printBoard();
		while ( !test.isBoardFull() && !test.checkForWin()){
			Scanner mark = new Scanner(System.in);
			System.out.println("");
			char player = test.changePlayer();
			int row = 0;
			int col = 0;
			do {
				System.out.println("enter a row");
				row = mark.nextInt();
				System.out.println("enter a col");
				col = mark.nextInt();
			} while (!test.placeMark(player, row, col ));
			test.printBoard();
		}
	}

}
