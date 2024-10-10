package practice.dynamicprogramming;

public class EggDropping {

        public static int eggDropRec(int eggs, int floors, int [][] lookupTable)
        {
            // If there are no eggs, then there can't be any tries
            if (eggs <= 0)
                return 0;

            // If there are no floors, then no trials needed. OR if there is
            // one floor, one trial needed.
            if (floors == 1 || floors == 0)
                return floors;

            // We need k trials for one egg and k floors
            if (eggs == 1)
                return floors;

            lookupTable[eggs][floors] = Integer.MAX_VALUE;
            int x, res;

            // Consider all droppings from 1st floor to kth floor and
            // return the minimum of these values plus 1.
            for (x = 1; x <= floors; x++)
            {
                res = 1 + Math.max(eggDropRec(eggs - 1, x - 1, lookupTable), eggDropRec(eggs, floors - x, lookupTable));
                if (res < lookupTable[eggs][floors])
                    lookupTable[eggs][floors] = res;
            }
            return lookupTable[eggs][floors];
        }

        public static int eggDrop(int eggs, int floors)
        {
            int [][] lookupTable;
            lookupTable = new int[eggs + 1][];
            for (int i = 0; i < eggs + 1; i++) {
                lookupTable[i] = new int[floors + 1];
                for (int j = 0; j < floors + 1; j++)
                    lookupTable[i][j] = 0;
            }
            return eggDropRec(eggs, floors, lookupTable);
        }

        public static void main(String args[])
        {
            int eggs = 2, floors = 10;
            System.out.println("With " + eggs + " eggs and " + floors + " floors, the minimum number of trials in worst case are: " + eggDrop(eggs, floors));
        }
    };

