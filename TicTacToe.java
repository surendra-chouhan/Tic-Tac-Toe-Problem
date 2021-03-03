
import java.util.*;

public class TicTacToe {
	static char board[] = new char[10];
	static char PlayerLetter;
	static char ComputerLetter;
	static int count=0;
	static int chance;
	static int index;
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<int[]> checkCondition = new ArrayList<>();
	
	public static void conditionForWin() {
		int[] row1 = {1, 2, 3};
		int[] row2 = {4, 5, 6};
		int[] row3 = {7, 8, 9};
		int[] col1 = {1, 4, 7};
		int[] col2 = {2, 5, 8};
		int[] col3 = {3, 6, 9};
		int[] diag1 = {1, 5, 9};
		int[] diag2 = {3, 5, 7};

		checkCondition.add(row1);
		checkCondition.add(row2);
		checkCondition.add(row3);
		checkCondition.add(col1);
		checkCondition.add(col2);
		checkCondition.add(col3);
		checkCondition.add(diag1);
		checkCondition.add(diag2);
	}
	
	static char[] createBoard() {
		for(int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void choose() {
		System.out.println("Choose X or O :");
		PlayerLetter = sc.next().toUpperCase().charAt(0);
		
		if(PlayerLetter == 'X') {
			ComputerLetter = 'O';
		}
		else if(PlayerLetter == 'O') {
			ComputerLetter = 'X';
		}
		else {
			System.out.println("Invalid Input");
			choose();
		}
	}
	
	public static void showBoard() {
		System.out.println (board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println (board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println (board[7] + " | " + board[8] + " | " + board[9]);
	}
	
	public static void Toss() {
		System.out.println("Lets Toss! \nEnter 1 for Heads and 2 for Tails");
		int opt = sc.nextInt();
		int chance = (int)(Math.random() * 2 + 1);
		 
		if(opt == chance) {
			System.out.println("Player won the toss!");
			count = 0;
		}
		else {
			System.out.println("Computer won the toss!");
			count = 1;
		}
	}
	
	public static void makePlayerMove(){

		System.out.println("Enter the position you want to move to : "
        					+ "\nPosition must be betwween 1 to 9");
        int position = sc.nextInt();

        if (board[position] != ' '){
        	System.out.println("Position is taken. \n Enter again");
        	makePlayerMove();
        }
        else {
        	board[position] = PlayerLetter;
            //showBoard();
        }
    }

	public static char checkWinner() {
		final int WIN_CONDITION = 3;
	
		for(int index = 0; index < checkCondition.size(); index++) {
			int addX = 0;
			int addO = 0;
			for(int i =0; i < checkCondition.get(index).length; i++) {
				if(board[checkCondition.get(index)[i]] == 'X') {
					addX += 1;
					if(addX == WIN_CONDITION)
						return 'X';
				}
				else if(board[checkCondition.get(index)[i]] == 'O') {
					addO += 1;
					if(addO == WIN_CONDITION)
						return 'O';					
				}
			}
		}
		return ' ';
	}	

	public static boolean tie() {
		for(int k = 1; k < 10; k++) {
			if(board[k] == ' ')
				return false;
		}
		return true;
	}
	
	public static void turn() {
		while(true){
			if(checkWinner() == 'X' || checkWinner() == 'O') {
				System.out.println((PlayerLetter == checkWinner())?"Player Wins":"Computer Wins");
				break;
			}
			else if (tie()) {
				System.out.println("It's a tie");
				break;
			}
			else{
				if(count%2 == chance) {
					System.out.println("Your Turn");
					makePlayerMove();
					showBoard();
				}
				else {
					System.out.println("Computer's Turn");
					makeComputerMove();
					showBoard();
				}
				count++;
			}
		}
	}
	
	public static void makeComputerMove() {
		if(computerWinning()) {
		}
	}
	
	public static boolean con(char letter) {
		for(int index = 0; index < checkCondition.size(); index++) {
			int sum = 0;
			for(int j = 0; j < checkCondition.get(index).length; j++) {
				if(board[checkCondition.get(index)[j]] == letter) {
					sum = sum + 1;
					if (sum == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean computerWinning() {
		if(con(ComputerLetter)) {
			for (int l = 0; l < checkCondition.get(index).length; l++) {
				if(board[checkCondition.get(index)[1]] == ' ') {
					board[checkCondition.get(index)[1]] = ComputerLetter;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Welocme to Tic-Tac-Toe program");
				
		conditionForWin();
		createBoard();
		choose();
		System.out.println("Computer Letter : " + ComputerLetter);
		System.out.println("Player Letter : " + PlayerLetter);
		showBoard();
		Toss();
		turn();
	}
}
