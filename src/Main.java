import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите арифметическое выражение:");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] elements = input.split("\\s+");

        if (elements.length != 3) {
            throw new IllegalArgumentException("Неверное количество элементов в выражении");
        }

        int a, b;
        try {
            a = Integer.parseInt(elements[0]);
            b = Integer.parseInt(elements[2]);

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неподходящее число в выражении");
        }

        char operator = elements[1].charAt(0);
        int result;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная арифметическая операция");
        }

        return Integer.toString(result);
    }
}