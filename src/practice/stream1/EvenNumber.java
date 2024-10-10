package practice.stream1;

import java.util.Arrays;
import java.util.List;

public class EvenNumber {

    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(12,13,4,5,12,6);

        // Calculate Even Number
         // numberList.stream().filter(num->num%2==0).forEach(System.out::print);

          // Find numbers starting with 1

       // numberList.stream().map(num->num + "").filter(num->num.startsWith("1")).forEach(System.out::print);
     // HashSet<Integer> hashSet = new HashSet<>();
      // print unique character
      //numberList.stream().filter(num->!hashSet.add(num)).forEach(System.out::print);
     // numberList.stream().distinct().forEach(System.out::print);
        // Find max number
        int max = numberList.stream().max(Integer::compare).get();
        // Find first number
        numberList.stream().findFirst().ifPresent(System.out::print);
    }

}
