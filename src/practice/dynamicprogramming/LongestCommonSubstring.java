package practice.dynamicprogramming;

class LongestCommonSubstring
{
    public static int longestCommonSubstrLengthRecursive(int[][][] lookupTable, String s1, String s2, int i1, int i2, int count)
    {
        if (i1 == s1.length() || i2 == s2.length())
            return count;
        if (lookupTable[i1][i2][count] == -10) {
            int c1 = count;
            if (s1.charAt(i1) == s2.charAt(i2))
                c1 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1 + 1, i2 + 1, count + 1);
            int c2 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1, i2 + 1, 0);
            int c3 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1 + 1, i2, 0);
            lookupTable[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
        }
        return lookupTable[i1][i2][count];
    }

    public static int longestCommonSubstrLength(String s1, String s2)
    {
        //declaring a lookup table with dimensions: lookupTable[s1.size()][s2.size()][maxLength];
        int size1 = s1.length(), size2 = s2.length();
        int maxLength = Math.max(size1, size2);
        int [][][] lookupTable = new int [size1][][];

        for (int i = 0; i < size1; i++) {
            lookupTable[i] = new int [size2][];
            for (int j = 0; j < size2 ; j++) {
                lookupTable[i][j] = new int[maxLength];
                for (int k = 0; k < maxLength; k++)
                    lookupTable[i][j][k] = -10;
            }
        }
        return longestCommonSubstrLengthRecursive(lookupTable, s1, s2, 0, 0, 0);
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
