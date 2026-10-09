/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.home.task_2_7_a_ru;
import java.io.*;
/**
 *
 * @author PC
 */
public class Program 
{
    public static void main(String[] args) throws Exception
    {
        String a; // строка текущего кода
        String b; // строка целового кода
        int n_len1; // Длина строки текущего кода
        int n_len2; // Длина строки целевого кода
        int total_moves = 0;  // Счётчик ходов
        //--Переменная для ввода строк с клавиатуры
        var stdin = new BufferedReader(new InputStreamReader(System.in));
        // Чтение входных данных
        System.out.print("Введите текущий код: "); // Вывод подсказки
        a = stdin.readLine(); // Ввод текущего кода
        System.out.print("Введите целевой код: ");
        b = stdin.readLine(); // Ввод целового кода
        a = a.trim();  // Удаление ненужных пробелов
        b = b.trim();  // Удаление ненужных пробелов
        n_len1 = a.length(); // Вычислить длину 1-ой строки
        n_len2 = b.length();  // Вычислить длину 2-ой строки
        // Проверка на совпадение длины текущего и целевого кода
        // Если длина текущего кода не равна длине целевого
        // и оба кода не четырёхзначные, программа завершает работу.
        if ((n_len1 != 4) || (n_len2 != 4) || (n_len1 != n_len2))
        {
            System.out.println("Комбинация кодового замка должна быть 4 цифры.");
            System.out.println("Текущий и целевой код должны быть одинаковой длины.");
            System.exit(0); // Выход из программы
        }
        // Подсчет минимального количества ходов
        for(int i = 0; i < a.length(); i++)
        {
            var x = (int)(a.charAt(i) - '0'); // Цифра текущего кода
            var y = (int)(b.charAt(i) - '0'); // Цифра целевого кода
            var diff1 = Math.abs(x - y);  // разность цифр, прямой ход диска
            // разность цифр, обратный ход диска
            var diff2 = 10 - Math.abs(x - y);  
            // Мнинимальное число ходов - разность между каждой цифрой диска
            // в целевом коде и текущем коде замка сейфа
            // Общее число ходов - ответ на вопрос
            total_moves += Math.min(diff1, diff2);  
        }
        // Вывод информации на экран
        System.out.println("Текущий код:" + a);
        System.out.println("Целевой код:" + b);
        System.out.println("Мнинимальное число ходов:" + total_moves);
    }
}
