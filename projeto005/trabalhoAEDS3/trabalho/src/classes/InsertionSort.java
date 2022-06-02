package classes;

import java.time.LocalTime;

public class InsertionSort {
    private LocalTime tempoInicial;
    private LocalTime tempoFinal;
    private int contAcesso=0;
    private int contTroca=0;
    private int contComp=0;
    
    public InsertionSort(int vetor[], int n){
        
    }

    public void insertionSort(int desordenado[], int aux) {
        tempoInicial = LocalTime.now();

        for (int n = 1; n < aux; n++) {
            int key = desordenado[n];
            int ttt = n - 1;
            contAcesso++;
            while (ttt >= 0 && key < desordenado[ttt]) {
                contComp++;
                desordenado[ttt + 1] = desordenado[ttt];
                contAcesso+=3;
                --ttt;
            }
            desordenado[ttt + 1] = key;
            contTroca++;
            contAcesso++;
        }
        tempoFinal = LocalTime.now();
    }

    public void impConts(){
        System.out.println("Acesso: "+ this.contAcesso);
        System.out.println("Troca: " + this.contTroca);
        System.out.println("Comparação: " + this.contComp);
    }

    public void impTimer(){
        System.out.println("Timer: " + (tempoFinal.toNanoOfDay() - tempoInicial.toNanoOfDay())/1000000);
    }

}