package practice.arrays;

import java.util.PriorityQueue;

public class FindKthSmallestNumber {

    public static void main(String[] args) {
        int[] array = {2,3,5,6,7};
        System.out.println(printKthSmallest(array,3));
    }

    private static Integer printKthSmallest(int[] array,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)->n2-n1);

        for(int i=0;i<k;i++){
            priorityQueue.add(array[i]);

        }
        for(int i=k;i<array.length;i++){
            if(array[i]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(array[i]);

            }
        }

        return priorityQueue.peek();

    }
}
