///*
//* CMPSC 261, Section 1
//* Fall 2016
//* Instructor: Phil O'Connell
//* Student: Kais Kais
//* ID: kjk5419
//*/
//package wheeloffortune;
//import java.util.Scanner;
//import java.util.Random;
//
//public class WheelOfFortune {
//
//public static void main(String[] args) {
//      play();
//  }
//
//
//    public static void play(){
//      String play;
//      String letter;
//      
//      Scanner scanner = new Scanner(System.in);
//      
//     System.out.println // this is for the main menu of the game
//          ("                   ======================\n    "
//             + "               =  Wheel Of Fortune  =\n    "
//             + "               ======================\n"
//             + "1. Spin the wheel\n"
//             + "2. Buy a vowel\n"
//             + "3. Solve the puzzle\n"
//             + "4. Quit\n"
//             + "8. Toggle puzzle reveal\n"
//             + "9. Test letter input\n"
//             + "Enter choice: ");
//     
//     play = scanner.next();
// 
//     while ((!"0".equals(play))){   //     if what the user inputs does not equal 0 it will then go to the the next loop
//         
//         if ("1".equals(play)) { // if the user chooses 1 and spins the wheel it will call the method and spins the wheel and get a random value
//         
//         play = "You chose to spin the wheel.";
//         Spin(); // the wheel would spin and would land on a number by calling/using the spin method and the puzzle mthod in the next line
//         thePuzzle();
//            
//         letter = scanner.next();
//            if (letter.matches("[A-z]")){ // this checks and allowes only letters to be inputted
//                System.out.println("You chose the letter:" + letter); // for printing what the use chose
//                play();
//                }
//                else{
//                 System.out.println("Invalid letter, try again"); // if the user inputs a number this print line will trigger and appear
//                   play();
//                    }
//         }     
//
//         if ("2".equals(play)){  // when the user chooses 2, he will buy a vowel
//         play = "You chose to buy a vowel.";
//
//         System.out.println("What vowel will you buy?"
//                 + "\nvowel 1"
//                 + "\nvowel 2");
//                 
//                
//         letter = scanner.next();
//         System.out.println("You chose to buy: " + letter);
//     }
//
//          // if the user inputs 8, this will show the puzzle
//            String secretPhrase = "the quick brown fox jumps over the lazy dog";
//           if ("8".equals(play)) // when the user chooses 4, the game quits
//         {
//             System.out.println(secretPhrase);// this will print the secret phrase
//                         
//            int num;         
//           Scanner in = new Scanner(System.in);
//        System.out.println("Press any number to go back to menu.");
//        num = in.nextInt();
//                  play();
//           
//     }       
//         play();
//     }
//  
//}
//     
//  
//  
//  
//    public static void thePuzzle(){ // this method creates the puzzle.
//                                    //  The below method creates the puzzle. And it waits for the users input. As the user enters a letter the puzzle is unvaild one by one.
//      String secretPhrase = "the quick brown fox jumps over the lazy dog"; // this is for the secret phrase
//      String guesses = " "; // for the user guesses
//      Scanner guess = new Scanner (System.in);
//      boolean notSolved = true;
//      while (notSolved){
//          notSolved = false; // for the break statement when the user wins
//          for (char secretLetter: secretPhrase.toCharArray()) { // this iterates over the letters
//              if (guesses.indexOf(secretLetter) == -1) { // if the letter does not occur then -1 returns(if the letter is in guesses its going to return index)
//                  System.out.print("_ "); // this is added to get the program to print an _ instead of the letters, and put spaces between the words
//                  notSolved = true; // for the break statement when the user wins
//              }
//              else{
//                  System.out.print(secretLetter);
//              }
//          }
//          if (! notSolved ) {break;}  // if the user solved the puzzle, it breaks and proceeds to send a letter saying "Congratulations"
//          
//                  public void revealPuzzle() {
//        for (char c : secretPhrase.toCharArray()) {
//            letter.add(c);
//        }
//    }
//
//          //this gets the user's guess
//      System.out.println("\nPick a Letter");
//      String letter = guess.next();
//      guesses += letter;
//      
//      
//      }
//      
//        System.out.println("\nCongratulations! You Win!"); // the message the user gets after he wins.
//        System.exit(0); // to exit the program after the user has won
//  }
//    
//
//  
//    
//    
//  public static void Spin(){ // this method is for the wheel values,
//                             // it  goes through an array and takes a random number from the values and displays it
//                            
//      String [] Values = {" $300"," $300"," $300"," $300"," $300"," $350"," $400", // these are the values
//          " $400"," $450"," $500"," $500"," $500"," $550"," $600"," $600"," $600"," $700"," $800"
//              , " $800"," $900"," $900"," $5000"," BANKRUPT", " LOSE A TURN"};
//      Random randomValue = new Random(); // this and the next line are for picking the value randomly
//      int index = randomValue.nextInt(Values.length);
//      System.out.println("The wheel landed on:" + Values[index]); // this is for printing what the wheel landed on - calls the index from the previous line
//
//    }
//  
//  }


