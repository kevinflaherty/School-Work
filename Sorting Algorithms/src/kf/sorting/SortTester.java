package kf.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * SortTester class is used to test the different sorting algorithms on various array sizes.
 * @author Kevin Flaherty
 * CS3 Lab 8
 * 12/3/2014
 *
 */
public class SortTester {
	
	/**
	 * main method sorts and prints arrays for each algorithm.  Then displays a table of the number of comparisons
	 * for different array sizes.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		Insert insert = new Insert();
		Mergesort merge = new Mergesort();
		Select select = new Select();
		Heapsort heap = new Heapsort();
		Quicksort quick = new Quicksort();
		int[] in = new int[100];
		int[] m = new int[100];
		int[] s = new int[100];
		int[] q = new int[100];
		int[] h = new int[100];
		for(int i =0; i <100; i++) {
			in[i] = r.nextInt(100);
			m[i] = r.nextInt(100);
			s[i] = r.nextInt(100);
			q[i] = r.nextInt(100);
			h[i] = r.nextInt(100);
		}
		System.out.println("Insert Sort:");
		for(int i = 0; i < in.length; i++) {
			System.out.print(" " + in[i]);
		}
		System.out.println( "\n Sorted: ");
		doSort(insert, in);
		
		for(int i = 0; i < in.length; i++) {
			System.out.print(" " + in[i]);
		}
		System.out.println("\n -----------------------------------------------------------");
		System.out.println("Merge Sort:");
		for(int i = 0; i < m.length; i++) {
			System.out.print(" " + m[i]);
		}
		System.out.println( "\n Sorted: ");
		doSort(merge, m);
		
		for(int i = 0; i < m.length; i++) {
			System.out.print(" " + m[i]);
		}
		System.out.println("\n -----------------------------------------------------------");
		System.out.println("Selection Sort:");
		for(int i = 0; i < s.length; i++) {
			System.out.print(" " + s[i]);
		}
		System.out.println( "\n Sorted: ");
		doSort(select, s);
		
		for(int i = 0; i < s.length; i++) {
			System.out.print(" " + s[i]);
		}
		
		System.out.println(" \n -----------------------------------------------------------");
		System.out.println("Quick Sort:");
		for(int i = 0; i < q.length; i++) {
			System.out.print(" " + q[i]);
		}
		System.out.println( "\n Sorted: ");
		doSort(quick, q);
		
		for(int i = 0; i < q.length; i++) {
			System.out.print(" " + q[i]);
		}
		
		System.out.println("\n -----------------------------------------------------------");
		System.out.println("Heap Sort:");
		for(int i = 0; i < h.length; i++) {
			System.out.print(" " + h[i]);
		}
		System.out.println( "\n Sorted: ");
		doSort(heap, h);
		
		for(int i = 0; i < h.length; i++) {
			System.out.print(" " + h[i]);
		}
		// Comparisons Table
		int [] in1 = new int[1000];
		int [] in2 = new int[2000];
		int[] in3 = new int[3000];
		int[] in4 = new int[4000];
		int[] in5 = new int[5000];
		int[] in6 = new int[6000];
		int[] in7 = new int[7000];
		int[] in8 = new int[8000];
		int[] in9 = new int[9000];
		int[] in10 = new int[10000];
		
		for (int i = 0; i < 1000; i++) {
			in1[i] = r.nextInt(1000);
		}
		for (int i = 0; i < 2000; i++) {
			in2[i] = r.nextInt(2000);
		}
		for (int i = 0; i < 3000; i++) {
			in3[i] = r.nextInt(3000);
		}
		for (int i = 0; i < 4000; i++) {
			in4[i] = r.nextInt(4000);
		}
		for (int i = 0; i < 5000; i++) {
			in5[i] = r.nextInt(5000);
		}
		for (int i = 0; i < 6000; i++) {
			in6[i] = r.nextInt(6000);
		}
		for (int i = 0; i < 7000; i++) {
			in7[i] = r.nextInt(7000);
		}
		for (int i = 0; i < 8000; i++) {
			in8[i] = r.nextInt(8000);
		}
		for (int i = 0; i < 9000; i++) {
			in9[i] = r.nextInt(9000);
		}
		for (int i = 0; i < 10000; i++) {
			in10[i] = r.nextInt(10000);
		}
		
		//Alot of arrays
		int [] m1 = Arrays.copyOf(in1, 1000);
		int [] s1 = Arrays.copyOf(in1, 1000);
		int [] q1 = Arrays.copyOf(in1, 1000);
		int [] h1 = Arrays.copyOf(in1, 1000);
		int [] m2 = Arrays.copyOf(in2, 2000);
		int [] s2 = Arrays.copyOf(in2, 2000);
		int [] q2 = Arrays.copyOf(in2, 2000);
		int [] h2 = Arrays.copyOf(in2, 2000);
		int [] m3 = Arrays.copyOf(in3, 3000);
		int [] s3 = Arrays.copyOf(in3, 3000);
		int [] q3 = Arrays.copyOf(in3, 3000);
		int [] h3 = Arrays.copyOf(in3, 3000);
		int [] m4 = Arrays.copyOf(in4, 4000);
		int [] s4 = Arrays.copyOf(in4, 4000);
		int [] q4 = Arrays.copyOf(in4, 4000);
		int [] h4 = Arrays.copyOf(in4, 4000);
		int [] m5 = Arrays.copyOf(in5, 5000);
		int [] s5 = Arrays.copyOf(in5, 5000);
		int [] q5 = Arrays.copyOf(in5, 5000);
		int [] h5 = Arrays.copyOf(in5, 5000);
		int [] m6 = Arrays.copyOf(in6, 6000);
		int [] s6 = Arrays.copyOf(in6, 6000);
		int [] q6 = Arrays.copyOf(in6, 6000);
		int [] h6 = Arrays.copyOf(in6, 6000);
		int [] m7 = Arrays.copyOf(in7, 7000);
		int [] s7 = Arrays.copyOf(in7, 7000);
		int [] q7 = Arrays.copyOf(in7, 7000);
		int [] h7 = Arrays.copyOf(in7, 7000);
		int [] m8 = Arrays.copyOf(in8, 8000);
		int [] s8 = Arrays.copyOf(in8, 8000);
		int [] q8 = Arrays.copyOf(in8, 8000);
		int [] h8 = Arrays.copyOf(in8, 8000);
		int [] m9 = Arrays.copyOf(in9, 9000);
		int [] s9 = Arrays.copyOf(in9, 9000);
		int [] q9 = Arrays.copyOf(in9, 9000);
		int [] h9 = Arrays.copyOf(in9, 9000);
		int [] m10 = Arrays.copyOf(in10, 10000);
		int [] s10 = Arrays.copyOf(in10, 10000);
		int [] q10 = Arrays.copyOf(in10, 10000);
		int [] h10 = Arrays.copyOf(in10, 10000);
		
		
		int nLogn = (int) ((int)1000*Math.log10(1000));
		
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("     N   insertsort  selectionsort   mergesort   quicksort   heapsort   NlogN   ");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("   1000     |"+ doSort(insert, in1)+"      |"+ doSort(select, s1)+ "        |"+doSort(merge,m1)+ "       |" + doSort(quick,q1)+ "       |"+ doSort(heap, h1)+ "      |"+(int) ((int)1000*Math.log(1000)));
		System.out.println("   2000     |"+ doSort(insert, in2)+"      |"+ doSort(select, s2)+ "       |"+doSort(merge,m2)+ "      |" + doSort(quick,q2)+ "       |"+ doSort(heap, h2)+ "      |"+(int) ((int)2000*Math.log(2000)));
		System.out.println("   3000     |"+ doSort(insert, in3)+"     |"+ doSort(select, s3)+ "       |"+doSort(merge,m3)+ "      |" + doSort(quick,q3)+ "       |"+ doSort(heap, h3)+ "      |"+(int) ((int)3000*Math.log(3000)));
		System.out.println("   4000     |"+ doSort(insert, in4)+"     |"+ doSort(select, s4)+ "       |"+doSort(merge,m4)+ "     |" + doSort(quick,q4)+ "       |"+ doSort(heap, h4)+ "      |"+(int) ((int)4000*Math.log(4000)));
		System.out.println("   5000     |"+ doSort(insert, in5)+"     |"+ doSort(select, s5)+ "      |"+doSort(merge,m5)+ "     |" + doSort(quick,q5)+ "       |"+ doSort(heap, h5)+ "     |"+(int) ((int)5000*Math.log(5000)));
		System.out.println("   6000     |"+ doSort(insert, in6)+"     |"+ doSort(select, s6)+ "      |"+doSort(merge,m6)+ "     |" + doSort(quick,q6)+ "      |"+ doSort(heap, h6)+ "     |"+(int) ((int)6000*Math.log(6000)));
		System.out.println("   7000     |"+ doSort(insert, in7)+"    |"+ doSort(select, s7)+ "      |"+doSort(merge,m7)+ "     |" + doSort(quick,q7)+ "      |"+ doSort(heap, h7)+ "     |"+(int) ((int)7000*Math.log(7000)));
		System.out.println("   8000     |"+ doSort(insert, in8)+"    |"+ doSort(select, s8)+ "      |"+doSort(merge,m8)+ "     |" + doSort(quick,q8)+ "      |"+ doSort(heap, h8)+ "     |"+(int) ((int)8000*Math.log(8000)));
		System.out.println("   9000     |"+ doSort(insert, in9)+"    |"+ doSort(select, s9)+ "      |"+doSort(merge,m9)+ "     |" + doSort(quick,q9)+ "      |"+ doSort(heap, h9)+ "     |"+(int) ((int)9000*Math.log(9000)));
		System.out.println("   10000    |"+ doSort(insert, in10)+"    |"+ doSort(select, s10)+ "      |"+doSort(merge,m10)+ "     |" + doSort(quick,q10)+ "      |"+ doSort(heap, h10)+ "     |"+(int) ((int)10000*Math.log(10000)));
	}
	
	/**
	 * Calls the sort method of each of the sorter algorithms.
	 * @param sorter Object that implements Sorter interface
	 * @param data Array to sort
	 * @return comparisons 
	 */
	private static int doSort(Sorter sorter, int[] data) {
		return sorter.sort(data, 0, data.length);
	}
	
}
