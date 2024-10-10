package practice.string;

public class StringReverse {
    public static void main(String[] args) {

        System.out.println(reverse("niraj"));

    }

    static String  reverse(String str){

        //char[] array = str.toCharArray();
        int end = str.length();
        String output="";

        for(int i=end-1; i>=0;i--){

           output= output+str.charAt(i);
        }

    return output;
    }

}
