package classes;

import java.util.Scanner;

public class professor {
    //Váriaveis
    private String nome;
    private String cpf;
    private int idade;
    private boolean pos;
    private Scanner ler;

    //Construtor
    public professor(){
        this.nome = "";
        this.cpf = "000.000.000-00";
        this.idade = 0;
        this.pos = false;
    }

    //gets e sets
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setPos(boolean pos){
        this.pos = pos;
    }
    public boolean isPos(){
        return this.pos;
    }

    //Funções principais
    public void preencher(){
        ler = new Scanner(System.in);
        System.out.printf("Insira as informações.");
        System.out.printf("\nNome: ");
        this.nome = ler.next();
        System.out.printf("Idade: ");
        this.idade = ler.nextInt();
        System.out.printf("CPF: ");
        this.cpf = ler.next();
        System.out.printf("Tem pós graduação: ");
        this.pos = ler.nextBoolean();
    }

    public void copiar(professor outro){
        this.nome = outro.getNome();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
        this.pos = outro.isPos();
    }

    @Override
    public String toString(){
        return "\n-----------------Professor-----------------" +
        "\nNome: " +
        this.nome +
        "\nIdade: " +
        this.idade +
        "\nCPF: "+
        this.cpf +
        "\nTem pós graduação: "+
        this.pos +
        "\n------------------------------------------";
    }
}
