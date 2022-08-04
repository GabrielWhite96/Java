package classes;

import java.util.Scanner;

public class Person {
    //attributes
    protected String name;
    protected char sex;
    protected int age;
    
    //constructor
    public Person(){
        this.name = "";
        this.sex = ' ';
        this.age = 0;
    }
    
    //get and set methods
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public char getSex(){
        return this.sex;
    }
    public void setSex(char sex){
        this.sex = sex;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }

    //function fill in person
    public void preencher(){
        try (Scanner ler = new Scanner(System.in)) {
            System.out.print("Informe o name: ");
            this.name = ler.nextLine();
            System.out.print("Informe o sex: ");
            this.sex = ler.next().charAt(0);
            System.out.print("Informe a age: ");
            this.age = ler.nextInt();
        }
    }

    //function print infos
    public String toString(){
        String saida = "";
            saida = "name: " + this.name + "\n"
            +"sex: " + this.sex + "\n"
            +"age: " + this.age;

        return saida;
    }
    
    
}