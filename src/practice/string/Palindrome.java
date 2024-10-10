package practice.string;

class Palindrome {
    public static void main(String[] args) {

       checkPalindrome("abc");
        System.out.println( checkPalindrome("radar"));
    }

    static boolean  checkPalindrome(String str){
        int begin =0;
        int end=str.length()-1;
        while(begin <end){

            if(str.charAt(begin) != str.charAt(end)){
                return false;
            }
            ++begin;
            --end;
        }

        return true;
    }
}