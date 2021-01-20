package ca.bc.nic.cps100;

/*
 * Author: Amanda Thompson
 * CPS 100 - DLS1
 * Assignment 9
 * Due: Nov 28, 2020
 * Nov 28, 2020
 */

//**************************************************************************
// This Main Game Hub inherits from GameRootAbstr and the houses all the 
// methods neccessary to play Pig, HiLo, and Rock, Paper, Scissors.
//**************************************************************************

import java.util.Scanner;

public class MainGameHub extends GameRootAbstr {

	protected String user;

	Scanner in = new Scanner(System.in);

	protected int userGuess;

	protected String str;

	protected int count = 0; // Counter to keep track of rolls for youAreAPig method

	protected boolean an; // stores console input in an - 'answer'
	// ***********************************************************************

	// Constructor with superclass
	public MainGameHub() {
		super();

	}
	// **********************************************************************
	// PIG game methods
	// **********************************************************************

	// Core Pig game logic
	@Override
	public int corePigGame() {
		// TODO Auto-generated method stub

		do {

			DiceRoll();

			// if die a and die b are greater than one
			if (a > 1 && b > 1) {

				// Roll two dice, add them together, and store it in Subtotal

				keepScore(a, b);
				// print face values, summed them, and print userScore and subTotal
				System.out.println("You rolled: " + a + " and " + b);
				System.out.println("Sum of dice: " + (a + b));
				System.out.println("Subtotal: " + subTotal + " Your total points are: " + total);
				count++;

			}
			// if a equals one OR b equals one, rolledOne() method triggers
			if (a == 1 || b == 1) {
				rolledOne();
				System.out.println("You rolled a one! Die one: " + a + " Die two: " + b + " You lose "
						+ "your points for this round.");
				// if roll turn count is equal to or greater than one, trigger youAreAPig()
				// method
				youAreAPig();
				coreCompPigGame(); // flips game to computer player
				break; // this prevents user from being able to roll again after rolling a one
			}

			// if both a and b are a 1, the loseAllPoints method triggers
			if (a == 1 && b == 1) {
				loseAllPoints();
				System.out.println("You rolled a snake eyes! Die one: " + a + " Die two: " + b
						+ " You lose your points for this round and your turn.");

				// if roll turn count is equal to or greater than one, trigger youAreAPig()
				// method
				youAreAPig();
				coreCompPigGame(); // flips game to computer player
				break; // this prevents user from being able to roll again after rolling snake eyes

			}

			rollAgain();

		} while (a != 1 && b != 1 && total <= 100);

		return total;

	}

	// ***********************************************************************

	// ************************************************************************

	// Roll again method to allow for player to choose if they want to play again or
	// quit.
	@Override
	public boolean rollAgain() {

		System.out.println();
		System.out.println("Roll again? y/n");

		while (true) {

			str = in.nextLine();

			// if str console input equals y, trigger corePigGame method
			if (str.equals("y")) {
				an = true;
				corePigGame();

				// if str console input equals n, trigger computer turn method method
				if (str.equals("n"))
					an = false;
				coreCompPigGame();
			} else
				System.out.println("Invalid entry. Try again.");

			return an;
		}
	}

	// computer's pig turn
	@Override
	public int coreCompPigGame() {
		// TODO Auto-generated method stub

		do {

			DiceRoll();
			compRollAgain();

			// if a and b are greater than one
			if (a > 1 && b > 1) {

				// Roll two dice, add them together, and store it in Subtotal

				compKeepScore(a, b);

				// print face values, summed them, and print userScore and subTotal
				System.out.println();
				System.out.println("The computer rolled: " + a + " and " + b);
				System.out.println("Sum of dice: " + (a + b));
				System.out.println("Computer's points are: " + compTotal + " Subtotal: " + compSubTotal);
				System.out.println();

			}

			// if a or b equals one, then trigger the compRolledOne method
			else if (a == 1 || b == 1) {
				compRolledOne();

				System.out.println("The computer rolled a one! Die one: " + a + " Die two: " + b 
						+ " Computer loses points for this round.");
				System.out.println();
				count = 0; // resets human counter to zero before going back to human turn
				corePigGame(); // flips game back over to human player

				// correctly

			}
			// if a and b equals one, trigger compLoseAllPoints method
			if (a == 1 && b == 1) {
				compLoseAllPoints();
				System.out.println(
						"The computer rolled snake eyes! Computer loses total points and " 
				+ "hands turn over.");
				System.out.println();
				count = 0; // resets human counter to zero to allow for the turn count to stay updated

				corePigGame(); // flips game back over to human player

			}

		}

		while (compTotal <= TOLERANCE && compTotal < 100);

		if (compTotal > TOLERANCE) {
			corePigGame();
		}

		return compTotal;
	}

