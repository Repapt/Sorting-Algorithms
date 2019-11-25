package sorter;

/*
 * Author: Samuel Liu
 * Teacher: Mr. Radulovic
 * 2019/03/31
 * Representation of a sorter that contains an int array. The array can be changed or
 * sorted using three different sorting methods; bubble, selection, and merge.
 */
import java.util.*;

public class IntegerSorter implements Sorter{
	
	private int[] list;

	public void setList(int[] list) {
		
		this.list = new int[list.length];
		for(int i=0;i<list.length; i++) {
			this.list[i] = list[i];
		}
		
	}

	public void sort(int type) { //type determines which sorting algorithm to use
		if(type == 1) {
			sort_method1(list);
		} else if (type == 2) {
			sort_method2(list);
		} else if (type == 3) {
			sort_method3(list);
		}
	}
	
	private void sort_method1(int[] list) { //bubble
		for(int i=list.length-1; i>=0; i--) {
			for(int j=0; j<i;j++) {
				if(list[j] > list[j+1]) {
					int temp = list[j+1];
					list[j+1] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	private void sort_method2(int[] list) { //selection
		for(int i=0;i<list.length-1; i++) { 
			for(int j=i+1; j<list.length;j++) {
				if(list[i] > list[j]) {
					int temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}
	
	private void sort_method3(int[] list) { //merge
		
		this.list = mergeSort(list);
		
		
	}
	
	
	private int[] mergeSort(int[] list) {
		if(list.length > 1) { //mergeSort is recursively called until list length is 1
			
			int mid = list.length/2;
			
			//Creates two arrays of equal length
			int[] A1 = Arrays.copyOfRange(list, 0, mid);
			int[] A2 = Arrays.copyOfRange(list, mid, list.length);
			
			//Once the arrays are of size 1, combineArray can be executed to combine them
			return combineArray(mergeSort(A1), mergeSort(A2));
		}
		
		return list;
	}
	
	private int[] combineArray(int[] A, int[] B) {
		
		
		//Marks where we are in each array
		int countA = 0;
		int countB = 0;
		int[] C = new int[A.length + B.length];
		
		for(int i=0;i<C.length;i++) { //Runs for every index in array C
			
			//Assigns elements in either A or B to the next index in array C
			//If an array element is assigned, the counter for that array is increased by one
			if(countA == A.length) { //If array A is depleted
				C[i] = B[countB];
				countB ++;
			} else if (countB == B.length) { //If array B is depleted
				C[i] = A[countA];
				countA ++;
			} else if (A[countA] <= B[countB]) { //If the element in array A is smaller
				C[i] = A[countA];
				countA++;
			} else if (A[countA] > B[countB]) { //If the element in array B is smaller
				C[i] = B[countB];
				countB++;
			}
		}
		
		return C;
		
	}
	
	public String toString() {
		String toRet = "";
		//Runs through list, adds every element to toRet
		for(int i=0;i<list.length; i++) {
			toRet += list[i] + ", ";
		}
	
		return toRet.substring(0,toRet.length()-2); //Returns list without final ", "
	}

}
