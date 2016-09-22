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
      String action;
      String letter;
      Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
      play();
  }
  
  public static void play(){
      String play;
      String letter;
      
      Scanner scanner = new Scanner(System.in);
      
     System.out.println
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
 
     while ((!"0".equals(play))){   //     if the user's input does not equal 0 it will then go to the the next loop
         
         
//         if the user inputs 1, it go through the following if statement.
//         Since the first action is to spin the wheel this if statement calls the WheelSpin() method below to get a random value.
         if ("1".equals(play)) {
         
         play = "You choose to spin the wheel.";
//         System.out.println(action);
         Spin();
         thePuzzle();
//         System.out.println("Choose a letter:");
         letter = scanner.next();
//         Below checks the users input, only allows for letter input.
            if (letter.matches("[A-z]")){
                System.out.println("You choose the letter:"+ letter);
                play();
                }
                else{
                 System.out.println("Invalid letter, try again");
                   play();
                    }
         }     
//         If user enters 2, they are asked which vowel they want to buy. Currently this does nothing and will be dealt with later.
         if ("2".equals(play)){ 
         play = "You choose to buy a vowel.";
//         System.out.println(action);
         System.out.println("What vowel are you going to buy?:");
         letter = scanner.next();
         System.out.println("You choose to buy:" + letter);
     }
//      If the user inputs 3, they will be allowed to solve the puzzle. Currently this does nothing and will be dealt with later.   
         if ("3".equals(play)){ 
         play = "You choose to solve the puzzle.";
//         System.out.println(action);
     }
//         If the user enter 4, they quit the application.
           if ("4".equals(play)) 
         {play = "You quit game.";
//         System.out.println(action);
         System.exit(0);
     }
//           This mode is meant for QA testers to make sure the game works properly
           if ("9".equals(play)) 
         {play = "Yo are in QA Test Mode.";
//         System.out.println(action);
        
     }
        
         play();
     }
  
  }
//  Here I created a wheelSpin method. Which, I listed the wheel values in an array. 
//  Then I created a random variable which goes through the array and picks a value at random.
//  This value is then showed to the user. No need to add values yet. Not keeping track of 'money won'.
  
    public static void thePuzzle(){
      String secret = "harambe was a good person";
      String input = " ";
      Scanner guess = new Scanner (System.in);
      boolean notSolved = true;
      while (notSolved){
          notSolved = false;
          for (char secretPhrase: secret.toCharArray()) {
              if (input.indexOf(secretPhrase) == -1) {
                  System.out.print("_ ");
                  notSolved = true;
              }
              else{
                  System.out.print(secretPhrase);
              }
          }
          if (! notSolved ) {break;}    
          
          //this gets the user's guess
      System.out.println("\nPick a Letter");
      String letter = guess.next();
      input += letter;
      
      }
        System.out.println("\nCongratulations! You Win! You are rich now!");
  }
  
  public static void Spin(){
      String [] Values = {"$300","$300","$300","$300","$300","$350","$400",
          "$400","$450","$500","$500","$500","$550","$600","$600","$600","$700","$800"
              , "$800","$900","$900","$5000","BANKRUPT", "LOSE A TURN"};
      Random randomValue = new Random();
      int index = randomValue.nextInt(Values.length);
      System.out.println("You landed on:" + Values[index]);

    }
//  The below method creates the puzzle. And it waits for the users input. As the user enters a letter the puzzle is unvaild one by one.

  }