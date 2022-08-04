package classes;

import java.util.Scanner;

public class Studant extends Person{
    //attributes
    private String matricula;
    private int anoIngresso; 
    
    //constructor
    public Studant(){
        super();
        this.matricula = "00000";
        this.anoIngresso = 0;
    }

    //get and set methods
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
    
    //function fill in student
    public void preencher(){
        try (Scanner ler = new Scanner(System.in)) {
            System.out.println("*******Preencha os dados do Aluno*******");
            super.preencher();
            System.out.print("Informe a matricula: ");
            this.matricula = ler.next();
            System.out.print("Informe o ano de Ingresso: ");
            this.anoIngresso = ler.nextInt();
        } 
    }

    //function print infos
    public String toString(){
        String saida = "";
            saida = "----------Dados do Aluno----------\n"
            + super.toString() + "\n"
            +"Matricula: " + this.matricula + "\n"
            +"Ano de Ingresso: " + this.anoIngresso + "\n"
            +"--------------------------------------\n";
        return saida;
    }
    
    //function that copies information from another object
    public void copyObject(Studant outro){
        super.name = outro.getName();
        super.sex = outro.getSex();
        super.age = outro.getAge();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
    }
    
    public String cabecalho(){
        return "name;sex;age;matricula;anoIngresso\n";
    }
    
    
    public String atributoToCSV(){
        String aux = super.name + ";" + super.sex + ";" + super.age + ";" + this.matricula + ";" + this.anoIngresso + "\n";
        return aux;
    }
    
    public void CSVToAtributo(String csv){
        String vetor[] = csv.split(";");
        
        super.name = vetor[0];
        super.sex = vetor[1].charAt(0);
        super.age = Integer.parseInt(vetor[2]);
        this.matricula = vetor[3];
        this.anoIngresso = Integer.parseInt(vetor[4]);
    }

}