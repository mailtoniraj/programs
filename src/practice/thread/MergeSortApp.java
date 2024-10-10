package practice.thread;

import java.util.Random;
import practice.thread.ParallelMergeSort;

public class MergeSortApp {

	public static Random random = new Random();
	
	public static void main(String[] args) throws Throwable {
		int numOfThreads  = Runtime.getRuntime().availableProcessors();

			int[] numbers = createRandomArray();
		PrintArray(numbers);
		ParallelMergeSort mergeSort = new ParallelMergeSort(numbers,numOfThreads);
		mergeSort.parallelMergeSort(numbers,numOfThreads);
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		PrintArray(numbers);

		
	}
	
	public static int[] createRandomArray() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = random.nextInt(10000);			
		}
		return a;
	}

	public static void  PrintArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
