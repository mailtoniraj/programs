package practice.string;

public class ReverseWordsInString {
    public static void main(String[] args) {
        reverseWords("I am Niraj");
    }

    private static void reverseWords(String s){
        String[] stringArray = s.split(" ");
        StringBuilder b = new StringBuilder();
        for(int i=stringArray.length-1;i>=0;i--){
            b.append(stringArray[i]+" ");

        }
        System.out.println(b);


    }
}
