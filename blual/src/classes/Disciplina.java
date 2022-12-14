package classes;

import java.util.Scanner;

public class Disciplina {
    private String nome;
    private int semestre;
    private String horario;
    private Professor ministrante;
    private Aluno[] listAlunos;
    
    public Disciplina(){
        this.nome = "";
        this.semestre = -1;
        this.horario = "0h";
        this.ministrante = new Professor();
        this.listAlunos = new Aluno[3];
        
        for(int i=0; i<3; i++){
            this.listAlunos[i] = new Aluno();
        }
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("*******Preencha os dados da Disciplina*******");
        System.out.print("Informe o nome: ");
        this.nome = ler.nextLine();
        System.out.print("Informe o semestre: ");
        this.semestre = ler.nextInt();
        System.out.print("Infome o horario: ");
        this.horario = ler.next();
        
        this.ministrante.preencher();
        
        for(int i=0; i<3; i++){
            this.listAlunos[i].preencher();
        }
    }
    
    public void imprimir(){
        System.out.println("-------Dados da Disciplina-------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Semestre: " + this.semestre);
        System.out.println("Horario: " + this.horario);
        
        this.ministrante.imprimir();
        
        for(int i=0; i<3; i++){
            this.listAlunos[i].imprimir();
        }
    }
    
    public void copiar(Disciplina outro){
        this.nome = outro.getNome();
        this.semestre = outro.getSemestre();
        this.horario = outro.getHorario();
        
        this.ministrante.copiar(outro.getMinistrante());
        
        for(int i=0; i<3; i++){
            this.listAlunos[i].copiar(outro.getListAlunos()[i]);
        }
    }
    
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
    
    public void setHorario(String horario){
        this.horario = horario;
    }
    public String getHorario(){
        return this.horario;
    }
    
    public void setMinistrante(Professor ministrante){
        this.ministrante = ministrante;
    }
    public Professor getMinistrante(){
        return this.ministrante;
    }
    
    public void setListAlunos(Aluno[] listAlunos){
        this.listAlunos = listAlunos;
    }
    public Aluno[] getListAlunos(){
        return this.listAlunos;
    }
    
}
