import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by kuzin on 15.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr=new int[1];
        Random random=new Random();

        for (int i = 0; i < 10; i++) {
            arr[i]=random.nextInt();
            arr=Arrays.copyOf(arr,arr.length+1);
        }
        MergeSort ms=new MergeSort();
        try {
            arr=ms.sort(arr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
