package practice.string;

class LongestCommonSubstring
{
    //function to find the longest common subsequence
    public static int longestCommonSubstrLength(String s1, String s2)
    {
        //lookupTable to store the already computed subproblems solutions
        int[][] lookupTable = new int[s1.length()+1][];

        //Initializing all values in lookupTable to zero
        for(int i = 0; i <= s1.length(); i++)
            lookupTable[i] = new int[s2.length()+1];


        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                lookupTable[i][j] = 0;
            }
        }
        int maxLength = 0;
        //filling lookupTable in a bottom-up manner
        for (int i = 1; i <=s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //if the current characters of s1 and s2 match
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                    maxLength = Math.max(maxLength, lookupTable[i][j]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String args[])
    {
        String S1 = "www.educative.io/explore";
        String S2 = "educative.io/edpresso";
        String S3 = "0abc321";
        String S4 = "123abcdef";
        System.out.println(longestCommonSubstrLength(S3, S4));
        System.out.println(longestCommonSubstrLength(S1, S2));
    }
};