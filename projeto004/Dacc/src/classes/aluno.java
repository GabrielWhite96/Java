package classes;

import java.util.Scanner;

public class aluno {
    //Váriaveis
    private String nome;
    private String matricula;
    private int idade;
    private int periodo;
    private Scanner ler;

    //Construtor
    public aluno(){
        this.nome = "";
        this.matricula = "";
        this.idade = 0;
        this.periodo = 0;
    }

    //gets e sets
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setPeriodo(int periodo){
        this.periodo = periodo;
    }
    public int getPeriodo(){
        return this.periodo;
    }

    //Funções principais
    public void preencher(){
        ler = new Scanner(System.in);
        System.out.printf("Insira as informações.");
        System.out.printf("Nome: ");
        this.nome = ler.next();
        System.out.printf("Idade: ");
        this.idade = ler.nextInt();
        System.out.printf("Matricula: ");
        this.matricula = ler.next();
        System.out.printf("Periodo: ");
        this.periodo = ler.nextInt();
    }

    public void copiar(aluno outro){
        this.nome = outro.getNome();
        this.matricula = outro.getMatricula();
        this.idade = outro.getIdade();
        this.periodo = outro.getPeriodo();
    }

    @Override
    public String toString(){
        return "\n------------------Aluno------------------" +
        "\nNome: " +
        this.nome +
        "\nIdade: " +
        this.idade +
        "\nMatricula: "+
        this.matricula +
        "\nPeriodo: "+
        this.periodo + "\n------------------------------------------";

    }



}
