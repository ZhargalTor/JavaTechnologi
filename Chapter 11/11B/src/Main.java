/*
7. Во входном файле хранятся две разреженные матрицы — А и В. Построить
        циклически связанные списки СА и СВ, содержащие ненулевые элементы
        соответственно матриц А и В. Просматривая списки, вычислить: а) сумму
        S = A + B; б) произведение P = A × B.
ТОРЯШИЕВ ЖАРГАЛ Б763-2А
*/


import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int row, col;
        double value;
        Node next;

        Node(int r, int c, double v) {
            row = r;
            col = c;
            value = v;
        }
    }

    static Node createList(double[][] matrix) {
        Node head = null, prev = null;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    Node node = new Node(i, j, matrix[i][j]);

                    if (head == null) {
                        head = node;
                    } else {
                        prev.next = node;
                    }
                    prev = node;
                }
            }
        }

        if (prev != null) {
            prev.next = head;
        }

        return head;
    }

    static double[][] add(double[][] A, double[][] B) {
        int n = A.length, m = A[0].length;
        double[][] S = new double[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                S[i][j] = A[i][j] + B[i][j];

        return S;
    }

    static double[][] multiply(double[][] A, double[][] B) {
        int n = A.length, m = B[0].length, k = A[0].length;
        double[][] P = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t < k; t++) {
                    P[i][j] += A[i][t] * B[t][j];
                }
            }
        }

        return P;
    }

    static void printMatrix(double[][] M) {
        for (double[] row : M) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        try {
            System.out.print("Введите имя входного файла: ");
            String fileName = console.nextLine();

            Scanner sc = new Scanner(new File(fileName));

            int n = sc.nextInt(), m = sc.nextInt();
            double[][] A = new double[n][m];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    A[i][j] = sc.nextDouble();

            int n2 = sc.nextInt(), m2 = sc.nextInt();
            double[][] B = new double[n2][m2];

            for (int i = 0; i < n2; i++)
                for (int j = 0; j < m2; j++)
                    B[i][j] = sc.nextDouble();

            sc.close();

            Node CA = createList(A);
            Node CB = createList(B);

            if (n == n2 && m == m2) {
                System.out.println("\nСумма S = A + B:");
                printMatrix(add(A, B));
            } else {
                System.out.println("\nСложение невозможно (разные размеры)");
            }

            if (m == n2) {
                System.out.println("\nПроизведение P = A * B:");
                printMatrix(multiply(A, B));
            } else {
                System.out.println("\nУмножение невозможно (несовместимые размеры)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}