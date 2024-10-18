/** Program description
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 4, 2024 
*/
/*  
* OS: Win 11
* IDE: Eclipse 2024-06
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
package dmacc.edu;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 
 */
public class SearchAndSort {

	/**
	 * @param arr array of integers
	 * @param x number searching for
	 * @return true if number was found
	 * BigO = O(N) 
	 * This method searches an array of integers to find x using linear search
	 * linear search starts at the head of the list and iterates till it finds x
	 * or till it hits the end of the list  
	 * this code was taken from "https://www.geeksforgeeks.org/linear-search/"
	 */
	public static String search(int arr[], int x) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			if (arr[i] == x)
				return "found";
		}
		return "not found";
	}

	/**
	 * @param arr array of integers
	 * @param x number searching for
	 * @return true if number was found
	 * BigO = O(N) 
	 * This method searches an array of sorted integers to find x using binary search.
	 * binary search works by comparing the midpoint of a sorted list to x
	 * if x is smaller then it compares x to the midpoint of the front half of the list. If x is larger
	 * then it compares x to the midpoint of the back half of the list. 
	 * this code was taken from "https://www.geeksforgeeks.org/linear-search-vs-binary-search/"
	 */
	public static String binary(int[] arr, int x) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (x == arr[mid]) {
				return "found";
			} else if (x > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return "not found";
	}
	

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.000000");
		int arr[] = new int[420000];
		int len = arr.length;
		Random rand = new Random();
		for(int i = 0; i < len; i++) {
			arr[i] = rand.nextInt(500000);
		}
		/*for(int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}*/
		System.out.println(search(arr, 152));
		// the following selection sort code was taken from
		// https://www.geeksforgeeks.org/insertion-sort-algorithm/
		long startSort = System.nanoTime();
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long endSort = System.nanoTime();
        /*for(int x = 0; x < len; x++) {
			System.out.println(arr[x]);
		}*/
        double duration;
        System.out.println(binary(arr, 152));
        duration = (endSort - startSort) / 1.0e9;
        System.out.println("insertion sort 420,000: " + df.format(duration));
	}

}
