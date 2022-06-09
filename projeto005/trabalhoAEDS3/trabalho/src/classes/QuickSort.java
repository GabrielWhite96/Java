package classes;

public class QuickSort {
  private int vetor[];
  private long tempo;
  private int contAcesso=0;
  private int contTroca=0;
  private int contComp=0;
  private int contPivo=0;
  
  public QuickSort(int vetor[], int n){
    this.vetor = vetores.copiarVetor(vetor, n); 
    this.tempo = System.nanoTime();
    quickSort(this.vetor,0 , n-1);
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
public int getPivo(){
  return this.contPivo;
}
public float getTempo(){
  return this.tempo/(float)1000000;
}

  public int partition(int array[], int low, int high) {
    int pivot = array[high];
    contPivo++;
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        contTroca++;
        contAcesso+=5;
      }
      contComp++;
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return (i + 1);
  }
  
  public void quickSort(int array[], int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }

}

