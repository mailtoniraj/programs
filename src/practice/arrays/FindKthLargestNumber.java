package practice.arrays;

import java.util.PriorityQueue;

public class FindKthLargestNumber {

    public static void main(String[] args) {
        int[] array = {2,3,5,6,7};
        System.out.println(printKthLargerst(array,3));
    }

    private static Integer printKthLargerst(int[] array,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            priorityQueue.add(array[i]);

        }
        for(int i=k;i<array.length;i++){
            if(array[i]>priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(array[i]);

            }
        }

        return priorityQueue.peek();

    }


}
