package kf.sorting;

/******************************************************************************
* The <CODE>Heapsort</CODE> Java application illustrates a heapsort.
* Part of the implementation (the <CODE>makeHeap</CODE> and
* <CODE>reheapifyDown</CODE> methods) is left
* as a student exercise.
*
* <p><dt><b>Java Source Code for this class (without 
* <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>:</b><dd>
*   <A HREF="../applications/Heapsort.java">
*   http://www.cs.colorado.edu/~main/applications/Heapsort.java
*   </A>
*
* @author Michael Main and (___student name___) 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class Heapsort implements Sorter
{
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>.
   * Sort an array of integers from smallest to largest, using a heapsort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort, (from <CODE>data[0]</CODE> 
   *   through <CODE>data[n-1]</CODE>)
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data</CODE> has at least <CODE>n</CODE> elements.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[0] &lt= data[1] &lt= ... &lt= data[n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>data</CODE> has fewer than </CODE>n</CODE> elements.
   * */
   public void heapsort(int[ ] data, int n)
   {
      int unsorted; // Size of the unsorted part of the array
      int temp;     // Used during the swapping of two array locations

      makeHeap(data, n);
      comparisons = 0;
      unsorted = n;

      while (unsorted > 1)
      {
         unsorted--;

         // Swap the largest element (data[0]) with the final element of unsorted part  
         temp = data[0];
         data[0] = data[unsorted];
         data[unsorted] = temp;
         comparisons++;
         reheapifyDown(data, unsorted);
      }
   }
   
   private void makeHeap(int[ ] data, int n)
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
   {      
	  for(int i = 1; i < n; i++) {
		  int k = i;
		  while(k > 0 && data[k] > data[(k-1)/2]) {
			 int temp = data[(k-1)/2];
			 data[(k-1)/2] = data[k];
			 data[k] = temp;
			 k = (k-1)/2;
		  }
	  }
   }

   private void reheapifyDown(int[ ] data, int n)
   // Precondition: n > 0, and data is an array with at least n elements. These
   // elements form a heap, except that data[0] may be in an incorrect
   // location.
   // Postcondition: The data values have been rearranged so that the first
   // n elements of data now form a heap.
   {
      int current = 0;
      int bigChildIndex;
      boolean heapOkay = false;
      
      while(!heapOkay && (current*2+1 < n)) {
    	  if(current*2+2 >= n || data[current*2+1] > data[current*2+2]) { 
    		  bigChildIndex = current*2+1;
    		  comparisons++;
    		  
    	  }
    	  else {
    		  bigChildIndex = current*2+2;
    		  comparisons++;
    	  }
    	  if(data[current] < data[bigChildIndex]) {
    		  int temp = data[current];
    		  data[current] = data[bigChildIndex];
    		  data[bigChildIndex] = temp;
    		  current = bigChildIndex;
    		  comparisons++;
    		  
    	  }
    	  else
    		  heapOkay = true;
      }
      
   }
   public int getComparisons() {
	   return comparisons;
   }
   
   public int sort(int [] data, int first, int n) {
	   heapsort(data,n);
	   int x = comparisons;
	   comparisons = 0;
	   return x;
   }
   private int comparisons;
}