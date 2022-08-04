package classes;

import java.util.Scanner;

public class Roda {
    //atributos
    private String modeloR;
    private double aro;
    private double peso;
    private Scanner ler;

    //construtor
    public Roda(){
        this.modeloR = "";
        this.aro = 0;
        this.peso = 0;    
    }

    //gets e sets
    public void setModeloR(String modeloR){
        this.modeloR = modeloR;
    }
    public String getModelo(){
        return this.modeloR;
    }
    public void setAro(double aro){
        this.aro = aro;
    }
    public double getAro(){
        return this.aro;
    }
    public void set(double peso){
        this.peso = peso;
    }
    public double getPeso(){
        return this.peso;
    }


    //funçoes principais
    public void preencher(){
        ler =  new Scanner(System.in);
        System.out.println("\nInsira as informações pedidas.");
        System.out.printf("Modelo: ");
        this.modeloR = ler.next();
        System.out.printf("Aro: ");
        this.aro = ler.nextDouble();
        System.out.printf("Peso (em gramas): ");
        this.peso = ler.nextDouble();
    }

    @Override
    public String toString(){
        String aux = "\n-----------------Rodas-----------------" + "\nModelo: " + this.modeloR + "\nAro: "+ this.aro + "\nPeso (em grama): "+ this.peso + "\n------------------------------------------";
        return aux;
    }
}
