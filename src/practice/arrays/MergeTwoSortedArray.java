package practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray {

 private static void merge(List<Integer> list1,List<Integer> list2) {

     ArrayList<Integer> list = new ArrayList<>(list1.size() + list2.size());

     Integer array1pointer = 0;
     Integer array2pointer = 0;

     while (array1pointer < list1.size() && array2pointer < list2.size()) {

         if (list1.get(array1pointer)<list2.get(array2pointer)) {
             list.add(list1.get(array1pointer));
             ++array1pointer;
         } else {

             list.add(list2.get(array2pointer));
             ++array2pointer;
         }

     }
     while (array1pointer < list1.size()) {
         list.add(list1.get(array1pointer));
         ++array1pointer;
     }

     while (array2pointer < list2.size()) {
         list.add(list2.get(array2pointer));
         ++array2pointer;
     }
     System.out.println(list);

 }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = {7,8,9,10};

        List<Integer> list1= List.of(Arrays.stream(array1).boxed().toArray(Integer[]::new));
        List<Integer> list2= List.of(Arrays.stream(array2).boxed().toArray(Integer[]::new));
        merge(list1,list2);

    }
}
