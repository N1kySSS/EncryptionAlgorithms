package OIB;

import java.util.Scanner;

public class Lab_2 {
    private static final String[] alf = new String[]        {".", ",", " ", "ё", "й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю"};
    private static final String[][] contyr = new String[][]{{"!", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "`", "[", "]", ";", "'", "<", ">", "?", "/", "|", "й", "у", "к", "е", "ё", "ц", "г", "ш", "н", "ъ", "ф", "ы", "в", "а", "щ", "ж", "о", "с", "х", "я", "п", "ч", "л", "з", "д", "э", "р", "т", "ь", "ю", "б", "м", "и"},
                                                            {"1", "2", "6", "7", "8", "9", "0", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "=", "№", "{", "}", "к", "ь", "а", "д", "е", "ф", "л", "ч", "ш", "о", "ж", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "3", "4", "5", "<", ">", ";", ":", "'"},
                                                            {"2", "1", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Вы хотите расшифровать или зашифровать ваше сообщение ? \n> ");
        String action = sc.nextLine().replace(" ", "");
        System.out.println("Введите ваше сообщение. ");
        if (action.equals("зашифровать")) {
            System.out.println("Cостоящее из следующего алфавита: ");
            for (String b : alf) System.out.print(b);
            System.out.println();
        }
        System.out.print("> ");
        String[] message = sc.nextLine().split("");

        System.out.println("Контур:");
        for (String[] c : contyr){
            for (String b : c) System.out.print(b);
            System.out.println();
        }

        System.out.println();
        if (action.equalsIgnoreCase("расшифровать")) {
            System.out.println("Ваше сообщение: " + toDecode(message));
        } else if (action.equalsIgnoreCase("зашифровать")) {
            System.out.println("Ваше сообщение: " + toEncrypt(message));
        } else System.out.println("Я не понял, что вы хотите сделать");
    }

    public static String toDecode(String[] text) {
        String end = "";
        int count = 0;
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(contyr[count][j])) {
                    end += alf[j];
                    count++;
                    if (count == 3) count = 0;
                    break;
                }
            }
        }
        return end;
    }

    public static String toEncrypt(String[] text) {
        String end = "";
        int count = 0;
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(alf[j])) {
                    end += contyr[count][j];
                    count++;
                    if (count == 3) count = 0;
                    break;
                }
            }
        }
        return end;
    }
}