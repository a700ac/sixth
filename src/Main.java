import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите числа и действие: ");
        System.out.println();
        //Чтение входящей строки;
        String a = sc.nextLine();
        int res = 0;
        int operand1 = 0;
        int operand2 = 0;
        boolean chk1 = false;
        boolean chk2 = false;


        String[] rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
                "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"
        };


        //Разделение строки на числа и действие;
        String[] arr = a.split("[+\\-*/]");
        int b = arr.length;
        //Проверки на правильность ввода 1;
        if (b > 2) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда " +
                "и один оператор (+, -, /, *)");
        if (b < 2) throw new Exception("Cтрока не является математической операцией");

        //Поиск римских операндов и присваивание им арабских значений;
        for (int i = 0; i < rim.length; i++) {
            if (arr[0].equals(rim[i])) {
                operand1 = i;
                chk1 = true;
            }
        }
        for (int i = 0; i < rim.length; i++) {
            if (arr[1].equals(rim[i])) {
                operand2 = i;
                chk2 = true;
            }
        }
        //Проверки на правильность ввода 2;
        if ((chk1 == true) && (chk2 == false) || ((chk1 == false) && (chk2 == true))) {
            throw new Exception("Используются одновременно" +
                    " разные системы счисления");
        }

        //Присваивания значений арабским операндам;
        if (chk1 == false) {
            operand1 = Integer.parseInt(arr[0]);
        }
        if (chk2 == false) {
            operand2 = Integer.parseInt(arr[1]);
        }
        //Проверки на правильность ввода 3;
        if ((operand1 > 10) || (operand2 > 10) || (operand1 == 0) || (operand2 == 0))
            throw new Exception("Вводимые числа могут быть" +
                    " от 1 до 10");

        //Выполнение действия и вывод на консоль;

        res = Calculator.calc(a, operand1, operand2);

        if ((chk1 == true) && (chk2 == true) && (res < 1))
            throw new Exception("В римской системе нет отрицательных чисел и нуля");
        if ((chk1 == true) && (chk2 == true)) {
            System.out.println(rim[res]);
        } else {
            System.out.println(res);
        }
    }
}
