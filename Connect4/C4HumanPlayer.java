package week10;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer(char piece, Connect4Grid board) {
		super(piece, board);

	}

	@Override
	public boolean makeMove(int col) {
		if (!getGrid().isGridFull()) {
			if (getGrid().isValidColumn(col)) {
				if (!getGrid().isColumnFull(col)) {
					getGrid().dropPiece(this, col);
					return true;
				}
			}
		}
		return false;
	}
}
