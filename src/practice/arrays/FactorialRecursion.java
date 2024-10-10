package practice.arrays;

public class FactorialRecursion {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int fact){
        if(fact == 1)
            return 1;
        else
            return fact*factorial(fact-1);

    }
}
