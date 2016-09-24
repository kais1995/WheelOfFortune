/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Kais Kais
* ID: kjk5419
*/

package wheeloffortune;
import java.util.Scanner;
import java.util.Random;    // this is added for import the Random values method.

public class WheelOfFortune {

public static void main(String[] args) {
      play(); // this function is for using the play method in the next line(it is what calls/starts the game)
  }
    public static void play(){
      String play;
      String letter;
      
      Scanner scanner = new Scanner(System.in);
      
     System.out.println // this is for the main menu of the game
          ("                   ======================\n    "
             + "               =  Wheel Of Fortune  =\n    "
             + "               ======================\n"
             + "1. Spin the wheel\n"
             + "2. Buy a vowel\n"
             + "3. Solve the puzzle\n"
             + "4. Quit\n"
             + "8. Toggle puzzle reveal\n"
             + "9. Test letter input\n"
             + "Enter choice: ");
     
     play = scanner.next();
 
     while ((!"0".equals(play))){   //     if what the user inputs does not equal 0 it will then go to the the next loop
         
         if ("1".equals(play)) { // if the user chooses 1 and spins the wheel it will call the method and spins the wheel and get a random value
         
         play = "You chose to spin the wheel.";
         Spin(); // the wheel would spin and would land on a number by calling/using the spin method and the puzzle mthod in the next line
         thePuzzle();
            
         letter = scanner.next();
            if (letter.matches("[A-z]")){ // this checks and allowes only letters to be inputted
                System.out.println("You chose the letter:" + letter); // for printing what the use chose
                play();
                }
                else{
                 System.out.println("Invalid letter, try again"); // if the user inputs a number this print line will trigger and appear
                   play();
                    }
         }     

         if ("2".equals(play)){  // when the user chooses 2, he will buy a vowel
         play = "You chose to buy a vowel.";

         System.out.println("What vowel will you buy?"
                 + "\nvowel 1"
                 + "\nvowel 2");
                 
                
         letter = scanner.next();
         System.out.println("You chose to buy: " + letter);
     }

         if ("3".equals(play)){  // when the user chooses 3, they can try to solve the puzzle
             System.out.println("Try solving the puzzle.");
         
     }
         
          if ("4".equals(play)){  // when the user chooses 4, the game quits
              System.out.println("You quit the game.");
              System.exit(0);
         
     }
         
          // if the user inputs 8, this will show the puzzle
            String secretPhrase = "the quick brown fox jumps over the lazy dog";
           if ("8".equals(play))
         {
             System.out.println(secretPhrase);
                         
            int num; 
        
           Scanner in = new Scanner(System.in);
        System.out.println("Enter any number to go back to menu.");
        num = in.nextInt();     
             play(); // after the user types any number, it will go back to the lopp from here            
     }       
         play();
     }  
}     
    
    public static void thePuzzle(){ // this method creates the puzzle.
                                    //  The below method creates the puzzle. And it waits for the users input. As the user enters a letter the puzzle is unvaild one by one.
      String secretPhrase = "the quick brown fox jumps over the lazy dog"; // this is for the secret phrase
      String guesses = " "; // for the user guesses
      Scanner guess = new Scanner (System.in);
      boolean notSolved = true; // created a boolean for if the phrase is fully solved, it will break and trigger a message.
      while (notSolved){
          notSolved = false; // for the break statement when the user wins
          for (char secretLetter: secretPhrase.toCharArray()) { // this iterates over the letters
              if (guesses.indexOf(secretLetter) == -1) { // if the letter does not occur then -1 returns(if the letter is in guesses its going to return index)
                  System.out.print("_ "); // this is added to get the program to print an _ instead of the letters, and put spaces between the words
                  notSolved = true; // for the break statement when the user wins
              }
              else{
                  System.out.print(secretLetter); 
              }
          }
          if (! notSolved ) {break;}  // if the user solved the puzzle, it breaks and proceeds to send a letter saying "Congratulations"
          
          //this gets the user's guess
      System.out.println("\nPick a Letter");
      String letter = guess.next();
      guesses += letter;
      
      }
      
        System.out.println("\nCongratulations! You Win!"); // the message the user gets after he wins.
        System.exit(0); // to exit the program after the user has won
  }
  
    
    
  public static void Spin(){ // this method is for the wheel values,
                             // it  goes through an array and takes a random number from the values and displays it
                            
      String [] Values = {" $300"," $300"," $300"," $300"," $300"," $350"," $400", // these are the values for the wheel
          " $400"," $450"," $500"," $500"," $500"," $550"," $600"," $600"," $600"," $700"," $800"
              , " $800"," $900"," $900"," $5000"," BANKRUPT", " LOSE A TURN"};
      Random randomValue = new Random(); // this and the next line are for picking the value randomly
      int index = randomValue.nextInt(Values.length);
      System.out.println("The wheel landed on:" + Values[index]); // this is for printing what the wheel landed on - calls the index from the previous line

    }
  }
