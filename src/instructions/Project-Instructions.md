#Project 3
##Poker Application and Test Suite

Think back to the Poker Hands problem from the Project1 assigned 2 weeks ago. Wouldn't it be great if there were an application that we could build to play poker in real time, instead of inputting possible hands as a list and comparing after-the-fact? Plus, what's poker without the option to bet on your hands? Well, now's your chance to expand that question into a full-fledged application. Your mission for this project is to create a text-based Poker application that generates hands for all players, allows you to place a round of bets, and keeps track of your winnings over the course of the game.

We've also learned a lot about user stories and application testing in JUnit. To make sure that the application that you've built is robust enough for production deployment, you'll also build a test suite for your poker application.

As usual, these problems will not be formally graded, but you might be asked to share your solutions with the class. Any time on Saturday not spend working through this problem in workshop format will be spent presenting solutions to the class.

**Save your `.java` files in the `.answers` directory under a new directory called `FirstnameLastname` (using your first and last name, obviously).**


-------------

#### When a player begins the program, they should be able to interact with a text-based menu of options.

The options should include:

- Start Poker game
- Exit program

The customer should be able to select any of these options.

-------------

#### A player should be able to choose game parameters before a game starts.

The application should default to a five-card draw format with "antes" instead of blinds (if you aren't sure what that means, don't worry about it just yet). This means that players are dealt 5 cards all at once, followed by a round of betting, followed by revealing the hands dealt to players and awarding the total amount bet by players to the winning hand. When a player decides to start a new game, the following options need to be specified:

- Player Name (for human player)
- Number of Players (int value > 2, but < 5)
- Ante size in $ (Takes any int value > 0)
- Wallet size in $ (Takes any int value > ante*3 ... this way, we know that we'll have enough money for at least three rounds of antes!)

"Player Name" will be the name displayed for the human player.
"Number of Players" will define the number of computer-generated players for each game, including the human player inputting values through the console.
"Ante size" will define the value of the ante that must be paid before each round. The ante is a forced bet made by every player before cards are dealt. This encourages participation in hands and ensures that every game eventually has an end-point, even if players fold (or quit) every hand without participating in the round of betting.
"Wallet size" will define the total amount of cash that players have at any moment. This value will change every hand, as antes are deducted before hands are dealt, and winnings or losses are added to or subtracted from the wallet after every betting round.

-------------

#### After players input all parameters, the game should begin.

Each game should follow the same process. Games will progress as follows:

1. **Player names should be displayed with current wallet values next to each player.** Player name is input for the human player, and either pre-defined or application-generated for the computer players.
2. **A "dealer" is assigned.** Each round of betting will start with a different player each hand, and will cycle through players as if they were all sitting at the same table. There should be some kind of visual indication which player is the "dealer" at the beginning of each round.
3. **All players will pay the "ante" value into the "pot" before any cards are dealt.** New player wallet values should be displayed, as should pot size.
4. **Hands will be dealt.** The human player will have their hand displayed on the screen, while the computer players' hands will remain hidden.
5. **Before hands are revealed, a round of betting will occur**. Betting starts with the "dealer". Initial bets for computer-generated players in the "dealer" position should be generated randomly, from values <= wallet size and >= 0. Every player thereafter has the option to "see" that initial bet to stay in the hand, "raise" to stay in the hand and increase the cost of staying in the hand for other players, or "fold" to exit the hand without any further betting (at the cost of all previous bets and antes already in the pot). Computer-generated players after the dealer should have a 30% chance of folding, 30% chance of "calling" or "seeing" (or matching) the initial bet to stay in the hand, and a 30% chance of "raising" the required bet by a random amount.
6. **Betting continues as described until all players have "called" the highest bet or folded.** If all players fold except for one, the remaining player takes the pot without revealing any hands.
7. **Cards are revealed.** If no player has "bought" the pot, display the values of the hands for all players.
8. **Winner takes the pot.** The player with the highest "value" of hand has the value of the pot added to their wallet. In case of a tie, the pot is split between two players.
9. **Repeat steps 1-8.** Continue to repeat steps 1-7 until a player's wallet reaches 0. If the zeroed-out player is a computer, eliminate that player from the game for all subsequent rounds. If that player is the human-controlled player, end the game and inform the player that they lose and are the worst. If all computer-controlled players deplete their wallets before the human-controlled player loses theirs, end the game and inform the player that they have won the game and are the best.

-------------

#### End the game and repeat.

After a game has completed, make sure that you return the user to the first menu, prompting the user to restart the game with new parameters or exit.


-------------

#### Testing with JUnit.

Now that you've build your application, it's up time to test the project using scripts and JUnit. Your test suite must include the following:

1. **A Setup Method for adding a player name.**
2. **A JUnit test script for each methods and class.**
3. **A generalized test suite for running all test cases together.**

**Save your `.java` files for your test suite in the `.answers` directory in your `FirstnameLastname` folder. Please label the file as `testsuite`.**








