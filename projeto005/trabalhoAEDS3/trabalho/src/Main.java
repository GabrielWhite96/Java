import classes.InsertionSort;
import classes.MergeSort;
import classes.QuickSort;
import classes.vetores;


public class Main {
    public static void main(String[] args){ 
    
        int v[] = new int[30000];
        vetores.preencheVetor(v);
        
        InsertionSort auxix = new InsertionSort(v, 5000);
        MergeSort auxmx = new MergeSort(v, 5000);
        QuickSort auxqx = new QuickSort(v, 5000);
        
        InsertionSort auxiy = new InsertionSort(v, 10000);
        MergeSort auxmy = new MergeSort(v, 10000);
        QuickSort auxqy = new QuickSort(v, 10000);
        
        InsertionSort auxiz = new InsertionSort(v, 30000);
        MergeSort auxmz = new MergeSort(v, 30000);
        QuickSort auxqz = new QuickSort(v, 30000);
        
        System.out.println("/**************************************************************");
        System.out.println("* Aluno: Gabriel Fernandes, Lucas Sila                        *");
        System.out.println("* Matricula: 2021008766,                                      *");
        System.out.println("* Curso: Ciencia da Computacao                                *");
        System.out.println("* 1º Trabalho Pratico -- Ordenacao Interna                    *");
        System.out.println("* DCC288 -- 2022 -- IFSEMG, 3o.                               *");
        System.out.println("* Prof. Flavio Augusto de Freitas                             *");
        System.out.println("* Compilador: Visual Studio Code                              *");
        System.out.println("* Sistema Operacional: Windows 11                             *");
        System.out.println("***************************************************************");
        System.out.print("\nVetores Desordenados: ");
        vetores.imprimeVetor(v, 20);
        System.out.print("Vetores Ordenados:    ");
        InsertionSort aux = new InsertionSort(v, 20);
        aux.insertionSort(v, 20);
        vetores.imprimeVetor(v, 20);
    }
}