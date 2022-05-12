import java.util.Random;
//import java.util.Arrays;
import classes.InsertionSort;
import classes.MergeSort;
import classes.QuickSort;


public class Main {
    public static void main(String[] args){
        /*int n1[] = new int[5000];
        Random r = new Random();
        for(int i=0; i <=4999; i++){
            n1[i] = r.nextInt(5000);
        }
        for(int i=0; i <=4999; i++)System.out.println(n1[i]);*/

        /*int auxq1 = n1.length;
        QuickSort.quickSort(n1, 0, auxq1 - 1);
        for (int i = 0; i < n1.length; ++i) System.out.print(n1[i] + ", ");

        MergeSort auxm1 = new MergeSort();
        auxm1.mergeSort(n1, 0, n1.length - 1);
        for (int i = 0; i < n1.length; ++i) System.out.print(n1[i] + ", ");*/

        /*InsertionSort auxi1 = new InsertionSort();
        auxi1.insertionSort(n1);
        for (int i = 0; i < n1.length; ++i) System.out.print(n1[i] + ", ");*/
        


        /*int n2[] = new int[10000];
        Random r2 = new Random();
        for(int i=0; i <=9999; i++){
            n2[i] = r2.nextInt(10000);
        }
        for(int i=0; i <=9999; i++)System.out.println(n2[i]);

        int auxq2 = n2.length;
        QuickSort.quickSort(n2, 0, auxq2 - 1);
        for (int i = 0; i < n2.length; ++i) System.out.print(n2[i] + ", ");

        MergeSort auxm2 = new MergeSort();
        auxm2.mergeSort(n2, 0, n2.length - 1);
        for (int i = 0; i < n2.length; ++i) System.out.print(n2[i] + ", ");

        InsertionSort auxi2 = new InsertionSort();
        auxi2.insertionSort(n2);
        for (int i = 0; i < n2.length; ++i) System.out.print(n2[i] + ", ");
        */


        
        int n3[] = new int[30000];
        Random r3 = new Random();
        for(int i=0; i <=29999; i++){
            n3[i] = r3.nextInt(30000);
        }
        //for(int i=0; i <=29999; i++)System.out.println(n3[i]);
        
        InsertionSort auxi3 = new InsertionSort();
        auxi3.insertionSort(n3);
        auxi3.impConts();
        auxi3.impTimer();
        System.out.println("-------------------------------------------------------------------------");
        
        MergeSort auxm3 = new MergeSort();
        auxm3.mergeSort(n3, 0, n3.length - 1);
        auxm3.impConts();
        auxm3.impTimer();
        System.out.println("-------------------------------------------------------------------------");
        
        QuickSort auxq3 = new QuickSort();
        auxq3.quickSort(n3, 0, n3.length - 1);
        auxq3.impConts();
        auxq3.impTimer();
        System.out.println("-------------------------------------------------------------------------");
        
        //int tst[] = { 7, 6, 4, 2, 9, 8, 3, 5};

        /*InsertionSort auxi1 = new InsertionSort();
        auxi1.insertionSort(tst);
        for (int i = 0; i < tst.length; ++i) System.out.print(tst[i] + ", ");*/

        /*MergeSort auxm3 = new MergeSort();
        auxm3.mergeSort(tst, 0, tst.length - 1);
        auxm3.impConts();
        for (int i = 0; i < tst.length; ++i) System.out.print(tst[i] + ", ");*/

        /*QuickSort auxq3 = new QuickSort();
        auxq3.quickSort(tst, 0, tst.length - 1);
        auxq3.impContsQ();
        for (int i = 0; i < tst.length; ++i) System.out.print(tst[i] + ", ");*/
        
        




    
    
    
    
    
    /*
        System.out.println("/***************************************************************");
        System.out.println("* Aluno: Gabriel Fernandes Vieira de Paula                    *");
        System.out.println("* Matricula: 2021008766                                       *");
        System.out.println("* Curso: Ciencia da Computacao                                *");
        System.out.println("* 1º Trabalho Pratico -- Ordenacao Interna                    *");
        System.out.println("* DCC288 -- 2022 -- IFSEMG, 3o.                               *");
        System.out.println("* Prof. Flavio Augusto de Freitas                             *");
        System.out.println("* Compilador: Visual Studio Code                              *");
        System.out.println("* Sistema Operacional: Windows 11                             *");
        System.out.println("***************************************************************");
    */

    /*int aux[] = { 6, 5, 12, 10, 9, 1 };
    MergeSort ob = new MergeSort();
    ob.mergeSort(aux, 0, aux.length - 1);
    System.out.println("Sorted array:");
    printArray(aux);*/

    /*int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;
    QuickSort.quickSort(data, 0, size - 1);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));*/

    }
}