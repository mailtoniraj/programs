package practice.arrays;

public class ReverseArray {

 private static void reverseArray(int[] array){

     int[] reverseArray = new int[array.length];

     for(int i=0;i<array.length;i++)
         reverseArray[i]=array[array.length-i-1];

     for(int i=0;i<array.length;i++)
         System.out.print(reverseArray[i]+" ");

 }



    public static void main(String[] args) {
        int[] array = {2,1,2,4,2,5};
     reverseArray(array);

    }
}
