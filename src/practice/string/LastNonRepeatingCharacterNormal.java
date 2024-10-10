package practice.string;

public class LastNonRepeatingCharacterNormal {



    // Maximum distinct characters possible
    static final int MAX = 256;

    // Function to return the last non-repeating character
    static String lastNonRepeating(String str, int n)
    {

        // To store the frequency of each of
        // the character of the given string
        int freq[] = new int[MAX];

        // Update the frequencies
        for (int i = 0; i < n; i++)
            freq[str.charAt(i)]++;

        // Starting from the last character
        for (int i = n - 1; i >= 0; i--) {

            // Current character
            char ch = str.charAt(i);

            // If frequency of the current character is 1
            // then return the character
            if (freq[ch] == 1)
                return ("" + ch);
        }

        // All the characters of the
        // string are repeating
        return "-1";
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "algorithms tutorial sdasdadasda asdadada asdasdasdas asd adasdsa dasdadada";
        int n = str.length();
        System.out.println(lastNonRepeating(str, n));
    }
}
