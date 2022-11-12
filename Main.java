import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите математическое выражение ");
        String math = in.nextLine();                                        //Присваеваем вводимой строке имя math
        in.close();
        System.out.println(calc(math));
    }

    public static String calc(String input) throws IOException {
        int z = input.indexOf(42);                                              //"*"
        int y = input.indexOf(43);                                              //"+"
        int x = input.indexOf(45);                                              //"-"
        int w = input.indexOf(47);                                              //"/"


        if (w < 1 && x < 1 && y < 1 && z < 1) {
            System.out.println("//Математический символ неверный или отсутствует.");
            throw new IOException();
        }
        String[] strings = input.split("[+-/*]"); //Создаем массив строк разделяя по одному из математических символов
        int aL = strings.length;
        if (aL > 2) {
            System.out.println("Выражение не соответсвует требованиям");
            throw new IOException();
        }


        if (strings[0].codePointAt(0) > 60 && strings[1].codePointAt(0) > 60) {
            try {
                Roman.valueOf(strings[0]);
                Roman.valueOf(strings[1]);
            } catch (IllegalArgumentException e) {
                System.out.println("Буквенные значения не соответсвуют римским цифрам.");
            }

            Roman one = Roman.valueOf(strings[0]);
            Roman two = Roman.valueOf(strings[1]);

            int a = one.getArabic();
            int b = two.getArabic();
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            if (a > 10 | a < 1 | b > 10 | b < 1) {
                System.out.println("Условия не выполняются, число(числа) выходят за пределы требований задачи.");
                throw new IOException();
            }
            {
                if (z >= 1) {
                    int c = a * b;
                    return roman[c];
                } else if (y >= 1) {
                    int c = a + b;
                    return roman[c];
                } else if (x >= 1) {
                    int c = a - b;
                    if (c < 1) {
                        System.out.println("В римской системе нет отрицательных чисел, нуля.");
                        throw new IOException();
                    }
                    return roman[c];
                } else {
                    int c = a / b;
                    if (c < 1) {
                        System.out.println("В римской системе нет отрицательных чисел, нуля.");
                        throw new IOException();
                    }
                    return roman[c];
                }
            }
        } else if (strings[0].codePointAt(0) < 60 && strings[1].codePointAt(0) < 60) {
            int[] mathInt = new int[2];                                         //Создаем массив чисел mathInt
            for (int i = 0; i < strings.length; i++) {
                mathInt[i] = Integer.parseInt(strings[i]);
            }
            int a = mathInt[0];
            int b = mathInt[1];

            if (a > 10 | a < 1 | b > 10 | b < 1) {
                System.out.println("Условия не выполняются, число(числа) выходят за пределы требований задачи.");
                throw new IOException();
            }
            {
                if (z >= 1) {
                    int c = a * b;
                    return Integer.toString(c);
                } else if (y >= 1) {
                    int c = a + b;
                    return Integer.toString(c);
                } else if (x >= 1) {
                    int c = a - b;
                    return Integer.toString(c);
                } else {
                    int c = a / b;
                    return Integer.toString(c);
                }
            }
        } else {
            System.out.println("Числа в разных системах исчисления");
            throw new IOException();
        }
    }
}
