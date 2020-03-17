package week10;

public abstract class ConnectPlayer {
	private char piece;
	private Connect4Grid board;
	
	
	public ConnectPlayer(char piece, Connect4Grid grid) {
		this.piece = piece;
		board=grid;
	}
	public abstract boolean makeMove(int col);
	
	public char getPiece() {
		return this.piece;
		
	}
	public Connect4Grid getGrid() {
		return board;
	}
}