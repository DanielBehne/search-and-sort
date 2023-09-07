package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        // Your algorithm goes here!
        if (arr.length <= 1) {
            return arr;
        }
        
        int mid = arr.length/2;
        int left[] = new int[mid];
        int right[] = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i-mid] = arr[i];
        }
        
        sort(left);
        sort(right);
        
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[mergeIndex++] = left[leftIndex++];
            } else {
                arr[mergeIndex++] = right[rightIndex++];
            }
        }
        
        while (leftIndex < left.length) {
            arr[mergeIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[mergeIndex++] = right[rightIndex++];
        }
        
        return arr;
    }

    
    
    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr));
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}


