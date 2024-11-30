package OIB;

import java.util.*;

public class Lab_5 {
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
            System.out.println("Ваше сообщение: \"" + toDecode(message, n, m, key) + "\"");
        } else if (action.equalsIgnoreCase("зашифровать")) {
            System.out.println("Ваше сообщение: \"" + toEncrypt(message, n, m, key) + "\"");
        } else System.out.println("Я не понял, что вы хотите сделать");
    }

    public static String toDecode(String[] text, int n, int m, ArrayList<Integer> key) {
        String end = "";
        int count = 0;
        String[][] table = new String[n][m];

        String[] promeg;
        String prom = "";
        for (int i = 0; i < n * m; i++) {
            prom += text[i];
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
            end += toDecode(text, n, m, key);
        }
        return end;
    }

    public static String toEncrypt(String[] text, int n, int m, ArrayList<Integer> key) {
        for (Integer k : key) {
            System.out.print(k + "\t");
        }
        System.out.println();

        String end = "";
        int count = 0;
        String[][] table = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text.length > count) table[i][j] = text[count++];
            }
        }

        for (String[] s : table) {
            for (String b : s) {
                if (b != null) System.out.print(b + "\t");
                else System.out.print("®" + "\t");
            }
            System.out.println();
        }
        System.out.println();

        count = 0;
        while (count != m) {
            for (int i = 0; i < n; i++) {
                if (table[i][key.indexOf(Collections.min(key))] != null) {
                    end += table[i][key.indexOf(Collections.min(key))];
                } else end += "®";
            }
            key.set(key.indexOf(Collections.min(key)), Collections.max(key) + 1);
            count++;
        }

        if (n * m < text.length) {
            String prom = "";
            for (int i = n * m; i < text.length; i++) {
                prom += text[i];
            }
            text = prom.split("");
            end += toEncrypt(text, n, m, key);
        }
        return end;
    }
}