package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите номер задания: ");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                stroka1();
                break;
            case 2:
                vtoroe();
                break;
            case 3:
                three();
                break;
            case 4:
                four();
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;

            default:
                System.out.print("Чета ты многовато. Давайте поменьше !!!!!");
        }
    }

    public static void stroka1() {
        System.out.println("Ты делаешь задание №1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String slovo = scanner.nextLine();
        System.out.println("Введи слово/число повтора");
        String N = scanner.nextLine();
        try {
            String result = dop(slovo, N);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static String dop(String slovo, String N) {
        int n = Integer.parseInt(N);
        if (n == 0) {
            return "";
        }
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }

        return String.valueOf(slovo).repeat(n);
    }


    public static void vtoroe() {
        System.out.println("Вы выполняете задание №2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку: ");
        String one = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        String two = scanner.nextLine();
        try {
            int result = kolvo(one, two);
            System.out.println("Количество вхождений: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    public static int kolvo(String one, String two) { //кол-во вхождений
        if ((two == null) || two.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой или null.");
        }
        if (!one.contains(two)) {
            throw new IllegalArgumentException("Ошибка");
        }
        return one.length() - one.replace(String.valueOf(two), "").length();
    }

    public static void three() {
        System.out.println("Вы выполняете задание №3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String vxod = scanner.nextLine();
        String vixod = replaceNumbers(vxod); //заменить цифры
        System.out.println("Преобразованная строка: " + vixod);
    }

    public static String replaceNumbers(String vxod) {
        StringBuilder newStroka = new StringBuilder();
        if (vxod == null) return "";
        for (int i = 0; i < vxod.length(); i++) {
            char currentChar = vxod.charAt(i);
            switch (currentChar) {
                case '1':
                    newStroka.append("один");
                    break;
                case '2':
                    newStroka.append("два");
                    break;
                case '3':
                    newStroka.append("три");
                    break;
                default:
                    newStroka.append(currentChar);
            }
        }
        return newStroka.toString();
    }

    public static void four() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String stroka = scanner.nextLine();
        String res = delete(stroka);
        System.out.println("Результат: " + res);
    }

    public static String delete(String stroka) {
        StringBuilder sb = new StringBuilder(stroka);
        for (int i = 1; i < sb.length(); i++) {
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }

}
