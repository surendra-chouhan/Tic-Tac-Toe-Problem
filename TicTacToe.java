
import java.util.*;
import java.util.Scanner;

public class TicTacToe {
	public static char[] board;
	public static String PlayerLetter;
	public static String ComputerLetter;
	
	static char[] createBoard() {

		char[] board = new char[10];
		
		for(int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static String choose(String option) {
		
		if(option.equals("X")) { 
			PlayerLetter = "X";
			ComputerLetter = "O";
		}
		else if(option.equals("O")) {
			ComputerLetter = "X";
			PlayerLetter = "O";
		}
		else {
			System.out.println("Incorrect Input");
		}
		return ComputerLetter;
	}
	public static void main(String[] args) {
		System.out.println("Welocme to Tic-Tac-Toe program");
		
		
		TicTacToe tictac = new TicTacToe();
		board = new char[10];//createBoard();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Choose X or O");
		String option = sc.next();		
		
		tictac.choose(option);
		System.out.println("Player is : " + PlayerLetter);
		System.out.println("Computer is : " + ComputerLetter);
	}
}
