/*
*
 @author kjk5419, Kais Kais  
*
*/

package wheeloffortune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class WheelOfFortune {

  private static char letter;
  private static char vowel;
  // To read from the keyboard
  private static final Scanner _keyboard = new Scanner(System.in);

  // Used to get random values for puzzle and wheel
  private static final Random _random = new Random();

  
  private static int money = 0;
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

        // for landing on lose a turn and bankrupt
        // it stores the winnings and adds them in the next line
    if(_wedges.get(randomWedgeIndex) != "LOSE A TURN" && _wedges.get(randomWedgeIndex) != "BANKRUPT"){
        
        // for adding the winnings
        money += Integer.parseInt(_wedges.get(randomWedgeIndex).replace("$", ""));
        
    }
    
    else if (_wedges.get(randomWedgeIndex) == "BANKRUPT"){
      money = 0; // if landed on bankrupt then their winnings are 0.
        }
    // Return the corresponding wedge
    return _wedges.get(randomWedgeIndex);
  }

  // The menu choices
  private static final List<String> _menuChoices = Arrays.asList(
      "1. Spin the wheel",
      "2. Buy a vowel",
      "3. Solve the puzzle",
      "4. Quit the game"
 
  );
  private static final int _quitChoiceNumber = 4;

  // The different puzzles to choose from
  private static final List<String> _puzzles = Arrays.asList(
      "CAN YOU SOLVE THIS",
      "HARAMBE WAS MY SAVIOR",
      "DO YOU EVEN LIFT BRO"
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
      System.out.println("\n                      ======================");
      System.out.println("                      =  Wheel Of Fortune  =");
      System.out.println("                      ======================");
      System.out.println("                                            ");

      System.out.println(maskPuzzle(puzzle, revealLetters));
      System.out.println();
      System.out.println("Your Winnings are: $" + money);
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

            // ******************************* ADDED TO.
        case 1: // case 1 is for spin the wheel/check if the input is a vowel.
          System.out.println("You landed on: " + chooseRandomWedgeValue());
          letter = inputLetter(); // to catch the user's input
          
          //this is if the user inputs one of these letters, it will tell them it is a vowel and can't be used.
          //if it is a vowel do this
        if(letter=='a' || letter=='A' || letter=='e' || letter=='E' ||
        letter=='i' || letter=='I' || letter=='o' || letter=='O' ||
        letter=='u' || letter=='U')
        {
            System.out.print("\nThis is a Vowel, you can only buy them");
        }
        
        // else this will tell them it is not and use the letter
        else
        {
            System.out.print("\nThis is not a Vowel");
            guessedLetters.put(letter, true); // reveals the letter if the letter is in the puzzle.
        }
          
          System.out.println("\nYour entered the letter: " + letter); //this prinits the letter of the vowel
          break;

            // ******************************* ADDED TO.
        case 2: // case is for the vowels/calculating the money   
            vowel = inputLetter(); // to catch a whole new input/value for case 2 because if you do not have this it will not go to the  second letter, it will only do the first.
            if(vowel=='a' || vowel=='A' || vowel=='e' || vowel=='E' ||
            vowel=='i' || vowel=='I' || vowel=='o' || vowel=='O' ||
            vowel=='u' || vowel=='U')
        {
            if(money >= 250) { // if money is lower than how much the vowel costs it will not let the user buy it.
            money = money - 250; // this subtracts the vowel's value from the winnings
            System.out.print("\nYou bought: " + vowel + "\n");
            guessedLetters.put(vowel, true); // reveals the letter if the letter is in the puzzle.
            }
            else {
            System.out.print("\nYou do not have enough money to buy this vowel.");
            }
        }
        else
        {
            System.out.print("\nThis can only buy Vowels.");
        }
          break;
            
//          error with case 3.  
//        case 3: 
//      boolean notSolved = true;
//      while (notSolved){
//          notSolved = false; // for the break statement when the user wins
//          for (char secretLetter: puzzle.toCharArray()) { // this iterates over the letters
//              if (guessedLetters.indexOf(secretLetter) == -1) { // if the letter does not occur then -1 returns(if the letter is in guesses its going to return index)
//                  notSolved = true; // for the break statement when the user wins
//              }
//              else{
//                  System.out.print(secretLetter);
//              }
//          }
//          if (! notSolved ) {break;}  // if the user solved the puzzle, it breaks and proceeds to send a letter saying "Congratulations"
         
                   
            
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
