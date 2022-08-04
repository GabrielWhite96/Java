package classes;

import java.util.Random;

public class vetores {
    //construtor
    public static void preencheVetor(int vetor[]){
        Random r = new Random();
        for(int i=0; i <=29999; i++){
            vetor[i] = r.nextInt(30000);
        }
    }

    public static int[] copiarVetor(int vetor2[], int n){
        int vetor[] = new int[n];
        for(int i=0; i < n; i++){
            vetor[i] = vetor2[i];
        }
        return vetor;
    }

    public static void imprimeVetor(int vetor[], int n){
        System.out.print("[");
        for(int i=0; i<n; i++){
            System.out.print(vetor[i]);
            if(i!=n-1){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
}
