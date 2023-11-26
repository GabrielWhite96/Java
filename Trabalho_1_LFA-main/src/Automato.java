import java.util.List;

public class Automato {
    private int [][] automato;
    private String [][] rules;
    private List<String> automatoNF;
    private File file;
    private String statesSequence;
    private int rows;
    private int columns;
    private char[] stack;
    
    public Automato(String path){
        this.stack = new char[] {};
        this.file = new File(path);
        this.statesSequence = "q0";
        this.automatoNF = file.getContent();
        this.calculateRowsAndColumns(automatoNF);
        this.automato = new int[this.rows][this.columns];
        this.rules = new String[this.rows][this.columns];
        this.createRules(automatoNF);
        this.criarAutomato(automatoNF);
    }

    private void calculateRowsAndColumns(List<String> automatoNF){
        this.rows = automatoNF.size();
        this.columns = automatoNF.get(0).split(";").length;
    }

    private void createRules(List<String> automato){
        for(int i = 0; i < rows; i++){
            String[] line = automato.get(i).split(";");
            for(int j = 0; j < columns; j++){
                this.rules[i][j] = line[j];
            }
        }
    }

    private void criarAutomato(List<String> automato) {
        for (int i = 0; i < rows; i++) {
            String[] line = automato.get(i).split(";");
            for (int j = 0; j < columns; j++) {
                String[] values = line[j].split(",");
                this.automato[i][j] = (values[0].equals("-")) ? -1 : Integer.parseInt(values[0]);
            }
        }
    }
    
    // private boolean isTerminalState(int row){
    //     int lastDestination = this.automato[row][0];

    //     for(int i = 0; i < this.automato[row].length; i++){
    //         if(lastDestination != this.automato[row][i]) return false;
    //         if(this.stack.length!=0) return false;
    //         lastDestination = this.automato[row][i];
    //     }
    //     return true;
    // }

    private boolean isTerminalState() {
        return (this.stack.length == 0) ? true : false;
    }

    private Boolean testWord(String word){
        int column, row = 0;

        for (int i = 1; i <= word.length(); i++) {
            char letter = word.charAt(i-1);

            column = Character.getNumericValue(letter);

            if(addOrRemove(row, column)) return false;
            
            row = this.automato[row][column];

            if(row == -1) return false;
        }

        return (isTerminalState()) ? true : false;
    }
    
    // private Boolean testWord(String word){
    //     int column, row = 0;
    //     for (int i = 1; i <= word.length(); i++) {
    //         char letter = word.charAt(i-1);

    //         column = Character.getNumericValue(letter);
    //         row = this.automato[row][column];

    //         if(!addOrRemove(letter)) return false;

    //         if(row == -1) return false;
            
    //         if(isTerminalState(row)) return true;
    //     }
    //     return false;
    // }

    public boolean addOrRemove(int row, int column){
        char[] rule = this.rules[row][column].toCharArray();
        if(rule[2] == 'e'){
            this.stack = addChar(this.stack, rule[4]);
        }else if(this.stack.length != 0){
            this.stack = removeLastChar(this.stack);
        }else{
            return true;
        }
        return false;
    }

    public static char[] addChar(char[] vetor, char novoChar) {
        char[] novoVetor = new char[vetor.length + 1];
        
        for (int i = 0; i < vetor.length; i++) novoVetor[i] = vetor[i];
        
        novoVetor[novoVetor.length - 1] = novoChar;

        return novoVetor;
    }

    public static char[] removeLastChar(char[] vetor) {
        if (vetor.length == 0) return vetor;

        char[] novoVetor = new char[vetor.length - 1];

        for (int i = 0; i < novoVetor.length; i++) novoVetor[i] = vetor[i];

        return novoVetor;
    }

    // public static char getLastChar(char[] vetor) {
    //     if (vetor.length == 0) throw new IllegalArgumentException("O vetor está vazio.");

    //     return vetor[vetor.length - 1];
    // }

    public void allow(String word){
        if(this.testWord(word)){
            System.out.println(("Esta palavra é aceita pelo autômato!"));
        } else {
            System.out.println(("Esta palavra não é aceita pelo autômato!"));
        }

        System.out.println("Caminho seguido pela palavra: " + this.statesSequence);

        this.statesSequence = "q0";
    }
}
