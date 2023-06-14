package mainPack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        SelectionSortVetorAleatorio();
//        SelectionSortVetorQuaseOrdenado();
//        SelectionSortVetorInversamenteOrdenado();

        InsertionSortVetorAleatorio();
//        InsertionSortVetorQuaseOrdenado();
//        InsertionSortVetorInversamenteOrdenado();

//        QuickSortVetorAleatorio();
//        QuickSortVetorQuaseOrdenado();
//        QuickSortVetorInversamenteOrdenado();

//        BubbleSortVetorAleatorio();
//        BubbleSortVetorQuaseOrdenado();
//        BubbleSortVetorInversamenteOrdenado();

//        MergeSortVetorAleatorio();
//        MergeSortVetorQuaseOrdenado();
//        MergeSortVetorInversamenteOrdenado();

//        HeapSortVetorAleatorio();
//        HeapSortVetorVetorQuaseOrdenado();
//        HeapSortVetorInversamenteOrdenado();

    }

    /*Quick Sort*/
    public static void QuickSortVetorQuaseOrdenado() {
        int vetor1[] = new int[1000];
        for (int i = 0; i < 100; i++) {
            vetor1[i] = (int) (Math.random() * 1000);
        }
        for (int j = 99; j < vetor1.length; j++) {
            vetor1[j] = j;
        }
        System.out.println("Vetor 10% aleatório antes da ordenação: ");
        for (int j = 0; j < vetor1.length; j++) {
            System.out.print(vetor1[j] + ", ");
        }
        System.out.println("Vetor 10% aleatório depois da ordenação: ");
        ordenarVetorDeInteiros(vetor1);
        imprimirVetor(vetor1);
    }

    public static void QuickSortVetorAleatorio() {
        // Vetor 2, totalmente aleatório
        int vetor2[] = new int[1000];
        for (int i = 0; i < vetor2.length; i++) {
            vetor2[i] = (int) (Math.random() * vetor2.length);
        }
        System.out.println("Vetor totalmente aleatório antes da ordenação: ");
        for (int j = 0; j < vetor2.length; j++) {
            System.out.print(vetor2[j] + " ");
        }
        System.out.println("\nVetor totalmente aleatório depois da ordenação: ");
        ordenarVetorDeInteiros(vetor2);
        imprimirVetor(vetor2);
    }

    public static void QuickSortVetorInversamenteOrdenado() {
        // Vetor 3, inversamente ordenado
        int[] arrayInverso = new int[1000];

        for (int i = 0, j = arrayInverso.length; i < arrayInverso.length; i++, j--) {
            arrayInverso[i] = j;
        }
        System.out.println("Vetor Inversamente ordenado antes da ordenação: ");
        for (int j = 0; j < arrayInverso.length; j++) {
            System.out.print(arrayInverso[j] + " ");
        }
        System.out.println("\nVetor Inversamente ordenado antes da ordenação: ");
        ordenarVetorDeInteiros(arrayInverso);
        imprimirVetor(arrayInverso);
    }

    private static int comparacoes;
    private static int trocas;

    public static void ordenarVetorDeInteiros(int[] vetor) {
        comparacoes = 0;
        trocas = 0;
        long startTime = System.currentTimeMillis();
        quickSort(vetor, 0, vetor.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");

    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (fim > inicio) {
            int indexPivo = dividir(vetor, inicio, fim);
            quickSort(vetor, inicio, indexPivo - 1);
            quickSort(vetor, indexPivo + 1, fim);
        }
    }

    private static int dividir(int[] vetor, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = vetor[inicio];

        while (pontEsq <= pontDir) {
            comparacoes++;

            while (pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
                pontEsq++;
                comparacoes++;
            }

            while (pontDir >= pontEsq && vetor[pontDir] > pivo) {
                pontDir--;
                comparacoes++;
            }

            if (pontEsq < pontDir) {
                trocar(vetor, pontDir, pontEsq);
                pontEsq++;
                pontDir--;
            }
        }
        trocar(vetor, inicio, pontDir);
        return pontDir;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        trocas++;
    }

    private static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }


    /*Select Sort*/
    public static void SelectionSortVetorAleatorio() {
        Random random = new Random();
        int numComparacoesChaves = 0;
        int numMovimentacoesRegistro = 0;

        //Escolher tamanho do array
        int[] vetor = new int[1000];

        int quantidadeEmbaralhar = (int) (vetor.length * 0.1);

        // Preencher vetor aleatoriamente
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);

        }
        // Desordenado
        System.out.println("Desordenado: ");
        for (int i = 0; i < vetor.length; i++) {

            System.out.print(vetor[i] + ", ");

        }
        System.out.println("");

        long startTime = System.currentTimeMillis();
        //SelectionSort rodando
        int posicaoMenor;
        int aux;
        for (int i = 0; i < vetor.length; i++) {
            posicaoMenor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                numComparacoesChaves++;
                if (vetor[posicaoMenor] > vetor[j]) {
                    numMovimentacoesRegistro++;
                    posicaoMenor = j;
                }
            }
            //Trocando os valores de lugar
            aux = vetor[posicaoMenor];
            vetor[posicaoMenor] = vetor[i];
            vetor[i] = aux;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("");

        // Desordenado
        System.out.println("Ordenado: ");
        for (int i = 0; i < vetor.length; i++) {

            System.out.print(vetor[i] + ", ");
        }
        System.out.println("");
        System.out.println("Numero de comparações de chaves: " + numComparacoesChaves);
        System.out.println("Numero de movimentações de registros: " + numMovimentacoesRegistro);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void SelectionSortVetorQuaseOrdenado() {
        Random random = new Random();
        int numComparacoesChaves = 0;
        int numMovimentacoesRegistro = 0;

        int[] vetorDezMil = new int[1000];

        int quantidadeEmbaralhar = (int) (vetorDezMil.length * 0.1);

        //Preencher vetor na ordem
        for (int i = 0; i < vetorDezMil.length; i++) {
            vetorDezMil[i] = i;
        }

        //Embaralhar 10% do vetor
        for (int i = 0; i < quantidadeEmbaralhar; i++) {
            int indiceAtual = i;
            int indiceAleatorio = random.nextInt(vetorDezMil.length);
            int temp = vetorDezMil[indiceAtual];
            vetorDezMil[indiceAtual] = vetorDezMil[indiceAleatorio];
            vetorDezMil[indiceAleatorio] = temp;
        }

        // Desordenado
        System.out.println("Desordenado: ");
        for (int i = 0; i < vetorDezMil.length; i++) {

            System.out.print(vetorDezMil[i] + ", ");

        }
        System.out.println("");

        long startTime = System.currentTimeMillis();
        //SelectionSort
        int posicaoMenor;
        int aux;
        for (int i = 0; i < vetorDezMil.length; i++) {
            posicaoMenor = i;
            for (int j = i + 1; j < vetorDezMil.length; j++) {
                numComparacoesChaves++;
                if (vetorDezMil[posicaoMenor] > vetorDezMil[j]) {
                    numMovimentacoesRegistro++;
                    posicaoMenor = j;
                }

            }
            //Trocando os valores de lugar

            aux = vetorDezMil[posicaoMenor];
            vetorDezMil[posicaoMenor] = vetorDezMil[i];
            vetorDezMil[i] = aux;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("");

        // Ordenado
        System.out.println("Ordenado: ");
        for (int i = 0; i < vetorDezMil.length; i++) {

            System.out.print(vetorDezMil[i] + ", ");
        }
        System.out.println("");
        System.out.println("Numero de comparações de chaves: " + numComparacoesChaves);
        System.out.println("Numero de movimentações de registros: " + numMovimentacoesRegistro);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void SelectionSortVetorInversamenteOrdenado() {
        Random random = new Random();
        int numComparacoesChaves = 0;
        int numMovimentacoesRegistro = 0;

        int[] vetorCemMil = new int[1000];
        int quantidadeEmbaralhar = (int) (vetorCemMil.length * 0.1);


        //Preencher vetor inversamente ordenado
        for (int i = 0, j = vetorCemMil.length; i < vetorCemMil.length; i++, j--) {
            vetorCemMil[i] = j;

        }

        System.out.println("Desordenado: ");
        for (int i = 0; i < vetorCemMil.length; i++) {

            System.out.print(vetorCemMil[i] + ", ");

        }
        System.out.println("");


        long startTime = System.currentTimeMillis();
        //SelectionSort
        int posicaoMenor;
        int aux;
        for (int i = 0; i < vetorCemMil.length; i++) {
            posicaoMenor = i;
            for (int j = i + 1; j < vetorCemMil.length; j++) {
                numComparacoesChaves++;
                if (vetorCemMil[posicaoMenor] > vetorCemMil[j]) {
                    numMovimentacoesRegistro++;
                    posicaoMenor = j;
                }
            }
            //Trocando os valores de lugar

            aux = vetorCemMil[posicaoMenor];
            vetorCemMil[posicaoMenor] = vetorCemMil[i];
            vetorCemMil[i] = aux;

        }
        long endTime = System.currentTimeMillis();
        System.out.println("");


        System.out.println("Ordenado: ");
        for (int i = 0; i < vetorCemMil.length; i++) {

            System.out.print(vetorCemMil[i] + ", ");
        }
        System.out.println("");
        System.out.println("Numero de comparações de chaves: " + numComparacoesChaves);
        System.out.println("Numero de movimentações de registros: " + numMovimentacoesRegistro);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    /*Insertion Sort*/
    public static void InsertionSortVetorAleatorio() {
        int[] array = new int[1000];
        /*preencher array aleatorio*/
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);

        }
        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
        //var Aux
        int swampAux, j;
        //var de comparacao e movimentacaoes
        int comparacoes = 0;
        int movimentacoes = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            swampAux = array[i];
            /*J comeca uma posicao antes do i*/
            j = i - 1;

            /*J precisa decrementar por isso n pode ser menor igual q 0 e que o swampAux*/
            while (j >= 0 && array[j] > swampAux) {
                array[j + 1] = array[j];
                j--;

                comparacoes++;
                movimentacoes++;
            }
            /*atribuicao da posicao j + 1 ao swampAux*/
            array[j + 1] = swampAux;
            movimentacoes++;
        }

        long endTime = System.currentTimeMillis();


        System.out.println("Ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void InsertionSortVetorQuaseOrdenado() {
        // Escolher tamanho do array
        int[] array = new int[1000];

        // Preencher 10% do array com números aleatórios
        int dezPorcento = array.length / 10;
        for (int i = 0; i < dezPorcento; i++) {
            array[i] = (int) (Math.random() * array.length);
        }

        // Preencher o restante do array com valores sequenciais
        for (int i = dezPorcento; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");

        // Algoritmo de ordenação Insertion Sort
        int swapAux, j;

        //var de comparacao e movimentacaoes
        int comparacoes = 0;
        int movimentacoes = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            swapAux = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > swapAux) {
                array[j + 1] = array[j];
                j--;

                comparacoes++;
                movimentacoes++;
            }

            array[j + 1] = swapAux;
            movimentacoes++;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void InsertionSortVetorInversamenteOrdenado() {
        int[] array = new int[1000];
        int tamArray = array.length;

        int[] arrayInverso = new int[tamArray];
        int tamInverso = tamArray - 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;

        }

        System.out.println("----------------------------");
        for (int i = 0; i < array.length; i++) {
            arrayInverso[i] = array[tamInverso - i];

        }

        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(arrayInverso[i] + ", ");
        }
        System.out.println("");

        // Algoritmo de ordenação Insertion Sort
        int swapAux, j;

        //var de comparacao e movimentacaoes
        int comparacoes = 0;
        int movimentacoes = 0;

        long startTime = System.currentTimeMillis();


        for (int i = 1; i < array.length; i++) {
            swapAux = arrayInverso[i];
            j = i - 1;

            while (j >= 0 && arrayInverso[j] > swapAux) {
                arrayInverso[j + 1] = arrayInverso[j];
                j--;

                comparacoes++;
                movimentacoes++;
            }

            arrayInverso[j + 1] = swapAux;
            movimentacoes++;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println("");
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");


    }

    public static void BubbleSortVetorQuaseOrdenado() {
        // Vetor 1, 10% aleatório e o resto ordenado
        int vetor1[] = new int[10000];
        for (int i = 0; i < 100; i++) {
            vetor1[i] = (int) (Math.random() * 1000);
        }
        for (int j = 99; j < vetor1.length; j++) {
            vetor1[j] = j;
        }
        System.out.println("Vetor 1 antes da ordenação: ");
        for (int j = 0; j < vetor1.length; j++) {
            System.out.print(vetor1[j] + " , ");
        }
        System.out.println();
        long startTime = System.currentTimeMillis();
        int[] resultado = bubbleSort(vetor1);
        long endTime = System.currentTimeMillis();
        System.out.println("Vetor após ordenação: ");
        imprimirVetor(vetor1);
        System.out.println("Quantidade de comparações: " + resultado[0]);
        System.out.println("Quantidade de trocas: " + resultado[1]);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void BubbleSortVetorAleatorio() {
        // Vetor 2, totalmente aleatório
        int vetor2[] = new int[10000];
        for (int i = 0; i < vetor2.length; i++) {
            vetor2[i] = (int) (Math.random() * vetor2.length);
        }
        System.out.println("Vetor 2 antes da ordenação: ");
        for (int j = 0; j < vetor2.length; j++) {
            System.out.print(vetor2[j] + " ");
        }
        int[] resultado = bubbleSort(vetor2);
        System.out.println("\nVetor 2 ");
        long startTime = System.currentTimeMillis();
        bubbleSort(vetor2);
        long endTime = System.currentTimeMillis();
        imprimirVetor(vetor2);
        System.out.println("Quantidade de comparações: " + resultado[0]);
        System.out.println("Quantidade de trocas: " + resultado[1]);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void BubbleSortVetorInversamenteOrdenado() {
        // Vetor 3, inversamente ordenado

        int[] arrayInverso = new int[10000];
        for (int i = 0, j = arrayInverso.length; i < arrayInverso.length; i++, j--) {
            arrayInverso[i] = j;

        }
        System.out.println("Vetor 3 antes da ordenação: ");
        for (int j = 0; j < arrayInverso.length; j++) {
            System.out.print(arrayInverso[j] + " ");
        }
        int[] resultado = bubbleSort(arrayInverso);
        System.out.println("\nVetor 3");
        long startTime = System.currentTimeMillis();
        bubbleSort(arrayInverso);
        long endTime = System.currentTimeMillis();
        for (int i = 0; i < arrayInverso.length; i++) {
            System.out.print(arrayInverso[i] + " ");
        }
        System.out.println();
        System.out.println("Quantidade de comparações: " + resultado[0]);
        System.out.println("Quantidade de trocas: " + resultado[1]);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static int[] bubbleSort(int[] vetor) {


        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                }
            }
        }
        int[] resultado = {comparacoes, trocas};

        return resultado;
    }

    private static long comparisons = 0;
    private static long movements = 0;

    public static void MergeSortVetorAleatorio() {
        int array[] = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }
        System.out.println("Vetor antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " , ");
        }
        int n = array.length;
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, n - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Vetor antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " , ");
        }
        System.out.println("Quantidade de comparações: " + comparisons);
        System.out.println("Quantidade de trocas: " + movements);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");

    }

    public static void MergeSortVetorQuaseOrdenado() {
        int array[] = new int[10000];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        for (int j = 99; j < array.length; j++) {
            array[j] = j;
        }
        System.out.println("Vetor 1 antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " , ");
        }
        int n = array.length;
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, n - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Vetor antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " , ");
        }
        System.out.println("Quantidade de comparações: " + comparisons);
        System.out.println("Quantidade de trocas: " + movements);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void MergeSortVetorInversamenteOrdenado() {
        int[] array = new int[10000];
        for (int i = 0, j = array.length; i < array.length; i++, j--) {
            array[i] = j;
        }
        System.out.println("Vetor 3 antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        int n = array.length;
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, n - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Vetor antes da ordenação: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " , ");
        }
        System.out.println("Quantidade de comparações: " + comparisons);
        System.out.println("Quantidade de trocas: " + movements);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");

    }


    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {
        int[] tempArray = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end) {
            comparisons++;
            if (array[i] <= array[j]) {
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
            movements++;
        }

        while (i <= middle) {
            tempArray[k] = array[i];
            i++;
            k++;
            movements++;
        }
        while (j <= end) {
            tempArray[k] = array[j];
            j++;
            k++;
            movements++;
        }
        for (i = start; i <= end; i++) {
            array[i] = tempArray[i - start];
            movements++;
        }

    }
    /*HEAP SORT*/
    public static void HeapSortVetorAleatorio(){
        int [] array = new int[1000];

        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * array.length);

        }
        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        int n = array.length;

        /*nao se faz necessario percorrer o array td, metade -1*/
        for (int i = n/2 -1; i >= 0; i--){
            //array, posicao = n, posicao = i
            aplicarHeap(array,n,i);
        }

        long startTime = System.currentTimeMillis();

        for (int j = n -1; j > 0; j--){
            /*maior elemento pq a raiz vai esta no começo*/
            int swampAux = array[0];
            array[0] = array[j];
            array[j] = swampAux;

            aplicarHeap(array,j,0);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Ordenado");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }

        int comparacoes = 0;
        int movimentacoes = 0;

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                comparacoes++;
            }
            movimentacoes += 3;
            comparacoes += contarComparacoesHeap(array, n, i);
        }
        System.out.println("");
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }


    public static void HeapSortVetorVetorQuaseOrdenado() {
        int[] array = new int[10000];
        int dezPorcento = array.length / 10;

        // Preencher 10% do array com números aleatórios
        for (int i = 0; i < dezPorcento; i++) {
            array[i] = (int) (Math.random() * array.length);
        }

        // Preencher o restante do array com valores sequenciais
        for (int i = dezPorcento; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        int n = array.length;

        /*nao se faz necessario percorrer o array td, metade -1*/
        for (int i = n / 2 - 1; i >= 0; i--) {
            //array, posicao = n, posicao = i
            aplicarHeap(array, n, i);
        }
        long startTime = System.currentTimeMillis();

        for (int j = n - 1; j > 0; j--) {
            /*maior elemento pq a raiz vai esta no começo*/
            int swampAux = array[0];
            array[0] = array[j];
            array[j] = swampAux;

            aplicarHeap(array, j, 0);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Ordenado");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }

        int comparacoes = 0;
        int movimentacoes = 0;

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                comparacoes++;
            }
            movimentacoes += 3;
            comparacoes += contarComparacoesHeap(array, n, i);
        }
        System.out.println("");
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    public static void HeapSortVetorInversamenteOrdenado() {
        int[] array = new int[1000];
        int tamArray = array.length;

        int[] arrayInverso = new int[tamArray];
        int tamInverso = tamArray - 1;

        for (int i = 0; i < array.length; i++) {
            array[i] =array.length - i;
        }

        System.out.println("Desordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");

        int n = array.length;

        /*nao se faz necessario percorrer o array td, metade -1*/
        for (int i = n / 2 - 1; i >= 0; i--) {
            //array, posicao = n, posicao = i
            aplicarHeap(array, n, i);
        }
        long startTime = System.currentTimeMillis();

        for (int j = n - 1; j > 0; j--) {
            /*maior elemento pq a raiz vai esta no começo*/
            int swampAux = array[0];
            array[0] = array[j];
            array[j] = swampAux;

            aplicarHeap(array, j, 0);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        //var de comparacao e movimentacaoes
        int comparacoes = 0;
        int movimentacoes = 0;

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                comparacoes++;
            }
            movimentacoes += 3;
            comparacoes += contarComparacoesHeap(array, n, i);
        }
        System.out.println("");
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de movimentações: " + movimentacoes);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }

    //array, posicao = n, posicao = i
    private static void aplicarHeap(int[] array, int n, int i) {
        int raiz = i;
        //filho a esquerda
        int esquerda = 2 * i + 1;
        //filha a direita
        int direita = 2 * i + 2;

        if (esquerda < n && array[esquerda] > array[raiz]) {
            raiz = esquerda;
        }
        if (direita < n && array[direita] > array[raiz]) {
            raiz = direita;
        }
        if (raiz != i) {
            /*troca*/
            int swampAux = array[i];
            array[i] = array[raiz];
            array[raiz] = swampAux;

            /*usando recursividade*/
            aplicarHeap(array, n, raiz);
        }
    }

    private static int contarComparacoesHeap(int[] array, int n, int i) {
        int comparacoes = 0;
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n) {
            comparacoes++;
            if (array[esquerda] > array[raiz]) {
                raiz = esquerda;
            }
        }
        if (direita < n) {
            comparacoes++;
            if (array[direita] > array[raiz]) {
                raiz = direita;
            }
        }
        if (raiz != i) {
            comparacoes++;
            comparacoes += contarComparacoesHeap(array, n, raiz);
        }
        return comparacoes;
    }
}
