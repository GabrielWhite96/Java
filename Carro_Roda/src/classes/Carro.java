package classes;

import java.util.Scanner;

public class Carro {
    //atributos
    private String fabricante;
    private String modeloC;
    private String cor;
    private double motor;
    private Roda rodas[];
    private Scanner ler;

    //construtor
    public Carro(){
        this.fabricante = "";
        this.modeloC = "";
        this.cor = "";
        this.motor = 0;
        this.rodas = new Roda[4];
        for(int i=0; i<=3; i++){
            this.rodas[i] = new Roda();
        }
    }

    //gets e sets
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public String getFabricante(){
        return this.fabricante;
    }
    public void setModelo(String modeloC){
        this.modeloC = modeloC;
    }
    public String getModelo(){
        return this.modeloC;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getCor(){
        return this.cor;
    }
    public void setMotor(double motor){
        this.motor = motor;
    }
    public double getMotor(){
        return this.motor;
    }
    public void setRodas(Roda[] rodas){
        this.rodas = rodas;
    }
    public Roda[] getRodas(){
        return this.rodas;
    }


    //funçoes principais
    public void preencher(){
        ler =  new Scanner(System.in);
        System.out.println("Insira as informações pedidas.");
        System.out.printf("Fabricante: ");
        this.fabricante = ler.next();
        System.out.printf("Modelo: ");
        this.modeloC = ler.next();
        System.out.printf("Cor: ");
        this.cor = ler.next();
        System.out.printf("Motor (em HP): ");
        this.motor = ler.nextDouble();
        System.out.printf("Roda-------------------------- ");
        this.rodas[0].preencher();
        this.preencherRoda();
    }

    @Override
    public String toString(){
        String aux = "\n----------------CARRO----------------" +
        "\nFabricante: " + this.fabricante +
        "\nModelo: " + this.modeloC +
        "\nCor: "+ this.cor +
        "\nMotor (em HP): "+ this.motor +
        "\n------------------------------------------" +
        this.rodas[0].toString();
        return aux;
    }
    
    public void copiar(Carro outro){
        this.fabricante = outro.getFabricante();
        this.modeloC = outro.getModelo();
        this.cor = outro.getCor();
        this.motor = outro.getMotor();
        this.rodas = outro.getRodas();
    }

    //Funções extra
    private void preencherRoda(){
        this.rodas[1] = this.rodas[0];
        this.rodas[2] = this.rodas[0];
        this.rodas[3] = this.rodas[0];
    }
}
