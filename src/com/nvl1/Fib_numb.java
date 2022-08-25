package com.nvl1;
/**
 *  клас числа Фібоначі
 */
public class Fib_numb {
    private int order; // поле порядкового номеру
    private int value; // поле значення
    /**
     *  конструктор
     */
    Fib_numb(int order, int value){
        this.order = order;
        this.value = value;
    }
    /**
     *  метод отримання поля значення
     * повертає значення числа об'єкта
     */
    int getValue (){
        return this.value;
    }
    /**
     *  метод отримання поля номеру
     * повертає значення порядкового номера об'єкта
     */
    int getOrder (){
        return this.order;
    }
    /**
     * метод встановлення поля значення
     * параметр "int value" - значення, яке встановиться
     */
    void setValue (int value){
        this.value=value;
    }
    /**
    метод встановлення поля номеру
     * параметр "int value" - значення, яке встановиться
     */
    void setOrder (int order){
        this.order=order;
    }
    /**
     * рекурсивний метод перевірки чи значення є простим числом
     * параметр "int і" - дільник
     * повертає 1, якщо число просте, інакше - 0
     */
    int isPrime(int i){
        if(i==1) return 1;
        if (this.value%i==0) return 0; // якщо немає остачі при ділені - просте
        return isPrime(i-1);
    }
}
