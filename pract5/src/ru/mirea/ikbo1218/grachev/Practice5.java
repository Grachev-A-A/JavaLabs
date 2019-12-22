package ru.mirea.ikbo1218.grachev;

public class Practice5 {
    // ex 6
    /*
    Дано натуральное число n>1. Проверьте, является ли оно простым.
    Программа должна вывести слово YES, если число простое и NO, если число составное.
     */
    private static void isPrime(int number) {isPrime(number, 2);}
    private static void isPrime(int number, int div){
        if (number == 2) {
            System.out.println("YES");
            return;
        }
        if(number % div == 0) {
            System.out.println("NO");
            return;
        }
        if(div > Math.sqrt(number)){
            System.out.println("YES");
            return;
        }
        isPrime(number, div+1);
    }

    // ex7

    /*
Дано натуральное число n>1.
Выведите все простые множители этого числа в порядке не убывания с учетом кратности.
     */

    // methods without souts
    private static boolean isNumPrime(int number){
        return isNumPrime(number, 2);
    }
    private static boolean isNumPrime(int number, int div){
        if(number == 2) return true;
        if(number % div == 0) {
            return false;
        }
        if(div > Math.sqrt(number)){
            return true;
        }
        return isNumPrime(number, div+1);
    }

    private static void factorization(int number) {factorization(number, 2);}
    private static void factorization(int number, int div){
        if(number == 2) {
            System.out.println("2");
            return;
        }
        if(number <= 1) return;
        if(!isNumPrime(div)) {
            factorization(number, div+1);
            return;
        }
        if(number % div == 0){
            System.out.print(div +", ");
            factorization(number / div, div);
        }else factorization(number, div+1);
    }

//ex8
    /*
    Дано слово, состоящее только из строчных латинских букв.
    Проверьте, является ли это слово палиндромом. Выведите YES или NO.
     */
    private static void isPalindrome(String s){
        if(s.length() == 1){
            System.out.println("YES"); return;
        }
        if(s.charAt(0) != s.charAt(s.length()-1)){
            System.out.println("NO"); return;
        }
        if(s.length()==2){
            System.out.println("YES"); return;
        }
        isPalindrome(s.substring(1, s.length()-1));
    }

// ex9
    /*
    Даны числа a и b. Определите, сколько существует последовательностей из a нулей и b единиц, в которых никакие два нуля не стоят рядом.
     */
    private static int count(int a, int b){
        if(a==0) return 1;
        if(a==1) return b+1;
        if(a>1 && b==0) return 0;
        return count(a-1, b-1) + count(a, b-1);
    }

//ex10
    /*
    Дано число n, десятичная запись которого не содержит нулей.
    Получите число, записанное теми же цифрами, но в противоположном порядке.
     */

    private static int revers(int num, int rev){
        if(num==0)return rev;
        return revers(num/10, 10*rev + num%10);
    }


    public static void main(String[] args) {
//ex6
        System.out.println("Primes?");
        isPrime(2);
        isPrime(18756);
        isPrime(3571); // prime
//ex7
        System.out.println("\nFactorization");
        factorization(525);
        System.out.println();
        factorization(777);
        System.out.println();
        factorization(360);
        System.out.println();
        factorization(2);
//ex8
        System.out.println("\nPalindrome:");
        isPalindrome("hellolleh");
        isPalindrome("heloeh");
        isPalindrome("h");

//ex9
        System.out.println("\nZeros");
        System.out.println(count(0,0));
        System.out.println(count(1,3));
        System.out.println(count(14,15));
//ex10
        System.out.println("\nReverse");
        System.out.println(revers(123,0));
        System.out.println(revers(1, 0));
        System.out.println(revers(9968123, 0));
    }
}
