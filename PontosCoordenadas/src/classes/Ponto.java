package classes;

import java.util.Scanner;

public class Ponto{
    private int cordx;
    private int cordy;
    private Scanner ler;

    /**construtor */
    public Ponto(){
        this.cordx = 0;
        this.cordy = 0;
    }

    /**gets e sets */
    public void setCordx(int cordx){
        this.cordx = cordx;
    }
    public int getCordx(){
        return this.cordx;
    }
    public void setCordy(int cordy){
        this.cordy = cordy;
    }
    public int getCordy(){
        return this.cordy;
    }

    /**funções principais */
    public void preencher(){
        ler = new Scanner(System.in);
        System.out.println("Informe as coordenadas.");
        System.out.printf("Informe o eixo x: ");
        this.cordx = ler.nextInt();
        System.out.printf("Informe o eixo y: ");
        this.cordy = ler.nextInt();
    }
    
    public void copiar(Ponto outro){
        this.cordx = outro.getCordx();
        this.cordy = outro.getCordy();
    }

    @Override
    public String toString(){
        String aux = "("+this.cordx+", "+this.cordy+")";
        return aux;
    }

    /**funções extra */
    public double distancia(Ponto outro){
        double difX = outro.getCordx() - this.cordx;
        double difY = outro.getCordy() - this.cordy;
        double resX = difX * difX;
        double resY = difY * difY;
        double dist = Math.sqrt(resX + resY);
        return dist;
    }

    public double determinante(Ponto p2, Ponto p3){
        double parcela1 = this.cordx * p2.getCordy() * 1 + p2.getCordx() * p3.getCordy() * 1 + this.cordy * 1 * p3.getCordx();
        double parcela2 = p3.getCordx() * p2.getCordy() * 1 + p2.getCordx() * this.cordy * 1 + p3.getCordy() * 1 * this.cordx;
        double det =  parcela1 - parcela2;
        return det; 
    }

}