package classes;

import java.util.Scanner;

public class Disciplina {
    //attributes
    private String name;
    private int semester;
    private String horario;
    private Teacher ministrante;
    private Studant[] listStudants;
    
    //constructor
    public Disciplina(){
        this.name = "";
        this.semester = -1;
        this.horario = "0h";
        this.ministrante = new Teacher();
        this.listStudants = new Studant[3];
        
        for(int i=0; i<3; i++){
            this.listStudants[i] = new Studant();
        }
    }

    //get and set methods
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }
    public int getSemester(){
        return this.semester;
    }
    public void setHorario(String horario){
        this.horario = horario;
    }
    public String getHorario(){
        return this.horario;
    }
    public void setMinistrante(Teacher ministrante){
        this.ministrante = ministrante;
    }
    public Teacher getMinistrante(){
        return this.ministrante;
    }
    public void setListStudants(Studant[] listStudants){
        this.listStudants = listStudants;
    }
    public Studant[] getListStudants(){
        return this.listStudants;
    }
    
    //function fill in student
    public void preencher(){
        try (Scanner ler = new Scanner(System.in)) {
            System.out.println("*******Preencha os dados da Disciplina*******");
            System.out.print("Informe o name: ");
            this.name = ler.nextLine();
            System.out.print("Informe o semester: ");
            this.semester = ler.nextInt();
            System.out.print("Infome o horario: ");
            this.horario = ler.next();
        }
        this.ministrante.preencher();
        
        for(int i=0; i<3; i++){
            this.listStudants[i].preencher();
        }
    }

    //function print infos
    public String toString(){
        String saida = "-------Dados da Disciplina-------"
        + "\nName: " + this.name
        + "\nSemester: " + this.semester
        + "\nName: " + this.horario
        + this.ministrante.toString();
        for(int i=0; i<3; i++){
            this.listStudants[i].toString();
        }
        return saida;
    }
    
    //function that copies information from another object
    public void copyObject(Disciplina outro){
        this.name = outro.getName();
        this.semester = outro.getSemester();
        this.horario = outro.getHorario();
        
        this.ministrante.copyObject(outro.getMinistrante());
        
        for(int i=0; i<3; i++){
            this.listStudants[i].copyObject(outro.getListStudants()[i]);
        }
    }
    
    
}
