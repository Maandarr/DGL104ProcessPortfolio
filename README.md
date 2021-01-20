# DGL 104 Process Portfolio

## By Amanda Thompson

### Week 1

**Activity 0101**:

One of my assignments last semester was to find similarites between three games in previous assignments, decompose it into smaller methods while using polymorphism by inheritance or abstraction, and write it to one playable game. I was hung up on this one method for far too long trying to get the yes and no entries to work. I've gotten these to work no problem before and have another method just like it in one of the other games that works perfectly. But this one. Refused. I've written it many different ways by changing the syntax in the if and while conditions, flipping around the nested ifs. I think the first thing I would try again is to put the invalid entry else condition above the if statements.

```
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
```

**ACTIVITY 0102**:

MainGameHub.java is the class that houses the method in Activity 0101. The biggest area of improvmemt would be architectural. I would like to redesign it completely with the MVC pattern. I used an abstract class for the game root with most of the variables and constants and the one inherited class to house the rest of the methods. I think it would have been better to use a non abstract class as the root and broken up the similar methods into different child classes to keep things organized and leaned into the polymorphism a little more.
Another area for improvement is writing more informative comments. 
Another area is to work on control flow like in Activity 0101.