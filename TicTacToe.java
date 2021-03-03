
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
		int[] cond0 = {1, 2, 3};
		int[] cond1 = {4, 5, 6};
		int[] cond2 = {7, 8, 9};
		int[] cond3 = {1, 4, 7};
		int[] cond4 = {2, 5, 8};
		int[] cond5 = {3, 6, 9};
		int[] cond6 = {1, 5, 9};
		int[] cond7 = {3, 5, 7};

		checkCondition.add(cond0);
		checkCondition.add(cond1);
		checkCondition.add(cond2);
		checkCondition.add(cond3);
		checkCondition.add(cond4);
		checkCondition.add(cond5);
		checkCondition.add(cond6);
		checkCondition.add(cond7);
	}
	
	public static void createBoard() {
		for(int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
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
        }
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
	
	public static boolean block() {

		if (con(PlayerLetter)) {
			for (int l = 0; l < checkCondition.get(index).length; l++) {
				if (board[checkCondition.get(index)[l]] == ' ') {
					board[checkCondition.get(index)[l]] = ComputerLetter;
						checkCondition.remove(index);
							return true;
				}
			}
		}
		return false;
	}
	
	public static void computerMove() {
		int[] corner = {1, 3, 7, 9};
		int centre = 5;
		int[] sides = {2, 4, 6, 8};

			boolean check = true;
				for (int l=0; l<corner.length; l++) {
					if(board[corner[l]] == ' ') {
						board[corner[l]] = ComputerLetter;
						check = false;
						break;
					}
				}
					
					if (check) {
						if (board[centre] == ' ') {
							board[centre] = ComputerLetter;
							check = false;
						}
					}
					
					if (check) {
						for(int l=0; l<sides.length; l++) {
							if (board[sides[l]] == ' ') {
								board[sides[l]] = ComputerLetter;
								break;
							}
						}
					}
	}
	
	public static void makeComputerMove() {
		if (computerWinning()) {
		}
		else if(block()) {
		}
		else{
			computerMove();
		}
	}
	
	public static void execute() {
		String check = "YES";
		while(check.equals("YES")) {
			TicTacToe ticTacToeGame = new TicTacToe();
			conditionForWin();
			ticTacToeGame.createBoard();
			choose();
			System.out.println("Player Letter : " + PlayerLetter);
			System.out.println("Computer Letter: " + ComputerLetter);
			showBoard();
			Toss();
			turn();
			System.out.println("You Want To Play Again?? Please enter Yes or No.");
			check = sc.next().toUpperCase();
		}
		System.out.println("OK Thanks For Playing");
	}

	
	public static void main(String[] args) {
		System.out.println("Welocme to Tic-Tac-Toe program");
	
		try {
			System.out.println("Welcome to TicTacToeGame");
			execute();
		}
		catch(Exception e) {
			System.out.println("Invalid Inputs Play Again");
			execute();		
		}
	}
}
