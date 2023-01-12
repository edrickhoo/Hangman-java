import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class

public class Hangman {
    public String correctWord = JsonParser.getWordFromList();;
    char[] wordChecker = new char[correctWord.length()];
    char[] guessSplit = new char[correctWord.length()];
    public ArrayList<Character> checkedLetters = new ArrayList<>();

    public int lives = 7;

    boolean isGameOver = false;

    public static boolean checkGameOver(char[] wordChecker) {
        for(int i = 0 ; i < wordChecker.length ; i ++) {
            if(wordChecker[i] == '1') {
                return false;
            }

        }
        return true;
    }

    public boolean checkIfAlreadyGuessed(char guess) {

        for(int i = 0; i < checkedLetters.size(); i ++) {
            char checkedLetter = checkedLetters.get(i);
            if(Character.toLowerCase(checkedLetter) == Character.toLowerCase(guess) ){
                return true;
            }
        }
        return false;
    }

    public String userWordGuess(Scanner myObj) {

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

    public boolean checkWord(String word) {
        if(word.equals(correctWord.toLowerCase()) ) {
            return true;
        }
        lives --;
        System.out.println("Lives: "+ lives);
        return false;
    }


    public char userGuess(Scanner myObj) {

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

    public boolean isInCorrectWord(char letter) {
        for(int i = 0; i < correctWord.length(); i ++) {
            if(correctWord.charAt(i) == Character.toLowerCase(letter) ){
                return true;
            }
        }
        return false;
    }

    public void replaceInWordChecker(char letter) {
        for(int i = 0; i < correctWord.length(); i ++) {
            if(correctWord.charAt(i) == Character.toLowerCase(letter) ){
               wordChecker[i] = '0';
                guessSplit[i] = letter;
            }
        }
    }

    public char getGuessType(Scanner myObj) {

        System.out.println("Enter 'w' to guess the word anything else to guess a letter");

        String type = myObj.nextLine();
        if(type.length() > 0) {
            return type.toLowerCase().charAt(0);
        } else {
            return 'l';
        }

    }
    public void checkLetter(char letter) {
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

    public char checkPlayAgain(Scanner myObj) {
        String letter = myObj.nextLine();

        return letter.toLowerCase().charAt(0);
    }

    public void draw(int lives) {
        if(lives == 7) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("________");
        } else if (lives == 6) {
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 5) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 4) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 3) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 2) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|   _|_");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 1) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|   _|_");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 0) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   x x");
            System.out.println("|   _|_");
            System.out.println("|    |");
            System.out.println("|   / \\");
            System.out.println("________");
        }


    }

    public static void main(String[] args) {
        boolean gameIsRunning = true;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while(gameIsRunning) {
            Hangman newGame = new Hangman();

            for(int i = 0; i < newGame.wordChecker.length; i ++) {
                newGame.wordChecker[i] = '1';
                newGame.guessSplit[i] = '_';
            }

            System.out.println(Arrays.toString(newGame.guessSplit));

            while(!newGame.isGameOver) {
                newGame.draw(newGame.lives);

                if(checkGameOver(newGame.wordChecker)) {
                    System.out.println("You WIN!!! the hidden word was: " + newGame.correctWord);
                    System.out.println("Lives Remaining: " + newGame.lives);
                    break;
                }

                if(newGame.lives == 0) {
                    System.out.println("You ran out of newGame.lives, you LOSE");
                    System.out.println("The correct word was: " + newGame.correctWord);
                    break;
                }

                char guessType = newGame.getGuessType(myObj);

                if(guessType == 'w') {
                    String word = newGame.userWordGuess(myObj);
                    System.out.println("You guessed " + word);

                    if(newGame.checkWord(word)) {
                        System.out.println("You WIN!!! the hidden word was: " + newGame.correctWord);
                        System.out.println("Lives Remaining: " + newGame.lives);
                        break;
                    }

                } else {

                    char character = newGame.userGuess(myObj);

                    System.out.println("--------------------");
                    System.out.println("--------------------");
                    System.out.println("You guessed " + character);

                    newGame.checkLetter(character);

                }
            }

            System.out.println("Please enter Y to play again anything else to exit");
            char playAgain = newGame.checkPlayAgain(myObj);
            if(playAgain == 'y') {
                System.out.println("New game loading...");
            } else {
                System.out.println("Thank you for playing, see you next time!");
                break;
            }

        }

    }
}