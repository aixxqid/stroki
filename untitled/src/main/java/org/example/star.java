package org.example;

import java.util.Scanner;

public class star {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите номер задания: ");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                put();
                break;
            default:
                System.out.print("Чета ты многовато. Давайте поменьше !!!!!");
        }
    }


    public static  void put () {
        System.out.println("Вы выполняете задание №5");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String n = scanner.nextLine();
        String res = reverse(n);
    }
    public static String reverse(String n) {
        String[] words = "\\s+".split(n);
        StringBuilder revers = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            revers.append(words[i]);
            if (i > 0) {
                revers.append(" ");
            }
        }
        return revers.toString();
    }



}
