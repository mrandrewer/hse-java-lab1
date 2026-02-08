package com.hse.lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

// Вариант 18
public class App {

    static final String doubleInputError = "Некорректный ввод. Пожалуйста введите корректное число (например, 3.14, -5.2, 100).";

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
     * Ввод числа с плавающей точкой пользователем
     * 
     * @param scanner Сканер для получения данных ввода
     * @param message Приглашение для ввода чисола
     * @return Введенное число
     */
    static double readDouble(Scanner scanner, String message) {
        double result = 0;
        boolean validInput = false;
        System.out.print(message);
        do {
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

    /**
     * Вывод главного меню
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("Выберите задачу:");
        System.out.println("0 - Выход");
        System.out.println("1 - Проверка приналежности точки фигуре");
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
