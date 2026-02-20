//7. Повернуть матрицу на 90, 180 или 270 градусов против часовой стрелки.
//Торяшиев Жаргал Б763-2а

import java.util.Scanner;

void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите размер матрицы n: ");
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];

        System.out.println("Заполните матрицу:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }

        System.out.print("Введите угол поворота(90, 180, 270): ");
        int ug = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ug == 90) {
                    b[n - 1 - j][i] = a[i][j];
                } else if (ug == 180) {
                    b[n - 1 - i][n - 1 - j] = a[i][j];
                } else if (ug == 270) {
                    b[j][n - 1 - i] = a[i][j];
                }
            }
        }

        System.out.println("Результат:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
}
