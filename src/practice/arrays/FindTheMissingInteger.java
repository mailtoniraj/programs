package practice.arrays;

import java.util.Arrays;

public class FindTheMissingInteger {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,6};
        missingInteger(array);

    }

    private static void missingInteger(int[] array) {

     //  Integer sum =  Arrays.stream(array).reduce(0,Integer::sum);
        Integer sum=  Arrays.stream(array).reduce(0, (x,y) -> x+y);
        System.out.println(sum);
       int n= array.length+1;

       int actualSum = (n*(n+1))/2;
        System.out.println("The number is "+(actualSum-sum));


    }

}
