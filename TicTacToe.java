
import java.util.*;

public class TicTacToe {
	static char[] board;

	static char[] createBoard() {

		char[] board = new char[10];
		
		for(int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {
		System.out.println("Welocme to Tic-Tac-Toe program");
		
		createBoard();
	}
}
