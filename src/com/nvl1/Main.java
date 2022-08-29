package com.nvl1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int N;
        Scanner scan = new Scanner(System.in);

        if (args.length == 0) {
            System.out.print("Введіть кількість чисел Фібоначі: ");
            N = scan.nextInt();
        }
        else {
            N = Integer.parseInt(args[0]);
            System.out.println("Значення кількості ("+N+") взято з командного рядка");
        }

        System.out.println("Ряд Фібоначі до " + N + " елементу включно:");

        Fib_numb[] fib_arr = new Fib_numb[N];
        Fib_numb tem = new Fib_numb();
        tem.generate_array(N,fib_arr);

        for (int i=0; i<N;i++ )
            System.out.print(fib_arr[i].getValue()+" ");

        System.out.println("\nПрості числа з вищезазначеного ряду:");

        for (int i=0; i<N;i++ ){
            if (fib_arr[i].getPrime())
                System.out.print(fib_arr[i].getValue() + " " );
        }
    }

}
