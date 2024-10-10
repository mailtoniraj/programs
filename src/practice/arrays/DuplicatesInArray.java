package practice.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,5,6};
        duplicatesInArray(array);

    }

    private static void duplicatesInArray(int[] array) {
        HashSet<Integer> set = new HashSet<>(array.length);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> enty: map.entrySet()){

            if(enty.getValue()>1){
                set.add(enty.getKey());
            }
        }
        System.out.println(set);

    }
}
