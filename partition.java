import java.lang.Object;

public class partition{
    /*Choose a random pivot element, and modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding 
 *   element is designated the pivot element. 
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

    public static int partition (int [] data, int start, int end){
	int[] cut = new int[end - start];
	//	int pivot = data[start + (int)(Math.random() * (end - start))];
	int pivot = data[4];
        cut[0] = pivot;
	int small = 1;  // index of cut
	int s = start;  // index of data
	int large = cut.length - 1;
	int l = end;
	int a;
	int b;
        while (small < large){
	    a = data[s + small - 1];
	    System.out.println(a);
	    if (a < pivot){
		cut[small] = a;
		small++;
	    }
	    b = data[l];
	    if (b > pivot){
		cut[large] = b;
		large--;
		l--;
	    }
	    else{
		cut[small] = b;
		cut[large] = a;
		small++;
		large--;
	    }
	}
	String m = "";
	for (int i = 0; i < cut.length; i++){
	    m += cut[i];
	    m += " ";
	}
	System.out.println(m);
	System.out.println(pivot);
	
	return large;
    }

    public static void main(String[] args){
	int[] ary = {2, 10, 5, 8, 7, 2, 4, 9, 11, 6};
	System.out.println(partition(ary, 2, 9));
    }
}
