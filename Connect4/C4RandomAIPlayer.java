package week10;

import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	final int ROWS=6;
	final int COLS=7;
	C4RandomAIPlayer(char piece, Connect4Grid board) {
		super(piece, board);
	}

	@Override
	public boolean makeMove(int col) {
		boolean finished=false;
		Random random = new Random();
		int move = random.nextInt(7-1);
		while (!finished)
		if (!getGrid().isGridFull()) {
			if (getGrid().isValidColumn(move)) {
				if (!getGrid().isColumnFull(move)) {
					getGrid().dropPiece(this, move);
					finished = true;
				}
			}
		}
		return true;
	
	}
	public int scanBoard() {
		Connect4Grid theBoard = getGrid();
		for (int row=0; row<ROWS; row++) {
			for (int col=0; col<COLS; col++) {
				
			}
		}
		return -1;
	}
}