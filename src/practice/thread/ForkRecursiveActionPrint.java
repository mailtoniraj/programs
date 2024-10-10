package practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkRecursiveActionPrint extends RecursiveAction {

    private List<Integer> nums;

    public ForkRecursiveActionPrint(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    protected void compute() {
        // the problem is small enough (containing 2 items) so we use
        // standard sequential print operation
        if(nums.size() < 2) {
            for(Integer num : nums)
                System.out.println("++++++++++++++++"+num);
        } else {
            // otherwise we split the problem into 2 sub-problems
            // [a,b,c] --> [a] and [b,c]
            // [a,b,c,d] --> [a,b] and [c,d]
            List<Integer> left = nums.subList(0, nums.size()/2);
            List<Integer> right = nums.subList(nums.size()/2,  nums.size());

            ForkRecursiveActionPrint action1 = new ForkRecursiveActionPrint(left);
            ForkRecursiveActionPrint action2 = new ForkRecursiveActionPrint(right);

            // it means these actions are thrown into the pool
            // fork-join assigns different threads to different tasks
            // so these will be executed with different threads
            invokeAll(action1, action2);
        }
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        Integer[] integerArray = {1,2,3,4,5};
        List<Integer> listArray = new ArrayList<>(List.of(integerArray));
        ForkRecursiveActionPrint simpleRecursiveAction = new ForkRecursiveActionPrint(listArray);
        forkJoinPool.invoke(simpleRecursiveAction);
    }
}

