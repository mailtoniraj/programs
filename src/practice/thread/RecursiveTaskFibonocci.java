package practice.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskFibonocci extends RecursiveTask<Integer> {

    private int n;

    public RecursiveTaskFibonocci(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {

        // F(0) = F(1) = 0
        if(n <= 1)
            return n;

        RecursiveTaskFibonocci fib1 = new RecursiveTaskFibonocci(n-1);
        RecursiveTaskFibonocci fib2 = new RecursiveTaskFibonocci(n-2);

        fib1.fork();
        fib2.fork();

        return fib1.join()+ fib2.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new RecursiveTaskFibonocci(4)));
    }
}