package wheeloffortune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class WheelOfFortune {

  // To read from the keyboard
  private static final Scanner _keyboard = new Scanner(System.in);

  // Used to get random values for puzzle and wheel
  private static final Random _random = new Random();

  // True if we want to show all letters
  private static boolean revealLetters = false;

  /*
  * These are the wedges that are part of the wheel.
  * There are 24.  Some values can appear more than once
  */
  private static final List<String> _wedges = Arrays.asList(
      /* 01 */"$5000",
      /* 02 */ "$600",
      /* 03 */ "$500",
      /* 04 */ "$300",
      /* 05 */ "$500",
      /* 06 */ "$800",
      /* 07 */ "$550",
      /* 08 */ "$400",
      /* 09 */ "$300",
      /* 10 */ "$900",
      /* 11 */ "$500",
      /* 12 */ "$300",
      /* 13 */ "$900",
      /* 14 */ "BANKRUPT",
      /* 15 */ "$600",
      /* 16 */ "$400",
      /* 17 */ "$300",
      /* 18 */ "LOSE A TURN",
      /* 19 */ "$800",
      /* 20 */ "$350",
      /* 21 */ "$450",
      /* 22 */ "$700",
      /* 23 */ "$300",
      /* 24 */ "$600"
  );

  /*
  * The number of wedges will not change throughout the game
  * We can cache the value so we're not calling .size() over and over
  */
  private static final int _wedgeCount = _wedges.size();

  private static String chooseRandomWedgeValue() {
    // Choose a random index
    int randomWedgeIndex = _random.nextInt(_wedgeCount);

    // Return the corresponding wedge
    return _wedges.get(randomWedgeIndex);
  }

  // The menu choices
  private static final List<String> _menuChoices = Arrays.asList(
      "1. Spin the wheel",
      "2. Buy a vowel",
      "3. Solve the puzzle",
      "4. Quit the game",
      "", // 5 possibly used in the future
      "", // 6 possibly used in the future
      "", // 7 possibly used in the future
      "8. Toggle puzzle reveal",
      "9. Test letter input"
  );
  private static final int _quitChoiceNumber = 4;

  // The different puzzles to choose from
  private static final List<String> _puzzles = Arrays.asList(
      "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",
      "PENN STATE ABINGTON",
      "INFORMATION SCIENCES AND TECHNOLOGY"
  );

  /*
  * The number of puzzles will not change throughout the game
  * We can cache the value so we're not calling .size() over and over
  */
  private static final int _puzzlesCount = _puzzles.size();

  /*
  * We will store the guessed letters in a hash map.
  * The "key" will be the character that was guessed
  * The "value" will be true/false
  *
  * Actually, the "value" aspect of this is not relevant.
  * Just the fact that a letter appears in the map as a key, is enough to imply
  * it was guessed.
  */
  private static Map<Character, Boolean> guessedLetters = new HashMap<>();

  /*
  * Given a puzzle, return a masked version, with hidden letters
  */
  private static String maskPuzzle(String puzzle, boolean revealLetters) {
    // Use a string builder, since Java strings are immutable
    StringBuilder maskedPuzzle = new StringBuilder();

    // For each letter in the puzzle
    for (int i = 0; i < puzzle.length(); i++) {
      // Current letter
      char c = puzzle.charAt(i);

      /*
      * Either we're revealing all letters, or we've already guessed the
      * letter
      */
      boolean isLetterGuessed = revealLetters || guessedLetters.containsKey(c);

      /*
      * If the letter is not blank (we don't mask blanks), and the letter
      * has not been guessed, then we will mask it.
      */
      if (c != ' ' && !isLetterGuessed){
        c = '_';
      }
      
      // Put one space after each character (even a space) in the puzzle
      maskedPuzzle.append(c + " ");
    }

    // Convert the string builder to a string and return it
    return maskedPuzzle.toString();
  }

  // Choose a random puzzle
  private static String chooseRandomPuzzle() {
    // Choose a random puzzle index
    int randomPuzzleIndex = _random.nextInt(_puzzlesCount);

    //Return the corresponding puzzle
    return _puzzles.get(randomPuzzleIndex);
  }

  // Determine if the given number choice actually appears on the menu
  private static boolean isValidMenuChoice(int choice) {
    if ((choice < 1) || (choice > _menuChoices.size())) {
      return false;
    }

    // Subtrace 1 because arrays/lists are zero-based
    int index = choice - 1;
    String menuText = _menuChoices.get(index);

    return !menuText.equals("");
  }

  // Input a letter from the keyboard
  private static char inputLetter() {
    char letter = ' ';
    boolean finished = false;

    while (!finished) {
      System.out.print("Enter a letter: ");

      String line = _keyboard.nextLine();
      if (line.length() != 1) {
        System.out.println("Enter just one letter");
      } else {
        // Convert letter to upper case
        letter = Character.toUpperCase(line.charAt(0));
        if (!Character.isLetter(letter)) {
          System.out.println("That is not a letter");
        } else {
          // Will exit the loop
          finished = true;
        }
      }
    }

    return letter;
  }

  // Display the game menu, and handle the choices made
  private static void gameMenu() {
    // Choice from the menu
    int choice = 0;

    // Line entered from keyboard
    String line = "";

    // True when user wants to quit
    boolean quit = false;

    // Choose one of the puzzles at random
    String puzzle = chooseRandomPuzzle();

    // Repeat the menu until the user chooses to quit
    while (!quit) {
      System.out.println("                      ======================");
      System.out.println("                      =  Wheel Of Fortune  =");
      System.out.println("                      ======================");
      System.out.println("                                            ");

      System.out.println(maskPuzzle(puzzle, revealLetters));
      System.out.println();

      // Loop over the menu choices, and display each one
      for (String menuChoice : _menuChoices) {
        // Skip blank place-holder choices
        if (!menuChoice.equals("")) {
          System.out.println(menuChoice);
        }
      }
      System.out.print("Enter choice: ");
      line = _keyboard.nextLine();
      try {
        // If the input was not an integer, then that error will be caught
        choice = Integer.parseInt(line);
      } catch (NumberFormatException nfe) {
        // Error message, then go to the top of the loop
        System.out.println("Invalid input");
        continue;
      }

      // If not valid, then go back to the top of the loop
      if (!isValidMenuChoice(choice)) {
        System.out.println("Not a menu choice");
        continue;
      }

      System.out.println("You chose: " + _menuChoices.get(choice - 1));
      switch (choice) {
        case _quitChoiceNumber:
          // This will allow us to leave the menu loop
          quit = true;
          break;

        case 1: // Spin the wheel
          System.out.println("You landed on: " + chooseRandomWedgeValue());
          char letter = inputLetter();
          System.out.println("Your letter is: " + letter);
          guessedLetters.put(letter, true);
          break;

        case 8: // Toggle reveal letters
          revealLetters = !revealLetters;
          break;

        case 9: // Test to read in a letter from the keyboard
          System.out.println("Your letter is: " + inputLetter());
          break;
      }
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    gameMenu();
  }

}
