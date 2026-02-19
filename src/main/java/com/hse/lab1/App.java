package com.hse.lab1;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

// Вариант 18
public class App {

    static final String intInputError = "Некорректный ввод. Пожалуйста введите корректное число (например, 1, 2, 123).";
    static final String doubleInputError = "Некорректный ввод. Пожалуйста введите корректное число (например, 3.14, -5.2, 100).";

    /**
     * Ввод числа с плавающей точкой пользователем
     * Тип значения int
     * 
     * @param scanner Сканер для получения данных ввода
     * @param message Приглашение для ввода чисола
     * @return Введенное число
     */
    static int readInt(Scanner scanner, String message) {
        int result = 0;
        boolean validInput = false;
        do {
            System.out.print(message);
            try {
                result = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(doubleInputError);
            }
            scanner.nextLine();
        } while (!validInput);
        return result;
    }

    /**
     * Ввод числа с плавающей точкой пользователем
     * Тип значения double
     * 
     * @param scanner Сканер для получения данных ввода
     * @param message Приглашение для ввода чисола
     * @return Введенное число
     */
    static double readDouble(Scanner scanner, String message) {
        double result = 0;
        boolean validInput = false;
        do {
            System.out.print(message);
            try {
                result = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(doubleInputError);
            }
            scanner.nextLine();
        } while (!validInput);
        return result;
    }

    /**
     * Вычисление принадлежности точки заданной фигуре
     * 
     * @param x координата X
     * @param y координата Y
     * @return true, если точка находится внутри фигуры или на её границе,
     *         иначе - false
     */
    static boolean checkFigure(double x, double y) {
        // Верхняя граница представлена прямой y = -x + 5
        double upper = -x + 5;
        return x >= 0 && x <= 5 && y >= -7 && y <= upper;
    }

    /**
     * Задача 1. Проверка принадлежности точки фигуре
     * 
     * @param scanner Сканер для получения данных ввода
     */
    public static void task1(Scanner scanner) {
        System.out.println("Проверка приналежности точки фигуре");
        double x = readDouble(scanner, "Введите X > ");
        double y = readDouble(scanner, "Введите Y > ");
        if (checkFigure(x, y)) {
            System.out.println("Точка лежит внутри фигуры");
        } else {
            System.out.println("Точка лежит снаружи фигуры");
        }
    }

    static void calcExpressionFloat(float a, float b) {
        // Библиотека math приводит значения к double
        // Чтобы избежать этого операции возведения в степень развернуты

        // первое слагаемое в числителе
        float num1 = (a - b) * (a - b) * (a - b) * (a - b);
        System.out.printf("первое слагаемое в числителе: %f\n", num1);

        // второе слагаемое в числителе
        float num2 = a * a * a * a + 6 * a * a * b * b + b * b * b * b;
        System.out.printf("второе слагаемое в числителе: %f\n", num2);

        // числитель
        float num = num1 - num2;
        System.out.printf("значение в числителе: %f\n", num);

        // первое слагаемое в знаменателе
        float den1 = -4 * a * b * b * b;
        System.out.printf("первое слагаемое в знаменателе: %f\n", den1);

        // второе слагаемое в знаменателе
        float den2 = 4 * a * a * a * b;
        System.out.printf("второе слагаемое в знаменателе: %f\n", den2);

        // знаменатель
        float den = den1 - den2;
        System.out.printf("значение в знаменателе: %f\n", den);

        // результат
        float res = num / den;
        System.out.printf("результат: %f\n", res);
    }

