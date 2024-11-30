package OIB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Вы хотите расшифровать или зашифровать ваше сообщение ? \n> ");
        String action = sc.nextLine().replace(" ", "");

        System.out.println("Введите ваше сообщение.");
        System.out.print("> ");
        String[] message = sc.nextLine().split("");

        System.out.println("Введите количество строк таблицы.");
        System.out.print("> ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Введите количество столбцов таблицы.");
        System.out.print("> ");
        int m = Integer.parseInt(sc.nextLine());

        System.out.println("Введите номера неиспользуемых ячеек в формате (n-n-...-n), где n - натуральное число");
        System.out.print("> ");
        String[] spaces = sc.nextLine().split("-");

        System.out.println("Введите ключ в формате (n-n-...-n), где n - натуральные числа. " +
                "Колчиство цифр должно совпадать с количеством столбцов.");
        System.out.print("> ");
        String[] notkey = sc.nextLine().split("-");

        while (notkey.length != m) {
            System.out.println("Колчиство цифр должно совпадать с количеством столбцов.");
            notkey = sc.nextLine().split("-");
        }

        ArrayList<Integer> key = new ArrayList<>();
        for (String s : notkey) {
            key.add(Integer.parseInt(s));
        }

        if (action.equalsIgnoreCase("расшифровать")) {
            System.out.println("Ваше сообщение: \"" + toDecode(message, n, m, key, spaces) + "\"");
        } else if (action.equalsIgnoreCase("зашифровать")) {
            System.out.println("Ваше сообщение: \"" + toEncrypt(message, n, m, key, spaces) + "\"");
        } else System.out.println("Я не понял, что вы хотите сделать");
    }

    public static String toDecode(String[] text, int n, int m, ArrayList<Integer> key, String[] spaces) {
        String end = "";
        int count = 0;
        String[][] table = new String[n][m];

        String[] promeg;
        String prom = "";
        for (int i = 0, k = 0; i < n * m; i++) {
            if (k < text.length) prom += text[i];
            else break;
            k++;
        }
        promeg = prom.split("");

        for (String s : promeg) {
            while (count < n) {
                table[count][key.indexOf(Collections.min(key))] = s;
                count++;
                if (count == n) {
                    count = 0;
                    key.set(key.indexOf(Collections.min(key)), Collections.max(key) + 1);
                }
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!table[i][j].equals("®")) end += table[i][j];
            }
        }

        if (n * m < text.length) {
            prom = "";
            for (int i = n * m; i < text.length; i++) {
                prom += text[i];
            }
            text = prom.split("");
            end += toDecode(text, n, m, key, spaces);
        }
        return end;
    }

    public static String toEncrypt(String[] text, int n, int m, ArrayList<Integer> key, String[] spaces) {
        for (Integer k : key) {
            System.out.print(k + "\t");
        }
        System.out.println();

        String end = "";
        int count = 0;
        int schet = 0;
        int spcount = 0;
        int flag;
        String[][] table = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag = 0;
                for (String s : spaces) {
                    if (schet == Integer.parseInt(s)) {
                        flag = 1;
                        spcount++;
                        break;
                    }
                }
                if (flag == 0 && text.length > count) table[i][j] = text[count++];
                else table[i][j] = "®";
                schet++;
            }
        }

        for (String[] s : table) {
            for (String b : s) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
        System.out.println();

        count = 0;
        while (count != m) {
            for (int i = 0; i < n; i++) {
                end += table[i][key.indexOf(Collections.min(key))];
            }
            key.set(key.indexOf(Collections.min(key)), Collections.max(key) + 1);
            count++;
        }

        if (n * m < (text.length + spcount)) {
            String prom = "";
            for (int i = n * m - spcount; i < text.length; i++) {
                prom += text[i];
            }
            text = prom.split("");
            end += toEncrypt(text, n, m, key, spaces);
        }
        return end;
    }
}