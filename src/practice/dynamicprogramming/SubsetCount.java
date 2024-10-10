package practice.dynamicprogramming;

class SubSetCount {

    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        // Else, check if sum can be obtained
        // by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    // Driver code
    public static void main(String args[])
    {
        int set[] = { 2,1,2,4,2,5 };
        int sum = 10;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}