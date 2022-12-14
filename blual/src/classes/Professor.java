package classes;

import java.util.Scanner;

public class Professor extends Pessoa{
    private String cpf;
    
    public Professor(){
        super();
        this.cpf = "000.000.000-00";
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("*********Preencha os dados do Professor*********");
        super.preencher();
        System.out.print("Informe o cpf: ");
        this.cpf = ler.next();
    }
    
    public void imprimir(){
        System.out.println("----------Dados do Professor----------");
        super.imprimir();
        System.out.println("CPF: " + this.cpf);
        System.out.println("--------------------------------------");
    }
    
    public String imprimirParaString(){
        String saida = "";
            saida = "----------Dados do Professor----------\n"
            + super.imprimirParaString() + "\n"
            +"CPF: " + this.cpf + "\n"
            +"--------------------------------------\n";
        return saida;
    }
    
    public void copiar(Professor outro){
        super.nome = outro.getNome();
        super.sexo = outro.getSexo();
        super.idade = outro.getIdade();
        this.cpf = outro.getCpf();
    }
    
    public String cabecalho(){
        return "Nome;sexo;idade;cpf\n";
    }
    
    public String atributoToCSV(){
        String aux = super.nome + ";" + super.sexo + ";" + super.idade + ";" + this.cpf + "\n";
        return aux;
    }
    
    public void CSVToAtributo(String csv){
        String vetor[] = csv.split(";");
        
        super.nome = vetor[0];
        super.sexo = vetor[1].charAt(0);
        super.idade = Integer.parseInt(vetor[2]);
        this.cpf = vetor[3];
    }
    
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}