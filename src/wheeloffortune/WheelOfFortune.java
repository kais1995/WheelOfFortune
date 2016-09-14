/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Kais Kais
* ID: kjk5419
*/
package wheeloffortune;

import java.util.Scanner;

public class WheelOfFortune {

public static void play(){
      String play;
      String letter;
      Scanner scanner = new Scanner (System.in);
      
      System.out.println("Play \nPress:1 To Spin the Wheel \nPress:2 To buy a vowel \nPress:3 To solve the puzzle \nPress:4 To QA Test \nPress:5 To Quit" );
      play = scanner.next();
      
          
      
      
      
      System.out.println(play);
      
      while ((play != "0")){
          if ("1".equals(play)){
              play = "You spun the wheel";              
              System.out.println(play);
              System.out.println("Choose a letter");
              letter = scanner.next();              
              if (letter.matches("[A-z]")){
                  
                  System.out.println("Your input was: " + letter);
                  play();
                  
              }
              else {
                  System.out.println("Invalid input, try again");
                  play();
                  
              }
              
          }
          if ("2".equals(play)){
              play = "You baught a vowel";
              System.out.println(play);
              play();
          }
          if ("3".equals(play)){
              play = "Try solving the puzzle";
              System.out.println(play);
              play();
          }
          if ("4".equals(play)){
              play = "QA Test Mode";
              System.out.println(play);
              play();
          }
          if ("5".equals(play)){
              play = "You Quit the Game";
              System.out.println(play);
              System.exit(0);
          
          
          }
              
              
              
              
          }
              
          }    
          
                
          
      
      
      
      
      
      
   
   
   
    
  public static void main(String[] args) {
    play();
  }
  
}

