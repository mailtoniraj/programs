package practice.string;

import java.util.Arrays;

public class IsPanagram {

    public static void main(String[] args) {
        System.out.println(isPanagram("The quick brown fox jumps over the lazy dog"));
    }

    private static Boolean isPanagram(String s) {

        s = s.toUpperCase();

        Boolean[] array = new Boolean[26];
        Arrays.fill(array, false);
        int characterIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {

                characterIndex=s.charAt(i)-'A';
                array[characterIndex] = true;
            }
        }
        for(Boolean b:array){
            if(!b){
                return false;
            }

        }
        return true;
    }
}
