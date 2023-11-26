import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra para testar: ");
        String word = scanner.nextLine();

        Automato automato = new Automato("./automatos/automatoT.csv");

        if(!isNumeric(word)) word = convertWord(word);

        automato.allow(word);
    }

    public static Boolean isNumeric(String word){
        int firstCharacter = (int) word.toCharArray()[0];
        return (firstCharacter < 122 && firstCharacter > 96) ? false : true;
    }

    public static String convertWord(String word){
        String newWord = "";
        for(char letter : word.toLowerCase().toCharArray()){
            newWord += ((int) letter) - 97;
        }
        return newWord;
    }
}
