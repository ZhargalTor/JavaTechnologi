//7. Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую.
//Торяшиев Жаргал Б763-2а

import java.util.Scanner;

void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        System.out.print("Введите систему счисления (2 8 16): ");
        int sis = scan.nextInt();
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        if (num == 0) {
            res = "0";
        } else {
            while (num > 0) {
                int per = num % sis;
                res = digits.charAt(per) + res;
                num = num / sis;
            }
        }
        System.out.println("Результат: " + res);
}
