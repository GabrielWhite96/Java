package classes;

import java.util.Scanner;

public class diciplina {
    //Váriaveis
    private String nome;
    private int semestre;
    private professor ministrante;
    private aluno listAluno[];
    private Scanner ler;

    //Construtor
    public diciplina(){
        this.nome = "";
        this.semestre = 0;
        this.ministrante = new professor();
        this.listAluno = new aluno[2];
        for(int i=0; i<=1 ; i++){
            this.listAluno[i] = new aluno();
        }
    }

    //gets e sets
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    public int getSemestre(){
        return this.semestre;
    }
    public void setMinistrante(professor ministrante){
        this.ministrante = ministrante;
    }
    public professor getMinistrante(){
        return this.ministrante;
    }
    public void setListAluno(aluno[] listAlunos){
        this.listAluno = listAlunos;
    }
    public aluno[] getListAluno(){
        return this.listAluno;
    }

    //Funções principais
    public void preencher(){
        ler = new Scanner(System.in);
        System.out.println("INSIRA AS INFORMAÇÕES DA DICIPLINA");
        System.out.printf("Nome: ");
        this.nome = ler.next();
        System.out.printf("Semestre: ");
        this.semestre = ler.nextInt();
        System.out.print("Professor---->");
        ministrante.preencher();
        for(int i=0; i<=1; i++){
            this.listAluno[i].preencher();
        }
    }

    public void copiar(diciplina outro){
        this.nome = outro.getNome();
        this.semestre = outro.getSemestre();
        this.ministrante.copiar(outro.getMinistrante());
        for(int i=0; i<=1; i++){
            this.listAluno[i].copiar(outro.getListAluno()[i]);
        }
    }

    @Override
    public String toString(){
        String aux = "";
        for(int i=0; i < listAluno.length; i++){
            aux += listAluno[i];
        }
        return "\n-----------------Diciplina-----------------" +
        "\nNome: " +
        this.nome +
        "\nSemestre: " +
        this.semestre +
        "\n------------------------------------------" +
        ministrante + 
        aux;
    }




}
