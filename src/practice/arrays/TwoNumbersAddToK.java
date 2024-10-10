package practice.arrays;

import java.util.Arrays;

public class TwoNumbersAddToK {

    public static void main(String[] args) {
     int[] input = {1,2,3,4};
        printTwoNumbers(input,5);
    }

   static void printTwoNumbers(int[] arr,int k){

       Arrays.sort(arr);

       int start = 0;
       int end = arr.length-1;

       while(start<end){

           if(arr[start]+arr[end] < k){
               ++start;

           }else  if(arr[start]+arr[end] > k){
               --end;

           }else{

               System.out.println(arr[start]);
               System.out.println(arr[end]);
               break;
           }

       }

   }

}
