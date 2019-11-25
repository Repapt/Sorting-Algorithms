package sorter;
/*
 * Author: Samuel Liu
 * Teacher: Mr. Radulovic
 * 2019/03/31
 * Main method used to test and time the sorting algorithms.
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random(1);
		int size = (int)Math.pow(2, 15);
		
		int[] list = new int[size];
		//Populates array with random integers
		for(int i=0;i<size;i++) {
			list[i] = rand.nextInt();
		}
		
		
		IntegerSorter s = new IntegerSorter();
		
		s.setList(list);
		//System.out.println(s);
		long time1 = System.nanoTime();
		s.sort(1);
		long time2 = System.nanoTime();
		//System.out.println(s);
		System.out.println(time2-time1); 
		
		

	}

}
