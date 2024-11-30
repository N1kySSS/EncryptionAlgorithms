package OIB;

import java.util.Scanner;

public class Lab_3 {

    private static final String[] alf = new String[]{".", ",", " ", "ё", "й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю"};
    private static String[][] contyr1 = new String[][]{{"!", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "`", "[", "]", ";", "'", "<", ">", "?", "/", "|", "ю", "б", "ь", "т", "и", "м", "с", "ч", "я", "э", "ж", "д", "л", "о", "р", "п", "в", "а", "ы", "ф", "ё", "ъ", "х", "з", "щ", "ш", "г", "н", "е", "к", "у", "ц", "й"},
            {"1", "2", "6", "7", "8", "9", "0", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "=", "№", "{", "}", "к", "ь", "а", "д", "е", "ф", "л", "ч", "ш", "о", "ж", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "п", "р", "б", "в", "г", "и", "м", "с", "т"},
            {"q", "d", "t", "j", "y", "i", "o", "p", "n", "f", "й", "ф", "ы", "а", "щ", "е", "г", "д", "ю", "б", "м", "т", "h", "2", "8", "4", "6", "9", "0", "-", "|", "$", "{", "[", "*", ")", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "]", "}", "(", "1", "3", "5", "7"}};
    private static String[][] contyr2 = new String[][]{{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "[", "]", "{", "}", "(", ")", "+"},
            {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "А", "В", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", "4", "8", "7"},
            {"α", "β", "γ", "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "o", "ξ", "v", "π", "ρ", "σ", "τ", "υ", "φ", "χ", "ψ", "ω", "Ω", "Σ", "Ξ", "Ν", "Μ", "Λ", "Ι", "Η", "Ζ", "Δ", "V", "B", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"}};
    private static String[][] contyr3 = new String[][]{{"-", "1", "%", ";", "0", "$", "~", "P", "4", "_", "+", "=", "3", " ", "^", "/", "2", "|", "A", "S", "7", "C", "V", "Y", "5", "K", "L", "8", "M", "N", "6", "9", "!", "@", "#", "№", "й", "ф", "я", "ц", "ы", "ч", "у", "в", "с", "к", "а", "м", "е", "п", "и", "н", "р", "т", "г", "о", "ь", "ш", "л", "б", "щ", "д", "ю", "з", "ж", "э", "х", "ъ", "ё"},
            {".", "а", "3", ":", "б", "*", "5", "в", "-", "6", "г", "(", "7", "e", ")", "8", "f", "!", "9", "g", "@", "0", "h", "#", "$", "i", "%", "^", "j", "&", "*", "k", "+", "=", " ", "1", "ä", "ö", "å", "ž", "š", "Ó", "ř", "É", "Í", "Ť", "Á", "B", "C", "D", "E", "F", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "G", "H", "I", "J"},
            {"ä", "ö", "å", "ž", "š", "Ó", "ř", "É", "Í", "Ť", "Á", "L", "U", "y", "R", "B", "h", "K", "n", "b", "н", "в", "т", "3", "8", "2", "-", "ы", "1", "ж", "7", "4", "ц", "я", "ф", "э", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю", "Ё", "Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Вы хотите расшифровать или зашифровать ваше сообщение ? \n> ");
        String action = sc.nextLine();
        System.out.print("Введите ваше сообщение. ");
        if (action.equals("зашифровать")) {
            System.out.println("Cостоящее из следующего алфавита: ");
            for (String b : alf) System.out.print(b);
            System.out.println();
        }
        System.out.print("> ");
        String[] message = sc.nextLine().split("");

        for (String[] c : contyr1) {
            for (String b : c) System.out.print(b);
            System.out.println();
        }
        System.out.println();
        for (String[] c : contyr2) {
            for (String b : c) System.out.print(b);
            System.out.println();
        }
        System.out.println();
        for (String[] c : contyr3) {
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
        int schet = 0;
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(giveContyr(schet)[count][j])) {
                    end += alf[j];
                    count++;
                    if (count == 3) {
                        count = 0;
                    }
                    if (alf[j].equals(" ")) {
                        schet++;
                        count = 0;
                        if (schet == 3) schet = 0;
                    }
                    break;
                }
            }
        }
        return end;
    }

    public static String toEncrypt(String[] text) {
        String end = "";
        int count = 0;
        int schet = 0;
        for (String s : text) {
            for (int j = 0; j < alf.length; j++) {
                if (s.equals(alf[j])) {
                    end += giveContyr(schet)[count][j];
                    count++;
                    if (count == 3) {
                        count = 0;
                    }
                    if (s.equals(" ")) {
                        schet++;
                        count = 0;
                        if (schet == 3) schet = 0;
                    }
                    break;
                }
            }
        }
        return end;
    }

    public static String[][] giveContyr(int schet) {
        if (schet == 0) return contyr1;
        else if (schet == 1) return contyr2;
        else return contyr3;
    }
}