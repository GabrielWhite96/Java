package classes;

import java.util.Scanner;

public class Teacher extends Person{
    //attributes
    private String cpf;
    
    //constructor
    public Teacher(){
        super();
        this.cpf = "000.000.000-00";
    }
    
    //get and set methods
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    //function fill in student
    public void preencher(){
        try (Scanner ler = new Scanner(System.in)) {
            System.out.println("*********Preencha os dados do Professor*********");
            super.preencher();
            System.out.print("Informe o cpf: ");
            this.cpf = ler.next();
        }
    }
    
    //function print infos
    public String toString(){
        String saida = "";
            saida = "----------Dados do Professor----------\n"
            + super.toString() + "\n"
            +"CPF: " + this.cpf + "\n"
            +"--------------------------------------\n";
        return saida;
    }
    
    //function that copies information from another object
    public void copyObject(Teacher outro){
        super.name = outro.getName();
        super.sex = outro.getSex();
        super.age = outro.getAge();
        this.cpf = outro.getCpf();
    }
    
    public String cabecalho(){
        return "name;sex;age;cpf\n";
    }
    
    public String atributoToCSV(){
        String aux = super.name + ";" + super.sex + ";" + super.age + ";" + this.cpf + "\n";
        return aux;
    }
    
    public void CSVToAtributo(String csv){
        String vetor[] = csv.split(";");
        
        super.name = vetor[0];
        super.sex = vetor[1].charAt(0);
        super.age = Integer.parseInt(vetor[2]);
        this.cpf = vetor[3];
    }
    
}