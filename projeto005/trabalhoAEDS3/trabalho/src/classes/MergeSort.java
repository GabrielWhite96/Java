package classes;

public class MergeSort {
    private int vetor[];
    private long tempo;
    private int contAcesso=0;
    private int contTroca=0;
    private int contComp=0;

    public MergeSort(int vetor[], int n){
        this.vetor = vetores.copiarVetor(vetor, n); 
        this.tempo = System.nanoTime();
        mergeSort(this.vetor,0 , n-1);
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
    public float getTempo(){
        return this.tempo/(float)1000000;
    }
    
    public void merge(int aux[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = aux[p + i];
            contTroca++;
            contAcesso++;
            for (int j = 0; j < n2; j++)
            M[j] = aux[q + 1 + j];
            contTroca++;
            contAcesso++;

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            contComp+=2;
            if (L[i] <= M[j]) {
                aux[k] = L[i];
                contTroca++;
                contAcesso++;
                contComp++;
                i++;
            } else {
                aux[k] = M[j];
                contTroca++;
                contAcesso++;
                contComp++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            aux[k] = L[i];
            contTroca++;
            contAcesso++;
            contComp++;
            i++;
            k++;
        }

        while (j < n2) {
            aux[k] = M[j];
            contTroca++;
            contAcesso++;
            contComp++;
            j++;
            k++;
        }
    }

    public void mergeSort(int aux[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(aux, l, m);
            mergeSort(aux, m + 1, r);
            merge(aux, l, m, r);
        }
    }
}
