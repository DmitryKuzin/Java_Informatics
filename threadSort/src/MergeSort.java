import java.util.Arrays;

/**
 * Created by kuzin on 15.11.2015.
 */
public class MergeSort {

    private static volatile int[] array1;
    private static volatile int[] array2;

    public int[] sort(int[] arr) throws InterruptedException {
        int[] array1=new int[5];
        int[] array2=new int[6];
        for (int i = 0; i < arr.length; i++) {
            if(i>4){
                array2[i-5]=arr[i];
            }else{
                array1[i]=arr[i];
            }

        }
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1.length-1; j++) {
                        if(array1[j]>array1[j+1]){
                            int buff=array1[j];
                            array1[j]=array1[j+1];
                            array1[j+1]=buff;
                        }
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    for (int j = 0; j < array2.length-1; j++) {
                        if(array2[j]>array2[j+1]){
                            int buff=array2[j];
                            array2[j]=array2[j+1];
                            array2[j+1]=buff;
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.sleep(1000);
        return merge(sortBubble(array1),sortBubble(array2));


    }

    public int[] sortBubble(int[] array){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length-1; j++) {
                        if(array[j]>array[j+1]){
                            int buff=array[j];
                            array[j]=array[j+1];
                            array[j+1]=buff;
                        }
                    }
                }
            }
        });
        t1.start();
        while(t1.isAlive()){

        }
        return array;
    }

    private int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

}
