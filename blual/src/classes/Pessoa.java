package classes;

import java.util.Scanner;

public class Pessoa {
    protected String nome;
    protected char sexo;
    protected int idade;
    
    public Pessoa(){
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        this.nome = ler.nextLine();
        System.out.print("Informe o sexo: ");
        this.sexo = ler.next().charAt(0);
        System.out.print("Informe a idade: ");
        this.idade = ler.nextInt();
    }
    
    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
    }
    
    public String imprimirParaString(){
        String saida = "";
            saida = "Nome: " + this.nome + "\n"
            +"Sexo: " + this.sexo + "\n"
            +"Idade: " + this.idade;

        return saida;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public char getSexo(){
        return this.sexo;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    
}