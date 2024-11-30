package OIB;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab_4 {

    private static final String[] alf = new String[]{"Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю", ".", ",", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "ё", "й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Вы хотите расшифровать или зашифровать ваше сообщение ? \n> ");
        String action = sc.nextLine().replace(" ", "");

        System.out.println("Введите ваше сообщение ");
        if (action.equals("зашифровать")) {
            System.out.println("Cостоящее из следующего алфавита: ");
            for (String b : alf) System.out.print(b);
            System.out.println();
        }
        System.out.print("> ");
        String[] message = sc.nextLine().split("");

        System.out.print("Введите ключ (Любое слово или букву из алфавита, представленного выше) \n> ");
        String[] key = sc.nextLine().split("");

        if (action.equalsIgnoreCase("расшифровать")) {
            System.out.println("Ваше сообщение: " + toDecode(message, key));
        } else if (action.equalsIgnoreCase("зашифровать")) {
            System.out.println("Ваше сообщение: " + toEncrypt(message, key));
        } else System.out.println("Я не понял, что вы хотите сделать");
    }

    public static String toDecode(String[] text, String[] key) {
        ArrayList<Integer> indext = new ArrayList<>();
        for (String s : text) {
            for (int i = 0; i < alf.length; i++) {
                if (s.equals(alf[i])) {
                    indext.add(i);
                }
            }
        }
        ArrayList<Integer> indexk = new ArrayList<>();
        for (String k : key) {
            for (int j = 0; j < alf.length; j++) {
                if (k.equals(alf[j])) {
                    indexk.add(j);
                }
            }
        }
        String end = "";
        for (int i = 0; i < indexk.size(); i++) {
            if (indexk.size() < indext.size()) {
                indexk.add(indexk.get(i));
            }
        }
        for (int t : indext) {
            for (int k : indexk) {
                if (t - k >= 0) {
                    end += alf[t - k];
                } else end += alf[t + alf.length - k];
                indexk.remove(0);
                break;
            }
        }
        return end;
    }

    public static String toEncrypt(String[] text, String[] key) {
        ArrayList<Integer> indext = new ArrayList<>();
        for (String s : text) {
            for (int i = 0; i < alf.length; i++) {
                if (s.equals(alf[i])) {
                    indext.add(i);
                }
            }
        }
        ArrayList<Integer> indexk = new ArrayList<>();
        for (String k : key) {
            for (int j = 0; j < alf.length; j++) {
                if (k.equals(alf[j])) {
                    indexk.add(j);
                }
            }
        }
        String end = "";
        for (int i = 0; i < indexk.size(); i++) {
            if (indexk.size() < indext.size()) {
                indexk.add(indexk.get(i));
            }
        }
        for (int t : indext) {
            for (int k : indexk) {
                if (t + k <= alf.length) {
                    end += alf[t + k];
                } else end += alf[t + k - alf.length];
                indexk.remove(0);
                break;
            }
        }
        return end;
    }
}