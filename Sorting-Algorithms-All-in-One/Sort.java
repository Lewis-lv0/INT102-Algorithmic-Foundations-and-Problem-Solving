/*
 * @Author: Yixing
 * @Date: 2021-03-24 10:59:14
 * @Description: Sorting Algorithms taught in INT102
 */


import java.util.Arrays;


public class Sort {
    /**
     * @description: Selection Sort
     * @param {int[]} arr
     * @return {*}
     */
    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 倒数第二个
            int min = i;
            for (int j = i + 1; j < arr.length; j++) { // 最后一个
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * @description: Bubble Sort
     * @param {int[]} arr
     * @return {*}
     */
    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }


    /**
     * @description: Insertion Sort
     * @param {int[]} arr
     * @return {*}
     */
    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**Merge Sort
     * @description: sort array arr[0,...,n-1] into ascending order 
     * input: an array int[] arr
     * output: a sorted array (ascending order)
     * @param {int[]} arr
     * @return {*}
     */
    public static void MergeSort(int[] arr) {
        int len = arr.length;
        if (len > 1) {
            int mid = (len - 1) / 2;
            int[] B = new int[mid + 1];
            int[] C = new int[len - mid - 1];
            for (int i = 0; i < mid + 1; i++) {
                B[i] = arr[i];
            }
            for (int j = 0; j < len - mid - 1; j++) {
                C[j] = arr[mid + 1 + j];
            }
            MergeSort(B); // sort the left half
            MergeSort(C); // sort the right half
            Merge(B, C, arr); // merge the two halves
        }
    }

    /**
     * @description: Merge two sorted arrays into one sorted array 
     * input: two sorted array B and C
     * output: sorted array A of elements from B and C
     * @param {*}
     * @return {*}
     */    
    // conquer
    private static void Merge(int[] B, int[] C, int[] A) {
        /*
         * 
         */
        int i = 0, j = 0, k = 0; // i points to position in B, j to C and k to A
        while (i < B.length && j < C.length) {
            if (B[i] <= C[j]) {
                A[k] = B[i];
                i++;
            } else {
                A[k] = C[j];
                j++;
            }
            k++;
        }
        for (int m = k; m < A.length; m++) {
            if (i == B.length) {
                A[m] = C[j];
                j++;
            } else {
                A[m] = B[i];
                i++;
            }
        }
    }

    /**
     * @description: Counting Sort for integers
     * @param {int[]} arr
     * @return {*}
     */
    public static void CountingSort(int[] arr) {
        // special case
        if(arr == null || arr.length<=1){
            return;
        }

        int max = arr[0], min = arr[0];

        // find the maximum and minimum number in the array
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            else if(arr[i]<min){
                min = arr[i];
            }
            else{
                // this condition won't occur
            }
        }

        // create a new array for counting occurences
        int length = max - min + 1;
        int[] arr_count = new int[length];

        // compute frequency
        // arr_count is continuous
        for(int i=0;i<arr.length;i++){
            arr_count[arr[i]-min]++;
        }

        // take sum
        for(int i=0;i<length-1;i++){
            arr_count[i+1] += arr_count[i];
        }

        // sort
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[arr_count[arr[i]-min]-1] = arr[i];
            arr_count[arr[i]-min]--;
        }
        // assign back to arr
        for(int i=0;i<arr.length;i++){
            arr[i] = res[i];
        }
    }


    /**
     * @description: Counting Sort for characters
     * @param {char[]} arr
     * @return {*}
     */
    public static void CountingSort_Char(char[] arr) {
        if(arr == null || arr.length<=1){
            return;
        }
        // find the max and min
        char max = arr[0], min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            else if(arr[i]<min){
                min = arr[i];
            }
        }
        // count
        int[] count = new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++;
        }
        // take sum
        for(int i=0;i<count.length-1;i++){
            count[i+1] += count[i];
        }
        // sort
        char[] res = new char[arr.length];
        for(int i=0;i<arr.length;i++){
            res[count[arr[i]-min]-1] = arr[i];
            count[arr[i]-min]--;
        }
        // assign back to arr
        for(int i=0;i<arr.length;i++){
            arr[i] = res[i];
        }
    }



    // test demo
    public static void main(String[] args) {
        char[] arr = {'a','b','a','c'};
        CountingSort_Char(arr);
        System.out.println(Arrays.toString(arr));
    }

}
