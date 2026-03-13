package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Caesar caesar = new Caesar();

        System.out.print("Введите текст для шифровки методом Цезаря: ");
        String text = sc.nextLine();

        System.out.print("Введите ключ для шифровки: ");
        int key = Integer.parseInt(sc.nextLine());

        String encrypted = caesar.encrypt(text, key);
        System.out.println("Зашифрованный текст: " + encrypted);

        System.out.print("Введите текст для расшифровки методом Цезаря: ");
        String text2 = sc.nextLine();

        System.out.print("Введите ключ для расшифровки: ");
        int key2 = Integer.parseInt(sc.nextLine());

        String decrypted = caesar.decrypt(text2, key2);
        System.out.println("Расшифрованный текст: " + decrypted);
    }
}