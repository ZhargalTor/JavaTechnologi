import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    static final int SIZE = 5;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 12345);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true)
        ) {

            System.out.println("Подключение к серверу...");

            Scanner scanner = new Scanner(System.in);

            // Своё поле
            char[][] myField = createField();

            // Поле противника
            char[][] enemyField = createEmptyField();

            while (true) {

                System.out.println("\n========== ВАШЕ ПОЛЕ ==========");
                printField(myField);

                System.out.println("\n====== ПОЛЕ ПРОТИВНИКА ======");
                printField(enemyField);

                // ===== ХОД СЕРВЕРА =====
                System.out.println("\nОжидание хода противника...");

                String shot = in.readLine();

                if (shot.equals("ПОБЕДА")) {

                    System.out.println("\nВы победили!");

                    break;
                }

                String[] parts = shot.split(" ");

                int sr = Integer.parseInt(parts[0]) -1;
                int sc = Integer.parseInt(parts[1]) -1;

                String answer;

                if (myField[sr][sc] == 'S') {

                    myField[sr][sc] = 'X';

                    answer = "Попадание";

                    System.out.println("Противник попал!");

                } else {

                    answer = "Мимо";

                    System.out.println("Противник промахнулся!");
                }

                out.println(answer);

                // Проверка поражения
                if (allShipsDestroyed(myField)) {

                    System.out.println("\nВы проиграли!");

                    break;
                }

                // ===== ХОД КЛИЕНТА =====
                System.out.print("\nВаш ход (строка столбец): ");

                int r = scanner.nextInt() -1;
                int c = scanner.nextInt() -1;

                out.println((r + 1) + " " + (c + 1));

                String result = in.readLine();

                if (result.equals("Попадание")) {

                    enemyField[r][c] = 'X';

                } else {

                    enemyField[r][c] = 'O';
                }

                System.out.println("Результат: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Создание поля
    static char[][] createField() {

        char[][] field = new char[SIZE][SIZE];

        for (char[] row : field)
            Arrays.fill(row, '.');

        Random random = new Random();

        int ships = 5;

        while (ships > 0) {

            int r = random.nextInt(SIZE);
            int c = random.nextInt(SIZE);

            if (field[r][c] == '.') {

                field[r][c] = 'S';

                ships--;
            }
        }

        return field;
    }

    // Пустое поле противника
    static char[][] createEmptyField() {

        char[][] field = new char[SIZE][SIZE];

        for (char[] row : field)
            Arrays.fill(row, '?');

        return field;
    }

    // Печать поля
    static void printField(char[][] field) {

        System.out.print("  ");

        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {

            System.out.print((i + 1) + " ");

            for (int j = 0; j < SIZE; j++) {

                System.out.print(field[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Проверка уничтожения кораблей
    static boolean allShipsDestroyed(char[][] field) {

        for (char[] row : field) {

            for (char cell : row) {

                if (cell == 'S') {
                    return false;
                }
            }
        }

        return true;
    }
}