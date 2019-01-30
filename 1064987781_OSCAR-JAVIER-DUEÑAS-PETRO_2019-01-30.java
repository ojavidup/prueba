package prueba.tecnica;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PruebaTecnica {

    public static void main(String[] args) {

        Matriz obj = new Matriz();
        Scanner entrada = new Scanner(System.in);
        int N, M;

        System.out.print("Ingrese el numero de filas de la matriz: ");
        N = entrada.nextInt();

        System.out.print("Ingrese el numero de columnas de la matriz: ");
        M = entrada.nextInt();

        obj.crearMatriz(N, M);
    }
}

class Matriz {

    public void crearMatriz(int N, int M) {

        int matriz[][] = new int[N][M];
        double sum = 0;
        int colTotal = 0;
        int colNum = 0;
        int con = 0;
        int l = 0;

        int[] numbers = randomNumbers(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = numbers[l++];
            }
        }
        
        System.out.println("====Matriz creada====");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        for (int j = 1; j < M; j++) {
            if ((j % 2) != 0) {
                for (int i = 0; i < N; i++) {
                    sum = sum + matriz[i][j];
                }
                colNum++;
            }
        }
        double prom = sum / colNum;
        System.out.println();
        System.out.println("promedio de totales de columnas pares= " + prom);

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                colTotal = colTotal + matriz[i][j];
            }

            if (colTotal > prom) {
                con++;
            }
            colTotal = 0;
        }
        System.out.println("Cantidad de columnas cuyo total es mayor que " + prom + "= " + con);

    }

    public static int[] randomNumbers(int N, int M) {

        Random ran = new Random();

        int can = N * M;
        int position = 0;
        int numberRan;
        boolean repeat;
        int numbers[] = new int[can];

        Arrays.fill(numbers, can + 1);

        while (position < can) {

            numberRan = ran.nextInt(can) + 1;
            repeat = false;

            for (int i = 0; i < numbers.length && !repeat; i++) {
                if (numberRan == numbers[i]) {
                    repeat = true;
                }
            }

            if (!repeat) {
                numbers[position++] = numberRan;
            }
        }
        return numbers;
    }
}
