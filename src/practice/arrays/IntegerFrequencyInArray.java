package practice.arrays;

public class IntegerFrequencyInArray {

    public static void main(String[] args) {
      int[] array = {2,3,4,2,3,6,6,7};

        System.out.println(countFrequency(array,3));
    }

    static int countFrequency(int[] array,int x){

        int count =0;

        for(int i=0;i<array.length;i++){
            if(array[i]==x)
                 ++count;

        }
        return count;
    }
}
