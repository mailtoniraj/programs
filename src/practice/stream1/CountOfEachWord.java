package practice.stream1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfEachWord {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("test1","test1","test3","test4");

        String inputString = "This is test";
// print count of each word
        Map<String,Long > map =  input.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        //System.out.println(map);

        //Find duplicate Elements and count
        Map<String,Long> map1 = input.stream().filter(x->Collections.frequency(input,x)>1)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

       // System.out.println(map1);

        // count of each character
       Map<String, Long> mapCount = Arrays.stream(inputString.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(mapCount);

    }
}
