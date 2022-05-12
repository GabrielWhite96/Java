package classes;

import java.util.Scanner;

public class computador {
    private String processador;
    private String placaVideo;
    private double ram;
    private boolean ssd;

    /*construtor */
    public computador(){
        this.processador = "";
        this.placaVideo = "";
        this.ram = 0;
        this.ssd = false;
    }

    /*gets e sets */
    public void setProcessador(String processador){
        this.processador = processador;
    }
    public String getProcessador(){
        return this.processador;
    }
    public void setPlacaVideo(String placaVideo){
        this.placaVideo = placaVideo;
    }
    public String getPlacaVideo(){
        return this.placaVideo;
    }
    public void setRam(double ram){
        this.ram = ram;
    }
    public double getRam(){
        return this.ram;
    }
    public void setSsd(Boolean ssd){
        this.ssd = ssd;
    }
    public boolean isSsd(){
        return this.ssd;
    }

    /*funções principais*/
    public void preencherPc(){
        Scanner ler = new Scanner(System.in);
        System.out.println("\n\nInsira as informações pedidas.");
        System.out.printf("Processador: ");
        this.processador = ler.next();
        System.out.printf("Placa de Video: ");
        this.placaVideo = ler.next();
        System.out.printf("Quantidade de memoria ram em gb: ");
        this.ram = ler.nextDouble();
        System.out.printf("Tem ssd: ");
        this.ssd = ler.nextBoolean();
        ler.close();
    }

    public void copiar(computador outro){
        this.processador = outro.getProcessador();
        this.placaVideo = outro.getPlacaVideo();
        this.ram = outro.getRam();
        this.ssd = outro.isSsd();
    }

    public void imprimirPc(){
        System.out.println("---------------Configuração---------------");
        System.out.println("Processador: " + this.processador);
        System.out.println("Placa de Video: " + this.placaVideo);
        System.out.println("Memória ram: " + this.ram + "gb");
        System.out.println("Tem ssd: " + this.ssd);
        System.out.println("-------------------------------------------");
    }

    @Override
    public String toString(){
        String aux = "\n---------------Configuração---------------"+"\nProcessador: " + this.processador +"\nPlaca de Video: " + this.placaVideo +"\nMemória ram: " + this.ram + "gb"+"\nTem ssd: " + this.ssd +"\n-------------------------------------------";
        return aux;
    }


    /*funções extra */

}
