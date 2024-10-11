package practice.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        for (int i = 1; i <= inputString.length(); ++i) {
            String first = inputString.substring(0, i);

            // check if the first part exists in the dictionary
            if (dictionary.contains(first)) {
                String second = inputString.substring(i);
                if (inputString.isEmpty()) {
                    return true;
                }

                // check if the second part exists in the dictionary
                if (dictionary.contains(second)) {
                    return true;
                }

                // Recursive call
                if (canSegmentString(second, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] inputStr = {"hellonow", "nowok", "applepie", "applejuice"};
        String[][] wordsDictionary =
                {{"hello", "hell", "on", "now"}, {"hello", "hell", "on", "now"},
                        {"apple", "pear", "pier", "pie"}, {"apple", "pear", "pier", "pie"}};
        for (int i = 0; i < inputStr.length; i++) {
            Set<String> dict = new HashSet<String>(Arrays.asList(wordsDictionary[i]));

            // Custom function to print a set of strings
          //  System.out.println((i + 1) + ". Words dictionary: [" + StringPrint.setStrPrint(dict) + "]");

            System.out.println("   Input string: \"" + inputStr[i] + "\"");
            if (canSegmentString(inputStr[i], dict))
                System.out.println("   Result: String can be segmented");
            else
                System.out.println("   Result: String can not be segmented");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------\n");
        }

    }
}