    static void calcExpressionDouble(double a, double b) {
        // Библиотека math приводит значения к double
        // Чтобы избежать этого операции возведения в степень развернуты

        // первое слагаемое в числителе
        double num1 = Math.pow(a - b, 4);
        System.out.printf("первое слагаемое в числителе: %f\n", num1);

        // второе слагаемое в числителе
        double num2 = Math.pow(a, 4) + 6 * Math.pow(a, 2) * Math.pow(b, 2) + Math.pow(b, 4);
        System.out.printf("второе слагаемое в числителе: %f\n", num2);

        // числитель
        double num = num1 - num2;
        System.out.printf("значение в числителе: %f\n", num);

        // первое слагаемое в знаменателе
        double den1 = -4 * a * Math.pow(b, 3);
        System.out.printf("первое слагаемое в знаменателе: %f\n", den1);

        // второе слагаемое в знаменателе
        double den2 = 4 * Math.pow(a, 3) * b;
        System.out.printf("второе слагаемое в знаменателе: %f\n", den2);

        // знаменатель
        double den = den1 - den2;
        System.out.printf("значение в знаменателе: %f\n", den);

        // результат
        double res = num / den;
        System.out.printf("результат: %f\n", res);
    }

    static void calcExpressionDecimal(BigDecimal a, BigDecimal b) {
        // Библиотека BigDecimal приводит значения к BigDecimal
        // Чтобы избежать этого операции возведения в степень развернуты

        // первое слагаемое в числителе
        BigDecimal num1 = a.subtract(b).pow(4);
        System.out.printf("первое слагаемое в числителе: %f\n", num1);

        // второе слагаемое в числителе
        BigDecimal num2 = a.pow(4).add((new BigDecimal(6)).multiply(a.pow(2)).multiply(b.pow(2))).add(b.pow(4));
        System.out.printf("второе слагаемое в числителе: %f\n", num2);

        // числитель
        BigDecimal num = num1.subtract(num2);
        System.out.printf("значение в числителе: %f\n", num);

        // первое слагаемое в знаменателе
        BigDecimal den1 = (new BigDecimal(-4)).multiply(a).multiply(b.pow(3));
        System.out.printf("первое слагаемое в знаменателе: %f\n", den1);

        // второе слагаемое в знаменателе
        BigDecimal den2 = (new BigDecimal(4)).multiply(a.pow(3)).multiply(b);
        System.out.printf("второе слагаемое в знаменателе: %f\n", den2);

        // знаменатель
        BigDecimal den = den1.subtract(den2);
        System.out.printf("значение в знаменателе: %f\n", den);

        // результат
        BigDecimal res = num.divide(den);
        System.out.printf("результат: %f\n", res);
    }

    /**
     * Задача 2. Вычисление значения выражения
     */
    public static void task2() {
        System.out.println("Вычисление значения выражеиня");
        System.out.println("Тип float");
        calcExpressionFloat(1000f, 0.0001f);
        System.out.println("Тип double");
        calcExpressionDouble(1000d, 0.0001d);
        System.out.println("Тип BigDecimal");
        calcExpressionDecimal(new BigDecimal(1000), new BigDecimal("0.0001"));
    }

    /**
     * Задача 3. Вычисление среднего значения
     * 
     * @param scanner Сканер для получения данных ввода
     */
    public static void task3(Scanner scanner) {
        System.out.println("Вычисление среднего значения последовательности");
        int n = readInt(scanner, "Введите число элементов последовательности > ");
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double elem = readInt(scanner, String.format("Введите элемент %d > ", i + 1));
            sum += elem / n;
        }
        System.out.println(String.format("Среднее значение последовательности: %f", sum));
    }

    /**
     * Вывод главного меню
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("Выберите задачу:");
        System.out.println("0 - Выход");
        System.out.println("1 - Проверка приналежности точки фигуре");
        System.out.println("2 - Вычисление значения выражения");
        System.out.println("3 - Вычисление среднего значения");
    }

    /**
     * Основной метод программы
     * 
     * @param args параметры командной строки
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Лабораторная работа 1");
        while (running) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        task1(scanner);
                        break;
                    case 2:
                        task2();
                        break;
                    case 3:
                        task3(scanner);
                        break;
                    case 0:
                        System.out.println("Выход из программы...");
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Некорректный вводв.");
                scanner.nextLine(); // Очистка буфера
            }
        }
        scanner.close();
    }
}
