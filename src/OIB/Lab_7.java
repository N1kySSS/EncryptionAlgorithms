package OIB;

import java.util.Scanner;

public class Lab_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите ваше сообщение: ");
        System.out.print("> ");
        String message = sc.nextLine();

        System.out.println("Введите ключ: ");
        System.out.print("> ");
        char[] key = sc.nextLine().toCharArray();

        String end = encryptDecrypt(message, key);
        System.out.print("Ваше итоговое сообщение: ");
        System.out.println("\"" + end + "\"");
    }

    private static String encryptDecrypt(String message, char[] key) {
        String end = "";

        for (int i = 0; i < message.length(); i++) {
            end += ((char) (message.charAt(i) ^ (key[i % key.length] + 32)));
        }

        return end;
    }
}