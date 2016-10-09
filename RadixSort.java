/* Kyle Green
 * CSC 364-001
 * 
 * For every iteration, n is multiplied by ten and the elements are reassigned
 * to new buckets until this process has been done for ten digits, producing a sorted array.
 */

import java.util.ArrayList;

public class RadixSort
{
	public static void radixSort(int[] array)
	{
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();

		// Create the buckets
		for(int i = -9; i <= 9; i++)
		{
			ArrayList<Integer> bucket = new ArrayList<Integer>();
			buckets.add(bucket);
		}

		int d = 1;
		for(int j = d; j <= 10; j++)
		{
			// Bucketize
			for(int i = 0; i < array.length; i++)
			{
				int k = array[i] / d % 10 + 9;
				buckets.get(k).add(array[i]);
			}
			//put back into the array every iteration
			int count = 0;
			for(int i = 0; i < buckets.size(); i++)
			{
				int size = buckets.get(i).size();
				for(int m = 0; m < size; m++)
				{
					array[count] = buckets.get(i).get(m);
					count++;
				}
				buckets.get(i).clear();
			}
			d *= 10;
		}
	}
}
