package ca.bc.nic.cps100;

/*
 * Author: Amanda Thompson
 * CPS 100 - DLS1
 * Assignment 9
 * Due: Nov 28, 2020
 * Nov 28, 2020
 */

// **************************************************************************
// This class is an abstract class for the MainGameHub that uses inheritance
// **************************************************************************

import java.util.Random;
import java.util.Scanner;

public abstract class GameRootAbstr {

	Random generator = new Random(); // for random number generator

	protected int computerTurn;
	protected final int MAX = 6;
	protected final int MIN = 1;
	protected int faceValue1;
	protected int randomNum;
	protected String compTurn;
	protected int score;
	protected static int a; // die variable
	protected static int b; // die variable
	protected static int subTotal, total;
	protected static int compSubTotal, compTotal;
	protected static int number;
	protected static int userWin, userLose, tie; // counters for rock, paper, scissors
	protected final static int TOLERANCE = 20; // Set to 20 as per PIG rules

	// Constructor
	protected GameRootAbstr() {

	}

	// ***************************************************************
	// Abstract methods
	// ***************************************************************

	// roll again method
	public abstract boolean rollAgain();

	// ******************************************************************
	// keep score method

	public abstract int keepScore(int a, int b);

	// ***************************************************************

	// generate a random int value
	public abstract int DiceRoll();

	// *****************************************************************
	// central user turn logic

	public abstract int corePigGame();

	// ******************************************************************
	// central computer turn logic

	public abstract int coreCompPigGame();

	// ******************************************************************

	// method to convert int values from number generator to char values
	public abstract int RPScon(int y);

	// ******************************************************************
	// rolled a one pig method
	public abstract int rolledOne();

	// ******************************************************************
	// rolled two ones pig game method
	public abstract int loseAllPoints();

	// ******************************************************************
	// toString method calling score
	public String toString() {
		return ("Score: " + score);
	}

	// ******************************************************************
	// Random Number generator
	public abstract int numGenerator(int x);

	// ******************************************************************
	// HiLo game methods
	public abstract int startHiLo();

	public abstract int enterGuess();

	public abstract int tooHighLowRight();
	// ******************************************************************

	// possible pig methods
	/*
	 * rolls die and returns random result
	 * 
	 * public int roll1() { faceValue1 = (int)(Math.random() * MAX) + MIN; return
	 * faceValue1; }
	 */
	// if player rolls a one, lose round points and turn
	// if a player rolls two ones with both die objects, lose game and all points
	// score keeping
	// player loses turn. write a method that passes turn to other player. ends
	// turn?
	// computer player dumps turn when round points hit 20
	// first player to 100 wins game
	// if player loses on second round turn, game calls player a pig and they lose
	// the game

	// Rock, paper, scissors methods
	// keep track of win/lose/tie
	/*
	 * generate and Convert value to computer player turn
	 * 
	 * if (computerRandom == 1) computerTurn = "R"; else if (computerRandom == 2)
	 * computerTurn = "P"; else if (computerRandom == 3) computerTurn = "S";
	 */

	// hilo game methods
	// random number generator number = (int) (Math.random() * MAX) + 1;
	// userGuess = Integer.parseInt(scan.nextLine());
	//

	// **********************************************************************
	// HiLo game methods
	// **********************************************************************

	// Binary sorting - autoguess in gameplay?

	// **********************************************************************

	// **********************************************************************
	// Rock, Paper, Scissors game methods
	// **********************************************************************

	// Generate and convert integer value to R, P, and S for computer turn

	// method for invalid input

	// if player chooses R method

	// if player chooses P method
	// if player chooses S method
	//

	// **********************************************************************

}