	// computer roll again method. if computer total and subtotal are equal to or
	// less than 20,
	// roll again. allows for computer turn to be automated.
	public int compRollAgain() {
		if (compTotal <= TOLERANCE) {
			if (compSubTotal <= TOLERANCE)
				;
		}
		return compTotal;
	}

	// ***********************************************************************
	// Random number generators.
	//
	// Generate a random number and store in
	// y. Return y
	// ***********************************************************************

	public int numGenerator(int x) {
		number = generator.nextInt(x) + 1;
		return number;
	}
	// ***********************************************************************

	// ***********************************************************************
	// Generates a random number between MAX and MIN
	// DiceRoll()

	public int DiceRoll() {
		a = (int) (Math.random() * MAX) + MIN;
		b = (int) (Math.random() * MAX) + MIN;
		return a + b;
	}

	// ***********************************************************************

	// **********************************************************************
	// Rock, Paper, Scissors game methods - WIP
	// **********************************************************************

	// ***********************************************************************
	// Takes input param y and assigns a string value to integers 1-3
	// For rock, paper, scissors game
	// ***********************************************************************
	@Override
	public int RPScon(int y) {

		if (y == 1)
			compTurn = "R";
		else if (y == 2)
			compTurn = "P";
		else if (y == 3)
			compTurn = "S";

		return y;
	}

	// ***********************************************************************
	// Game Constructor toString method
	// ***********************************************************************

	public String toString() {
		return super.toString();
	}

	// **********************************************************************
	// HiLo - Increment and reset counters
	//
	// takes a and b parameters, sums them and sticks it in subtotal. It then adds
	// subtotal to
	// total when called. returns a and b
	// **********************************************************************

	@Override
	public int keepScore(int a, int b) {
		// TODO Auto-generated method stub
		// Roll two dice, add them together, and store it in Subtotal

		subTotal = a + b;
		// subTotal is sum of a and b
		// add subtotal to userscore
		total += subTotal;

		return a + b;
	}

	// computer keep score method. takes a and b dice rolls, sums them, stores in
	// compSubtotal,
	// then adds it to compTotal. returns a and b
	public int compKeepScore(int a, int b) {
		// TODO Auto-generated method stub
		// Roll two dice, add them together, and store it in Subtotal

		compSubTotal = a + b;
		// subTotal is sum of a and b
		// add subtotal to userscore
		compTotal += compSubTotal;

		return a + b;
	}

	// **********************************************************************
	// Increment and reset counters
	// **********************************************************************

	// resets subTotal to zero
	@Override
	public int rolledOne() {
		// TODO Auto-generated method stub
		subTotal = 0;
		return subTotal;
	}

	// computer rolled one, set subtotal to zero
	public int compRolledOne() {
		// TODO Auto-generated method stub
		compSubTotal = 0;
		return compSubTotal;
	}

	// resets subtotal and total to zero - Human method
	@Override
	public int loseAllPoints() {
		// TODO Auto-generated method stub
		subTotal = 0;
		total = 0;
		return subTotal + total;
	}

	// Computer lose all points method, set subtotal and total to zero
	public int compLoseAllPoints() {
		// TODO Auto-generated method stub
		compSubTotal = 0;
		compTotal = 0;
		return compSubTotal + compTotal;
	}

	// You're a pig! Lose all points if on the second round and up you roll a one or
	// two ones.
	public int youAreAPig() {
		if (count >= 2) {
			loseAllPoints();
			System.out.println("You're a pig! Lose all points and turn.");

		}
		return count;
	}

	// **********************************************************************
	// Core HiLo Game
	// **********************************************************************

	// Start of HiLo game.
	public int startHiLo() {
		System.out.println("We're going to play the high or low game. Try to guess the right " + "number!");
		numGenerator(100);
		count = 0;
		return number;
	}

	// method for taking input from console and storing it in userGuess
	public int enterGuess() {
		System.out.println("Enter your integer guess:");
		userGuess = Integer.parseInt(in.nextLine());
		count++;
		return userGuess;
	}

	// Core loop of HiLo. Allows for continuous games without exiting console
	public int tooHighLowRight() {

		do {
			enterGuess();
			if (userGuess > 0) {
				if (userGuess == number)
					System.out.println("Right!! Amount of tries: " + count);
				else if (userGuess < number)
					System.out.println("You're too low!");
				else
					System.out.println("You're too high!");
			}

		} while (userGuess != number && userGuess > 0);
		System.out.println();
		System.out.println("Play again? y/n");
		str = in.nextLine();

		if (str.equalsIgnoreCase("y")) {
			startHiLo();
			// enterGuess();
			tooHighLowRight();
		}

		return userGuess;
	}

	// **********************************************************************

}
