package com.nvl1;
import java.util.Scanner;
 /**
  *  головний клас
  */
public class Main {

    public static Fib_numb[] fib_arr; //масив для об'єктів
     /**
      *  головний метод
      *  командним рядком моджна передати кількість чисел Фібоначі,
      *  або ж залишити його порожнім
      */
    public static void main(String[] args)
    {
        int N; // порядковий номер числа Фібоначі
        Scanner scan = new Scanner(System.in);

        if (args.length == 0) { // введення з клавіатури
        System.out.print("Введіть кількість чисел Фібоначі: ");
        N = scan.nextInt();
        }
        else { // введення з командного рядка
            N = Integer.parseInt(args[0]);
            System.out.println("Значення кількості ("+N+") взято з командного рядка");
        }
        fib_arr = new Fib_numb[N+1]; // створюємо масив об'єктів відповідно до кількості +1 для початкового 0
        System.out.println("Ряд Фібоначі до " + N + " елементу включно:");

        for (int i=1; i<=N;i++ ) // заповнюємо масив відповідними значеннями за доп. функції Fibb
            System.out.print(Fibb(i)+" ");

        System.out.println("\nПрості числа з вищезазначеного ряду:");

        for (int i=1; i<=N;i++ ){ // проходимося по масиву і друкуємо з нього прості числа
            // перевірямо чи ділиться значення на чИсла до числА, яке рівне кореню значення
            if (fib_arr[i].isPrime((int)Math.sqrt(fib_arr[i].getValue()))==1)
                System.out.print(fib_arr[i].getValue() + " " );
        }
    }
     /**
      *  рекурсивний метод знаходження значення числа Фібоначі за порядковим номером
      *  і заповнення масиву числами Фібоначі
      *  параметр "int order" - порядковий номер числа Фібоначі
      *  повертає значення числа Фібоначі під преданим порядковим номером
      */
    public static int Fibb (int order){
        Fib_numb temp; // об'єкт для запису у масив
        if (order<=1){ // якщо перші 2 елементи ряду або початковий 0
            temp = new Fib_numb(order, order);
            fib_arr[order] = temp ; // записуємо об'єкт у масив
            return order;
        }
        if (fib_arr[order]!=null) { // якщо значення числа Фібоначі вже обраховане
            return fib_arr[order].getValue();
        }
        int num = Fibb(order-1)+Fibb(order-2); // обчислюємо значення числа
        temp = new Fib_numb(order, num); // заносимо значення і порядковий номер у об'єкт, далі - у масив
        fib_arr[order] = temp ;
        return num;
    }
}


