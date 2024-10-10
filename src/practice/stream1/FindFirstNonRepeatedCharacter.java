package practice.stream1;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedCharacter {

    public static void main(String[] args) {

        String inputString = "This is Niraj Kumar";

       Character chara =  inputString.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char)c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entrykey->entrykey.getValue()==1L)
                .map(entrykey -> entrykey.getKey())
                .findFirst().get();
        //System.out.println(chara);
// Find Last Non Repeating charaacter
        Character chara1 =  inputString.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char)c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entrykey->entrykey.getValue()==1L)
                .map(entrykey -> entrykey.getKey())
                .toList().getLast();

        System.out.println(chara1);
    }
}
