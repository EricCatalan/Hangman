import java.util.List;

public class Hangman {
    private int stageLevel = 0;
    private int wordLength = 0;
    private String board;
    private Boolean wonGame = false;

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getStageLevel() {
        return stageLevel;
    }

    public void setStageLevel(int stageLevel) {
        this.stageLevel = stageLevel;
    }

    public void addLevel(){
        this.stageLevel = this.stageLevel + 1;
    }
    public void printStage (int input) {
        if (input == 0) {
            System.out.println("-------");
            System.out.println("|    | ");

            System.out.println("");
            System.out.println("");
        }

        if (input == 1) {
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("");
            System.out.println("");
        }
        if(input == 2){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|    |  ");
            System.out.println("");
            System.out.println("");
        }
        if(input == 3){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|    |  ");
            System.out.println("|    |  ");
            System.out.println("");
            System.out.println("");
        }
        if(input == 4){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|    |  ");
            System.out.println("|    |  ");
            System.out.println("|   /   ");
            System.out.println("");
            System.out.println("");
        }
        if(input == 5){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|    |  ");
            System.out.println("|    |  ");
            System.out.println("|   / \\ ");
            System.out.println("");
            System.out.println("");
        }
        if(input==6){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|   /|  ");
            System.out.println("|    |  ");
            System.out.println("|   / \\ ");
            System.out.println("");
            System.out.println("");
        }
        if(input == 7){
            System.out.println("-------");
            System.out.println("|    | ");
            System.out.println("|    O  ");
            System.out.println("|   /|\\  ");
            System.out.println("|    |  ");
            System.out.println("|   / \\ ");
            System.out.println("");
            System.out.println("");
        }
    }


    public void setUpBoard(){
        String blanks = "";
        for(int i=0; i< this.wordLength; i++){
            blanks = blanks + "____ ";
        }
        this.board = blanks;
    }

    public void printBoard(List<String> correctGuesses){
        String blanks = "";
        System.out.println("This word has " + this.wordLength + " letters!");
        System.out.println();
        System.out.println();
        for(String string: correctGuesses){
            blanks = blanks + "  " + string + "  ";
        }
        System.out.println(blanks);
        System.out.println(this.board);
    }

}
