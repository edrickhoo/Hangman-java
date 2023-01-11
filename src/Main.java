import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static String correctWord = JsonParser.getWordFromList();;
    public static char[] wordChecker = new char[correctWord.length()];
    public static char[] guessSplit = new char[correctWord.length()];

    public static ArrayList<Character> checkedLetters = new ArrayList<Character>();
    public static int lives = 7;

    public static boolean checkGameOver(char[] wordChecker) {
        for(int i = 0 ; i < wordChecker.length ; i ++) {
            if(wordChecker[i] == '1') {
                return false;
            }

        }
        return true;
    }

    public static boolean checkIfAlreadyGuessed (char guess) {

        for(int i = 0; i < checkedLetters.size(); i ++) {
            char checkedLetter = checkedLetters.get(i);
            if(Character.toLowerCase(checkedLetter) == Character.toLowerCase(guess) ){
                return true;
            }
        }
        return false;
    }

    public static String userWordGuess() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please guess the correct word");
        boolean validInput = true;

        while(validInput) {
            String guess = myObj.nextLine();
            if(guess.length() > 0) {

                validInput = false;
                return guess.toLowerCase();
            } else {
                System.out.println("Please input atleast one character");
            }
        }
        return "";
    }

    public static boolean checkWord(String word) {
        if(word.equals(correctWord.toLowerCase()) ) {
            return true;
        }

        lives --;
        System.out.println("Lives: "+ lives);

        return false;
    }
    public static char userGuess() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a letter");
        boolean validInput = true;

        while(validInput) {
            String guess = myObj.nextLine();
            if(guess.length() == 1) {

                if(checkIfAlreadyGuessed(guess.charAt(0))) {
                    System.out.println(guess.charAt(0) + " " + "has already been guessed please enter another character");
                    continue;
                }
                validInput = false;
                return guess.charAt(0);
            }
            else
            {
                System.out.println("Please input one character");
            }
        }
        return '1';
    }

    public static boolean isInCorrectWord(char letter) {
        for(int i = 0; i < correctWord.length(); i ++) {
            if(correctWord.charAt(i) == Character.toLowerCase(letter) ){
                return true;
            }
        }
        return false;
    }

    public static void replaceInWordChecker(char letter) {
        for(int i = 0; i < correctWord.length(); i ++) {
            if(correctWord.charAt(i) == Character.toLowerCase(letter) ){
               wordChecker[i] = '0';
                guessSplit[i] = letter;
            }
        }
    }

    public static char getGuessType() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter 'w' to guess the word anything else to guess a letter");

        String type = myObj.nextLine();
        if(type.length() > 0) {
            return type.toLowerCase().charAt(0);
        } else {
            return 'l';
        }

    }
    public static void checkLetter(char letter) {
        checkedLetters.add(letter);
                if(isInCorrectWord(letter)) {
                    replaceInWordChecker(letter);
                } else {
                    lives --;
                    System.out.println("Lives: "+ lives);
                }
        System.out.println("Word: " + Arrays.toString(guessSplit));
        System.out.println("Words Used: " + checkedLetters);
    }


    public static void main(String[] args) {


        for(int i = 0; i < wordChecker.length; i ++) {
            wordChecker[i] = '1';
            guessSplit[i] = '_';
        }

        System.out.println(Arrays.toString(guessSplit));

     boolean isGameOver = false;




     while(!isGameOver) {


         DrawHangman.draw(lives);
         if(checkGameOver(wordChecker)) {
             System.out.println("You WIN!!! the hidden word was: " + correctWord);
             System.out.println("Lives Remaining: " + lives);
             isGameOver = true;
             break;
         }

         if(lives == 0) {
             System.out.println("You ran out of lives, you LOSE");
             System.out.println("The correct word was: " +correctWord);
             isGameOver = true;
             break;
         }

         char guessType = getGuessType();

         if(guessType == 'w') {
            String word = userWordGuess();
             System.out.println("You guessed " + word);


             if(checkWord(word)) {
                 System.out.println("You WIN!!! the hidden word was: " + correctWord);
                 System.out.println("Lives Remaining: " + lives);
                 isGameOver = true;
                 break;
             }

         } else {

             char character = userGuess();

             System.out.println("--------------------");
             System.out.println("--------------------");
             System.out.println("You guessed " + character);

             checkLetter(character);

         }
     }
    }
}