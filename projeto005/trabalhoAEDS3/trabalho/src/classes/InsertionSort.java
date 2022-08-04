package classes;

public class InsertionSort {
    private int vetor[];
    private long tempo;
    private int contAcesso=0;
    private int contTroca=0;
    private int contComp=0;
    private int contInsercao=0;
    
    public InsertionSort(int vetor[], int n){
        this.vetor = vetores.copiarVetor(vetor, n); 
        this.tempo = System.nanoTime();
        insertionSort(this.vetor, n-1);
        this.tempo = System.nanoTime()-this.tempo;
    }

    public int getAcesso(){
        return this.contAcesso;
    }
    public int getTroca(){
        return this.contTroca;
    }
    public int getComp(){
        return this.contComp;
    }
    public int getInsercao(){
        return this.contInsercao;
    }
    public float getTempo(){
        return this.tempo/(float)1000000;
    }

    public void insertionSort(int desordenado[], int aux) {

        for (int n = 1; n < aux; n++) {
            int key = desordenado[n];
            int ttt = n - 1;
            contAcesso++;
            while (ttt >= 0 && key < desordenado[ttt]) {
                contComp++;
                desordenado[ttt + 1] = desordenado[ttt];
                contInsercao++;
                contAcesso+=3;
                --ttt;
            }
            desordenado[ttt + 1] = key;
            contInsercao++;
            contTroca++;
            contAcesso++;
        }
    }

}