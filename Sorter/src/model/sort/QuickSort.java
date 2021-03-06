package model.sort;

public class QuickSort extends Sort implements iQuickSort {

    @Override
    int[] sortAlgorithm(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }
    @Override
    public int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }
    @Override
    public int[] quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            return quickSort(arr, left, index - 1);
        if (index < right)
            return quickSort(arr, index, right);
        return arr;
    }
}
