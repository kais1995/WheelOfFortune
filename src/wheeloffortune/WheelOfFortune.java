/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Kais Kais
* ID: kjk5419
*/
package wheeloffortune;

import java.util.Scanner;
import java.util.Random;


public class WheelOfFortune {
      String play;
      String letter;
      Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
      play();
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
             + "9. Test letter input\n"
             + "Enter choice:    ");
     
     play = scanner.next();
 
     while ((!"0".equals(play))){   //     if what the user inputs does not equal 0 it will then go to the the next loop
         
       
         if ("1".equals(play)) { // if the user chooses 1 and spins the wheel it will call the method and spins the wheel and get a random value
         
         play = "You chose to spin the wheel.";

         Spin();
         thePuzzle();

         letter = scanner.next();

            if (letter.matches("[A-z]")){ // this checks and allowes only letters to be inputted
                System.out.println("You choose the letter:" + letter); // for printing what the use chose
                play();
                }
                else{
                 System.out.println("Invalid letter, try again"); // if the user inputs a number this print line will trigger and appear
                   play();
                    }
         }     

         if ("2".equals(play)){  // when the user chooses 2, he will buy a vowel
         play = "You choose to buy a vowel.";

         System.out.println("What vowel are you going to buy?:");
         letter = scanner.next();
         System.out.println("You choose to buy:" + letter);
     }

         if ("3".equals(play)){  // when the user chooses 3, they can try to solve the puzzle
         play = "Try solving the puzzle.";
     }
       
           if ("4".equals(play)) // when the user chooses 4, the game quits
         {play = "You quit game.";

         System.exit(0);
     }
                   if ("9".equals(play)) // when the user chooses 9, they can test if the game works properly
         {play = "Yo are in QA Test Mode.";
        
     }
        
         play();
     }
  
  }

  
  
  
    public static void thePuzzle(){ // this method creates the puzzle.
        //  The below method creates the puzzle. And it waits for the users input. As the user enters a letter the puzzle is unvaild one by one.
      String secretPhrase = "harambe was a good person"; // this is for the secret phrase
      String guesses = " "; // for the user guesses
      Scanner guess = new Scanner (System.in);
      boolean notSolved = true;
      while (notSolved){
          notSolved = false;
          for (char secretLetter: secretPhrase.toCharArray()) { // this iterates over the letters
              if (guesses.indexOf(secretLetter) == -1) { // if the letter does not occur then -1 returns(If the letter is in guesses its going to return index)
                  System.out.print("_ "); // this is added to put spaces between the words
                  notSolved = true;
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
        System.exit(0);
  }
  
    
    
  public static void Spin(){ // this method is for the wheel values,
                             // it  goes through an array and takes a random number from the values and displays it
                            
      String [] Values = {"$300","$300","$300","$300","$300","$350","$400",
          "$400","$450","$500","$500","$500","$550","$600","$600","$600","$700","$800"
              , "$800","$900","$900","$5000","BANKRUPT", "LOSE A TURN"};
      Random randomValue = new Random(); // this and the next line are for picking randomly
      int index = randomValue.nextInt(Values.length);
      System.out.println("The wheel landed on:" + Values[index]); // this is for printing what the wheel landed on

    }


  }
