package tictctoe;

public class TicTacToe {

	
	private String board[][];
	private static final int ROWS=3;
	private static final int COLUMS=3;
	private String regex = "\\s{3}";
   // private String failedMessage = "this move was invalid";
	
	public TicTacToe(){
		board=new String[ROWS][COLUMS];
		this.initializeBoard();
	
	}
	
	
	//initialize board function
	public void initializeBoard(){
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLUMS;j++) {
				board[i][j]="   ";
			}
		}
	}
	
	public void setPlay(int i,int j,String player) {
		if(this.board[i][j].matches(regex)) {
			board[i][j] =player;
		}
	}
	
	public boolean isGameOver(){
		for(int i=0;i<ROWS;i++) {
			if(!board[i][0].matches(regex)&&board[i][0].equals(board[i][1])&&board[i][1].equals(board[i][2])) {
		return true;
			}
		}
			for(int j=0;j<COLUMS;j++) {
				if(!board[j][0].matches(regex)&&board[j][0].equals(board[j][1])&&board[j][1].equals(board[j][2])) {
			return true;
				}
				
				}
			//checking diagonals
			if(!board[0][0].matches(regex)&&board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])) {
				return true;
			}
			if(!board[0][2].matches(regex)&&board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0])) {
				return true;
			}
			
			 
	return false   ;
	}
	
	
	
//printing the board in system.out.println
	public String printBoard() {
		String strBoard="";
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLUMS;j++) {
				strBoard +=board[i][j] +"|";
			
			}
			strBoard += "\n---+---+---\n";
		
		}
		return strBoard;
	}
	
	

	

	
}
