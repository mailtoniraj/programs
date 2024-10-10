package practice.string;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("listen","listenn"));
    }

    private static Boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);

            }else{

                map.put(s1.charAt(i),1);
            }

        }

        for(int i=0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s1.charAt(i),map.get(s1.charAt(i))-1);
            }else{
                return false;
            }
        }

       for(Integer i:map.values()) {

           if(i!=0){
               return false;
           }
       }

        return true;

    }
}
