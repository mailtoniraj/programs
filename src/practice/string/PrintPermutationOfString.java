package practice.string;

public class PrintPermutationOfString {
    public static void main(String[] args) {
        printPermutation("ABC",0,2);
    }

    private static void printPermutation(String s,int start,int end){

        if(start ==end){
            System.out.println(s);
        }else {
            for (int i = start; i <= end; i++) {
              s=  swap(s, start, i);
                printPermutation(s,start+1,end);
               s= swap(s, start, i);

            }

        }
    }

    private static String swap(String s, int i, int j){

        char[] array = s.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
       return new String(array);


    }
}
