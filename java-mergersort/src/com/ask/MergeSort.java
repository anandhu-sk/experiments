package com.ask;

class MergeSort {

    public static void merge(int[] array) {
        int temp[] = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
        int i = 0;
        while (i < array.length) {
            System.out.println(array[i]);
            i++;
        }
    }

    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, mid);
        mergeSort(array, temp, mid + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int array[], int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        while (left <= leftEnd) {
            temp[index] = array[left];
            left++;
            index++;
        }
        while (right <= rightEnd) {
            temp[index] = array[right];
            right++;
            index++;
        }

        int i = leftStart;

        while (i <= rightEnd) {
            array[i] = temp[i];
            i++;
        }
    }

    public static void main(String args[]) {
        int a[] = {4, 3, 1, 1234, 12, 3,33,3131,65656,7564,334,66,4333,886,234,55,60023, 2};
        merge(a);
    }
}
