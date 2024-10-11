package practice.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    public static int houseRobber(int[] money) {
        if (money == null || money.length == 0) {
            return 0;
        }

        if (money.length == 1) {
            return money[0];
        }

        return Math.max(houseRobberHelper(Arrays.copyOfRange(money, 0, money.length - 1)),
                houseRobberHelper(Arrays.copyOfRange(money, 1, money.length)));
    }

    private static int houseRobberHelper(int[] money) {
        int[] lookupArray = new int[money.length + 1];
        lookupArray[0] = 0;
        lookupArray[1] = money[0];

        for (int i = 2; i <= money.length; i++) {
            lookupArray[i] = Math.max(money[i - 1] + lookupArray[i - 2], lookupArray[i - 1]);
        }

        return lookupArray[money.length];
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = { { 2, 3, 2 }, { 1, 2, 3, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 7, 4, 1, 9, 3 }, {} };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tHouses: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tMaximum loot: " + houseRobber(inputs[i]));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }
    }
}