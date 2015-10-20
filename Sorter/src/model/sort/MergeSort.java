package model.sort;

public class MergeSort extends Sort implements iMergeSort {
    private static int[] a;

    @Override
    int[] sortAlgorithm(int[] array) {
        a = array;
        int[] tempArray = new int[a.length];
        mergeSort(tempArray, 0, a.length - 1);
        return a;
    }

    static void mergeSort(int []tempArray,int lowerIndex,int upperIndex){
        if(lowerIndex == upperIndex){
            return;
        }else{
            int mid = (lowerIndex+upperIndex)/2;
            mergeSort(tempArray, lowerIndex, mid);
            mergeSort(tempArray, mid+1, upperIndex);
            merge(tempArray,lowerIndex,mid+1,upperIndex);
        }
    }

    public static void merge(int []tempArray,int lowerIndexCursor,int higherIndex,int upperIndex){
        int tempIndex=0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higherIndex-1;
        int totalItems = upperIndex-lowerIndex+1;
        while(lowerIndex <= midIndex && higherIndex <= upperIndex){
            if(a[lowerIndex] < a[higherIndex]){
                tempArray[tempIndex++] = a[lowerIndex++];
            }else{
                tempArray[tempIndex++] = a[higherIndex++];
            }
        }

        while(lowerIndex <= midIndex){
            tempArray[tempIndex++] = a[lowerIndex++];
        }

        while(higherIndex <= upperIndex){
            tempArray[tempIndex++] = a[higherIndex++];
        }

        for(int i=0;i<totalItems;i++){
            a[lowerIndexCursor+i] = tempArray[i];
        }
    }
}