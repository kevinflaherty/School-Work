package kf.sorting;

/******************************************************************************
* The <CODE>Select</CODE> Java application illustrates a selection sort.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/Select.java">
*   http://www.cs.colorado.edu/~main/applications/Select.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class Select implements Sorter
{
   
   /**
   * Sort an array of integers from smallest to largest, using a selection sort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>first</CODE> 
   *   the start index for the portion of the array that will be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data[first]</CODE> through <CODE>data[first+n-1]</CODE> are valid
   *   parts of the array.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[first] &lt= data[first+1] &lt= ... &lt= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public void selectionsort(int[ ] data, int first, int n)
   {
      int i, j; // Loop control variables
      int big;  // Index of largest value in data[first]...data[first+i]
      int temp; // Used during the swapping of two array values
      for (i = n-1; i > 0; i--)
      {  
         // Calculate big as the index of the largest value in data[first]...data[first+i]:
         big = first;
         for (j = first+1; j <= first+i; j++) {
            if (data[big] < data[j])
               big = j;
            comparisons++;
         }
      
         // swap data[first+i] with data[big]:
         temp = data[first+i];
         data[first+i] = data[big];
         data[big] = temp;
      }
   } 
   public int getComparisons() {
	return comparisons;
   }
   
   public int sort(int [] data, int first, int n) {
	   selectionsort(data,first,n);
	   int x = comparisons;
	   comparisons = 0;
	   return x;
   }

private int comparisons = 0;
}

