package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length == 1){
		}
		else{
			T[] arr1 = Arrays.copyOfRange(array, leftIndex, (leftIndex + rightIndex)/2);
			T[] arr2 = Arrays.copyOfRange(array, ((leftIndex + rightIndex)/2) + 1, rightIndex);
			sort(arr1, leftIndex, (rightIndex + leftIndex)/2);
			sort(arr2, ((rightIndex + leftIndex)/2) + 1, rightIndex);
			merge(arr1, arr2);
		}
		
	}

	public List<T> merge(T[] left, T[] right){
		ArrayList<T> ls = new ArrayList<T>();

		int leftIndex = 0;
		int rightIndex = 0;
		while(leftIndex < left.length && rightIndex < right.length){
			if(left[leftIndex].compareTo(right[rightIndex]) <= 0){
				ls.add(left[leftIndex]);
				leftIndex++;
			}
			else{
				ls.add(right[rightIndex]);
				rightIndex++;
			}
		}

		if(leftIndex < left.length){
			for(int i = leftIndex; i < left.length; i++){
				ls.add(left[i]);
			}
		}
		if(rightIndex < right.length){
			for(int i = rightIndex; i < right.length; i++){
				ls.add(right[i]);
			}
		}

		return ls;
	}

}
