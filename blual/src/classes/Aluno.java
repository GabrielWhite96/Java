package classes;

import java.util.Scanner;

public class Aluno extends Pessoa{
    private String matricula;
    private int anoIngresso; 
    
    public Aluno(){
        super();
        this.matricula = "00000";
        this.anoIngresso = 0;
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("*******Preencha os dados do Aluno*******");
        super.preencher();
        System.out.print("Informe a matricula: ");
        this.matricula = ler.next();
        System.out.print("Informe o ano de Ingresso: ");
        this.anoIngresso = ler.nextInt();
    }
    
    public void imprimir(){
        System.out.println("-------Dados do Aluno-------");
        super.imprimir();
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Ano de Ingresso: " +this.anoIngresso);
    }
    
    public String imprimirParaString(){
        String saida = "";
            saida = "----------Dados do Aluno----------\n"
            + super.imprimirParaString() + "\n"
            +"Matricula: " + this.matricula + "\n"
            +"Ano de Ingresso: " + this.anoIngresso + "\n"
            +"--------------------------------------\n";
        return saida;
    }
    
    public void copiar(Aluno outro){
        super.nome = outro.getNome();
        super.sexo = outro.getSexo();
        super.idade = outro.getIdade();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
    }
    
    public String cabecalho(){
        return "Nome;sexo;idade;matricula;anoIngresso\n";
    }
    
    public String atributoToCSV(){
        String aux = super.nome + ";" + super.sexo + ";" + super.idade + ";" + this.matricula + ";" + this.anoIngresso + "\n";
        return aux;
    }
    
    public void CSVToAtributo(String csv){
        String vetor[] = csv.split(";");
        
        super.nome = vetor[0];
        super.sexo = vetor[1].charAt(0);
        super.idade = Integer.parseInt(vetor[2]);
        this.matricula = vetor[3];
        this.anoIngresso = Integer.parseInt(vetor[4]);
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }
    
    public void setAnoIngresso(int anoIngresso){
        this.anoIngresso = anoIngresso;
    }
    public int getAnoIngresso(){
        return this.anoIngresso;
    }
}