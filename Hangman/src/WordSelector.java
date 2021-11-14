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
    private String updatedWord="";

    public String getUpdatedWord() {
        return updatedWord;
    }

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
    public void reset(){
        wordLength=0;
        selectedWord="";
        for(int i=0; i<incorrectLetters.size();){
            incorrectLetters.remove(i);
        }
        for(int i=0; i< correctLetters.size();){
            correctLetters.remove(i);
        }
        for(int i=0;i<selectedWordArray.size();){
            selectedWordArray.remove(i);
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
                updatedWord = "";
                for(String string: selectedWordArray){
                    this.updatedWord = this.updatedWord + string;
                    if(updatedWord.equals(selectedWord)){
                        System.out.println("YOU WIN!!!");
                        System.out.println("The correct word was " + selectedWord + "!");
                        correctGuess = true;
                    }
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
