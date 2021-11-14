public class App {
    private Hangman hangman = new Hangman();
    private WordSelector wordSelector = new WordSelector();
    private Menu menu;
    private String inputLetter = "";

    public App (Menu menu){
        this.menu = menu;
    }

    public static void main(String[] args) {
    Menu menu = new Menu(System.in,System.out);
    App newApp = new App(menu);
    newApp.run();
    }
    public void run(){
        this.menu = menu;
        startGame();
    }

    private void startGame(){
        wordSelector.setRandomWord();
        hangman.setWordLength(wordSelector.getWordLength());
        hangman.setUpBoard();
        menu.setSelectedWord(wordSelector.getSelectedWord());
        iterateThroughGame();
    }

    private void iterateThroughGame() {
        while (hangman.getStageLevel() <= 7) {
            printBoard();
            if (wordSelector.wasGuessCorrect(this.inputLetter.toLowerCase())) {
                if(wordSelector.getUpdatedWord().equals(wordSelector.getSelectedWord())){
                    restart();
                }
                System.out.println("Great Guess!");
                System.out.println();
                iterateThroughGame();
            }
            else {
                System.out.println("That letter wasn't in the word :( " );
                System.out.println();
                hangman.addLevel();
            }
        }
        System.out.println("YOU LOSE");
        System.out.println("The word was " + wordSelector.getSelectedWord() + "!");
        restart();
    }
    private void printBoard(){
        hangman.printBoard(wordSelector.getSelectedWordArray());
        System.out.println();
        System.out.println();
        wordSelector.printIncorrectLetters();
        System.out.println("");
        System.out.println("You have " + (8 - hangman.getStageLevel()) + " wrong guesses left! ");
        hangman.printStage(hangman.getStageLevel());
        this.inputLetter =(String) menu.getUserInput();
        if(this.inputLetter.toLowerCase().equals("winner")){
            restart();
        }

    }

    private void restart(){
        String yesOrNo = menu.yesOrNo().toString().toLowerCase();
       if( yesOrNo.equals("y")){
           hangman.reset();
           wordSelector.reset();
           run();
       }
       else if(yesOrNo.equals("n")){
           System.exit(2);
       }
    }

}
