package practice.arrays;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    static int factorial(int fact){
        int result =1;
        for ( int i=fact;i>=1;i--){
            result=result*i;
        }
        return result;
    }
}
