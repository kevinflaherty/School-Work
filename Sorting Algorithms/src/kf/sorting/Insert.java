package kf.sorting;

/******************************************************************************
* The <CODE>Insert</CODE> Java application illustrates an insertion sort.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/Insert.java">
*   http://www.cs.colorado.edu/~main/applications/Insert.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class Insert implements Sorter
{
   /**
   * The main method illustrates the use of an insertion sort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public Insert(){}
   
   
   /**
   * Sort an array of integers from smallest to largest, using an insertion sort
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
   public void insertionsort(int[ ] data, int first, int n)
   {
      int i, j;   // Loop control variables
      int entry;  // The element that is currently being inserted
         
      for (i = 1; i < n; i++)
      {
         entry = data[first+i];
         for (j = first+i; (j>first) && (data[j-1] > entry); j--) {
            data[j] = data[j-1]; 
            comparisons++;
         }
         data[j] = entry;   
         if(j != first) 
        	 comparisons++;
      }
  } 

    public int sort(int [] data, int first, int n) {
	  insertionsort(data,first,n);
	  int x = comparisons;
	  comparisons = 0;
	  return x;
  }
   
  public int getComparisons() {
	  return comparisons;
  }
  
   private int comparisons = 0;
}

