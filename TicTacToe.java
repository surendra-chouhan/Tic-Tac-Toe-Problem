
import java.util.Scanner;

public class TicTacToe {
	public static char[] board;
	public static String PlayerLetter;
	public static String ComputerLetter;
	static Scanner sc = new Scanner(System.in);
	
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
	
	public static void showBoard() {
		System.out.println (board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println (board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println (board[7] + " | " + board[8] + " | " + board[9]);
	}
	
	public static void makePlayerMove(){

		System.out.println("Enter the position you want to move to : "
        					+ "\nPosition must be betwween 1 to 9");
        int position = sc.nextInt();

        if(position >= 1 && position <= 9)
        	board[position] = PlayerLetter.charAt(0);
        else
        	System.out.println("Position value is wrong");
        
        showBoard();
	}
	
	public static void makeComputerMove() {
		int cposition = (int)Math.floor(Math.random() * (10-1))+1;
		
		if(board[cposition] == 0 ) {
			System.out.println("Computer will put " + ComputerLetter.charAt(0) + " at position : " + cposition);
			board[cposition] = ComputerLetter.charAt(0);
		}
		
		showBoard();
	}

	
	public static void main(String[] args) {
		System.out.println("Welocme to Tic-Tac-Toe program");
		
		
		board = new char[10];
		
		System.out.println("Please Choose X or O");
		String option = sc.next().toUpperCase();		
		
		choose(option);
		System.out.println("Player is : " + PlayerLetter);
		System.out.println("Computer is : " + ComputerLetter);
	
		showBoard();
        makePlayerMove();
        makeComputerMove();
	}
}
