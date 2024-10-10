package practice.arrays;

public class MoveNegativeNumbers {

    public static void main(String[] args) {
        int[] array= {-1,2,3,-6,-5,6,8,-5};

        moveNegativeNumber(array);

    }
 static void moveNegativeNumber(int[] array){

        int leftMostNumber = 0;

        for(int i= 0;i<array.length;i++){

            if(array[i]<0){
                if(array[i] != array[leftMostNumber]){
                    int temp = array[i];
                    array[i] = array[leftMostNumber];
                    array[leftMostNumber] = temp;
                }
                ++leftMostNumber;
            }
        }

        for(int i= 0;i<array.length;i++)
            System.out.print(array[i]+" ");

}

}
