/* Kyle Green
 * CSC 364-001
 * 
 * A tree structure algorithm where the left branches of the trees are filled in first and no child
 * branch can have a greater value than that of its parent. Swaps the root of the heap
 * (the greatest element) with the end of the array, reorganizes the heap and repeats this
 * process until the array is sorted.
 */
public class InPlaceIntHeapSort {

	public static void heapSort(int[] array)
	{
		// Turn the array into a max-heap
		for(int i = 0; i < array.length; i++)
		{
			// "Sift up" element at index i
			int index = i;
			while (index > 0)
			{
				int parentIndex = (index - 1) / 2;
				int parent = array[parentIndex];
				int element = array[index];

				if(parent >= element)
					break;

				array[index] = parent;
				array[parentIndex] = element;
				index = parentIndex;
			}
		}

//		 Repeatedly extract the max element from the heap
		for(int i = array.length - 1; i > 0; i--)
		{
			// The BIG swap!
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// Sift down element at index 0
			int parentIndex = 0;
			
			// in while loop, check if the children are greater and check out of bounds against i
			while(i > 1)
			{
				int childIndex;
				//left child
				int leftChildIndex = 2 * parentIndex + 1;
				if(leftChildIndex >= i)
					break;
				
				//right child
				int rightChildIndex = 2 * parentIndex + 2;
				
				// assign child index
				if (rightChildIndex >=i || array[leftChildIndex] >= array[rightChildIndex])
					childIndex = leftChildIndex;
				else
					childIndex = rightChildIndex;
				
				int parent = array[parentIndex];
				int child = array[childIndex];
				
				if(parent >= child)
					break;
				array[parentIndex] = child;
				array[childIndex] = parent;
				parentIndex = childIndex;
			}
		}
	}
}
