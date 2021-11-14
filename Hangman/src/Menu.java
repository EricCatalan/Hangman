import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private PrintWriter out;
    private Scanner in;
    private String userInput;
    private String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String selectedWord = "";


    public String getSelectedWord() {
        return selectedWord;
    }

    public void setSelectedWord(String selectedWord) {
        this.selectedWord = selectedWord;
    }

    public Menu (InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getUserInput () throws NullPointerException {
        Object choice = null;
        boolean wordGuess = false;
        while (!wordGuess) {
            System.out.println("Please enter your word guess: ");
            userInput = in.nextLine();
            if (userInput.toLowerCase().equals(selectedWord)) {
                System.out.println("YOU WIN!!!");
                choice = "winner";
                return choice;
                }
            wordGuess = true;
        }
        while (wordGuess) {
            System.out.println("Please enter your letter choice: ");
            userInput = in.nextLine();
            for (int i = 0; i < letters.length; i++) {
                if (userInput.toLowerCase().equals(letters[i])) {
                    choice = userInput;
                    wordGuess = false;
                }
            }
        }return choice;
    }

    public Object yesOrNo(){
        boolean haveAnswer = false;
        Object choice = null;
        while(!haveAnswer){
            System.out.println("Do you want to play again? Y/N: ");
            userInput = in.nextLine();
            if(userInput.toLowerCase().equals("y") || userInput.toLowerCase().equals("n")){
                choice = userInput;
                haveAnswer = true;
            }
        }
        return choice;
    }
}
