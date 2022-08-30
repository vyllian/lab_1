package com.nvl1;

public class Fib_numb {
    private int order;
    private int value;
    private boolean isprime;

    Fib_numb(int order, int value){
        this.order = order;
        this.value = value;
        this.isprime = this.isPrime((int)Math.sqrt(value)) ;
    }

    /** Gives value of Fibonacci number
     *
     * @return value
     */
    int getValue (){
        return this.value;
    }

    /** Gives access to isprime variable
     *
     * @return isprime value
     */
    boolean getPrime () { return this.isprime; }

    /** Defines whether the number is prime
     *
     * @param i square root of the number
     * @return true if number is prime or false if it's not
     */
    boolean isPrime(int i){
        while (i>1){
            if (this.value % i == 0) return false;
            i--;}
        return true;
    }

    /**
     * Fills an array with Fibonacci numbers
     * @param order index of the last number in row
     * @param arr array of Fibonacci numbers we fill
     */
    static void generate_array (int order, Fib_numb[] arr){
        int k, f1,f2,fnumb;
        Fib_numb tem;
        tem = new Fib_numb(1, 1);
        arr[0] = tem;
        if (order == 1  ) return;
        tem = new Fib_numb(2, 1);
        arr[1] = tem;
        if (order == 2) return;
        f1=f2=1; k=2;
        do{
            fnumb=f1+f2;
            tem = new Fib_numb(k,fnumb );
            arr[k] = tem;
            f2=f1;
            f1=fnumb;
        } while(++k!=order);
    }

}
