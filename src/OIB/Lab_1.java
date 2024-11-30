package OIB;

import java.util.Scanner;

public class Lab_1 {
    private static final String[] alf = new String[]{"Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю", ".", ",", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "ё", "й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Вы хотите расшифровать или зашифровать ваше сообщение ? \n> ");
        String action = sc.nextLine().replace(" ", "");
        System.out.println("Введите ваше сообщение. ");
        if (action.equals("зашифровать")) {
            System.out.println("Cостоящее из следующего алфавита: ");
            for (String s : alf) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.print("> ");
        String[] message = sc.nextLine().split("");
        System.out.print("Введите ключ (целое число больше 0 и меньше 79) \n> ");
        int key = Integer.parseInt(sc.nextLine());

        while (key < 1 || key  > 78) {
            System.out.println("Введите нормальное число! \n> ");
            key = Integer.parseInt(sc.nextLine());
        }

        if (action.equalsIgnoreCase("расшифровать")) {
            System.out.println("Ваше сообщение: " + toDecode(message, key));
        } else if (action.equalsIgnoreCase("зашифровать")) {
            System.out.println("Ваше сообщение: " + toEncrypt(message, key));
        } else System.out.println("Я не понял, что вы хотите сделать");
    }

    public static String toDecode(String[] text, int key) {
        String end = "";
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(alf[j]) && (j - key) >= 0) {
                    end += alf[j - key];
                    break;
                } else if (s.equals(alf[j]) && (j - key) < 0) {
                    end += alf[j - key + alf.length];
                    break;
                }
            }
        }
        return end;
    }

    public static String toEncrypt(String[] text, int key) {
        String end = "";
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(alf[j]) && (j + key) < alf.length) {
                    end += alf[j + key];
                    break;
                } else if (s.equals(alf[j]) && (j + key) >= alf.length) {
                    end += alf[j + key - alf.length];
                    break;
                }
            }
        }
        return end;
    }
}