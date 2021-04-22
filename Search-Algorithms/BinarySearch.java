/*
 * @Author: Yixing
 * @Date: 2021-03-13 20:52:24
 * @Description: Binary Search Algorithms
 */

import java.util.Arrays;


public class BinarySearch {
    // while loop
    public static int search(int[] arr, int tg){
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int first = 0, last = arr.length - 1;
        while(last>=first){
            int mid = (int)Math.floor((first + last) / 2);
            if(tg == arr[mid]){
                System.out.println("The number is found!");
                return -1;
            }
            else if(tg < arr[mid]){
                last = mid -1;
            }
            else
                first = mid + 1;
        }
        System.out.println("The number is not found!");
        return 0;
    }
    // Recursive Binary Search
    public static boolean RecurBinarySearch(int[] arr, int first, int last, int tg){
        if(first>last){
            return false;
        }
        else{
            int mid = (int)((first + last) / 2);
            if(arr[mid] == tg){
                return true;
            }
            else if(tg > arr[mid]){
                return RecurBinarySearch(arr, mid + 1, last, tg);
            }
            else{
                return RecurBinarySearch(arr, first, mid - 1, tg);
            }
        }
    }
    
    public static void main(String[] args){
        int[] arr = {1, 3, 1, 3};
        search(arr, 2);
        System.out.println(RecurBinarySearch(arr, 0, 3, 2));
    }
}
