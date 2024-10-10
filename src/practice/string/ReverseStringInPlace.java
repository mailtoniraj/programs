package practice.string;

public class ReverseStringInPlace {

    public static void main(String[] args) {
        reverseString("Niraj");
    }

    private static void reverseString(String s){

         char[] charArray = s.toCharArray();

         int length = s.length()/2;

         for(int i=0;i<length;i++){
             char temp = charArray[i];
             charArray[i] = charArray[s.length()-i-1];
             charArray[s.length()-i-1] =  temp;
         }
        System.out.println(new String(charArray));
    }
}
