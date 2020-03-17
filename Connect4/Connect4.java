/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to 
play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialised - must specify the type to be ConnectPlayer, and 
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. 
Finally a check is performed to determine a win. 
Comment: My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to 
play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 
the two players are initialized - must specify the type to be ConnectPlayer, and the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. 
Finally a check is performed to determine a win. 

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: I define all 7 methods within the interface.

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.


ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: My class provides at lest one non-abstract method and at least one abstract method. 


C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.


C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 


Total Marks out of 100: 100

*/

package week10;

import java.util.*;

public class Connect4 {

	public static void main(String[] args) {
		Connect4Grid grid = new Connect4Grid2DArray();
		grid.emptyGrid();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the amount of players: ");
		int numberOfPlayers=scanner.nextInt();
		ConnectPlayer playerOne = new C4HumanPlayer('R', grid);
		ConnectPlayer playerTwo = new C4RandomAIPlayer('Y', grid);
		if (numberOfPlayers==2) {
			 playerTwo = new C4HumanPlayer('Y', grid);
		}
		
		System.out.print("\n" + grid.toString());
		boolean finished = false;
		boolean playerOnesTurn = true;
		while (!finished) {
			if (playerOnesTurn) {
				System.out.print("\nPlayer one select column: ");
				int column = scanner.nextInt();
				playerOne.makeMove(column);
				playerOnesTurn = false;
			} else {
				if (numberOfPlayers==1) {
				playerTwo.makeMove(0);
				}
				else {
					System.out.print("\nPlayer two select column: ");
					int column = scanner.nextInt();
					playerTwo.makeMove(column);
				}
				playerOnesTurn = true;
			}
			System.out.print("\n" + grid.toString());
			if (grid.didLastPieceConnect4()) {
				System.out.println("You win");
				finished = true;
			}
			else if (grid.isGridFull() && grid.didLastPieceConnect4() ) {
				System.out.println("you win");
				finished = true;
			}
			else if (grid.isGridFull() && !grid.didLastPieceConnect4()) {
				System.out.println("Unfortunately there were no winners, better luck next time");
				finished = true;
			}
		}
		
		scanner.close();
	}
}