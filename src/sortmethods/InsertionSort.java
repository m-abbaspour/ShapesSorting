package sortmethods;

import java.util.Comparator;

public class InsertionSort { 
	  public static <T> void sort(Comparable<T>[] list) {
		    for (int i = 1; i < list.length; i++) { 
		    	Comparable<T> shape = list[i];
		      int j = i; 
		      while ( j > 0 && list[j-1].compareTo((T) shape) < 0 ){
		    	  list[j ] = list[j-1];
		    	  j--;
		      }
		      list[j] = shape;
		    }
		  }
		  
	  public static <T> void sort(Comparable<T>[] list,  Comparator<? super T> type) {
		  if (type != null) {
		    for (int i = 1; i < list.length; i++) { 
		    	Comparable<T> shape = list[i];
		      int j = i; 
		      while ( j > 0 && type.compare((T) list[j-1], (T) shape) < 0 ){
		    	  list[j ] = list[j-1];
		    	  j--;
		      }
		      list[j] = shape;
		    }
		  } else {
			  sort(list);
		  }
	  }
}
