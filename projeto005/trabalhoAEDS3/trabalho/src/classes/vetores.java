package classes;

import java.util.Random;

public class vetores {
    //atributos
    private int vetor[];
    private int n;
    private Random r;

    //construtor
    public vetores(){
        this.vetor = new int[30000];
        this.r = new Random();
        for(int i=0; i <=29999; i++){
            vetor[i] = r.nextInt(30000);
        }
    }

    public void copiarVetor(int vetor2[], int n){
        for(int i=0; i < n; i++){
            vetor[i] = vetor2[i];
        }
    }

    public void imprimeVetor(int vetor[], int n){
        for(int i=0; i<=29999; i++){
            System.out.println(vetor[i]);
        }
    }

    ordenaVetorInsertionSort(int vetor[], int n){

    }

    ordenaVetorMergeSort(int vetor[], int n){

    }

    ordenaVetorQuickSort(int vetor[], int n){

    }

    imprimeResultados(){

    }
}
