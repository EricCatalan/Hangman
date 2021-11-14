import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSelector {


    private String[] wordBank = {"offer", "essential", "discuss", "stuff", "insight", "bridge", "century", "missile", "base", "breakfast", "penny", "eternal", "custody", "weight", "transmission", "ask", "spy", "compound", "mastermind", "isolation"};
    private String selectedWord;
    private int wordLength = 0;
    private List<String> incorrectLetters = new ArrayList<>();
    private List<String> correctLetters = new ArrayList<>();
    private List<String> selectedWordArray= new ArrayList<>();


    public List<String> getSelectedWordArray() {
        return selectedWordArray;
    }

    public void setRandomWord() {
        int rnd = new Random().nextInt(this.wordBank.length);
        this.selectedWord = this.wordBank[rnd];
        this.wordLength = this.selectedWord.length();
        for(int i =0; i<this.selectedWord.length(); i++){
            selectedWordArray.add("*");
        }



    }

    public String getSelectedWord() {
        return selectedWord;
    }

    public int getWordLength() {
        return wordLength;
    }

    public boolean wasGuessCorrect(String guess) {
        boolean correctGuess = false;
        for (int i = 0; i < this.selectedWord.length(); i++) {
            char actualLetter = selectedWord.charAt(i);
            char guessedLetter = guess.charAt(0);
            if (actualLetter == guessedLetter) {
                correctLetters.add(guess);
                correctGuess = true;
                this.selectedWordArray.set(i, guess);
            }
        }
            if(!correctGuess){
            incorrectLetters.add(guess);
            }
        return correctGuess;
    }

    public void printIncorrectLetters(){
        System.out.println("These are your wrong guesses: ");
        for(String string: incorrectLetters){
            System.out.print(string + " ");
        }

    }

}
