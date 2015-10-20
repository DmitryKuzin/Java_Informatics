package model.sort;

public interface iQuickSort extends iSort {
    int partition(int arr[], int left, int right);

    int[] quickSort(int arr[], int left, int right);

}
