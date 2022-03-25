// Kalrav Srivastava
// ks874
// CS 435
// Fall 2021
import java.util.*;
//import java.time.Duration;
//import java.time.Instant;
//import org.apache.commons.lang3.time.StopWatch;

public class Sort
{
	void merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		int a[] = new int[n1];
		int b[] = new int[n2];

		for (int i = 0; i < n1; ++i)
		{
			a[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j)
		{
			b[j] = arr[m + 1 + j];
		}

		// Initial indexes of first and second subarrays
		int i = 0;
		int j = 0;
		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2)
		{
			Globals.mCnt++;
			if (a[i] <= b[j])
			{
				//mCnt++;
				arr[k] = a[i];
				i++;
			}
			else
			{
				//mCnt++;
				arr[k] = b[j];
				j++;
			}
			k++;
		}
		while (i < n1)
		{
			Globals.mCnt++;
			arr[k] = a[i];
			i++;
			k++;
		}
		while (j < n2)
		{
			Globals.mCnt++;
			arr[k] = b[j];
			j++;
			k++;
		}
		//return mCnt;
	}

	static void random(int arr[], int low, int high)
    {
     
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
         
        int temp = arr[pivot]; 
        arr[pivot] = arr[high];
        arr[high] = temp;
    }
	
	private static int partition(int arr[], int start, int end)
	{
        random(arr, start, end);
        //Random rand = new Random();
        //int pos = rand.nextInt(end - start) + start;
        int pivot = arr[end];
        //int pivot = arr[pos];
        //System.out.println(pivot);
        int i = (start - 1);
        for (int j = start; j < end; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                Globals.qCnt++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //continue;
            }
            //Globals.qCnt++;
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        //Globals.qCnt++;
        return i + 1;
    }

	void heapify(int arr[], int n, int i)// USING MAXHEAP here
    {
        //Globals.hCnt++;
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        int x = 0;
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
		{
			Globals.hCnt++;
            largest = l;
            x++;
		}
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
		{
            Globals.hCnt++;
			largest = r;
			x++;
		}
        // If largest is not root
        if (largest != i)
		{
            x++;
            //Globals.hCnt++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            //Globals.hCnt++;
            heapify(arr, n, largest);
        }
        if (x == 0)
        {
            Globals.hCnt++;
        }
    }

	// mergeSort()
	void mergeSort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = l + (r - l) / 2;
			//Globals.mCnt++;
			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	public void heapSort(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
		{
            //Globals.hCnt++;
            heapify(arr, n, i);
		}
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--)
		{
            // Move current root to end
            //Globals.hCnt++;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            //Globals.hCnt++;
            heapify(arr, i, 0);
        }
    }

	public static void quickSort(int arr[], int start, int end)
	{
        /*int left = start;
        int right = end;
        //if (left >= right)
        //{
        //    return;
        //}
        random(arr, start, end);
        int pivot = arr[end];
        System.out.println(pivot);
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        System.out.println(pivot);
        int l = left + 1;
        int r = right;
        System.out.println(pivot);
        System.out.println(Globals.qCnt);
        while (l <= r)
        {
            while (l <= r && arr[l] <= pivot)
            {
                l++;
                Globals.qCnt++;
            }
            while (l <= r && arr[l] <= pivot)
            {
                r--;
                Globals.qCnt++;
            }
            if (l < r)
            {
                int temp0 = arr[l];
                arr[l] = arr[r];
                arr[r] = temp0;
                l++;
                r--;
            }
        }
        int temp1 = arr[left];
        arr[left] = arr[r];
        arr[r] = temp1;
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);*/
        
        if (start < end)
        {
            Globals.qCnt++;
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            //Globals.qCnt++;
            quickSort(arr, partitionIndex + 1, end);
            //Globals.qCnt++;
        }
        else
        {
            Globals.qCnt++;
        }
    }

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static class Globals
	{
        public static int mCnt = 0;
        public static int hCnt = 0;
        public static int qCnt = 0;
    }

	public static void main(String args[])
	{
		System.out.println("\n******************************| For array of length 32 |******************************");
		int wrstArr0[] = new int[32];
		int wrstArr1[] = new int[32];
		int wrstArr2[] = new int[32];
		for (int i = 0; i < 32; i++)
		{
		    wrstArr0[i] = 32 - i;
		    wrstArr1[i] = 32 - i;
		    wrstArr2[i] = 32 - i;
		}

		System.out.println("\n\nReverse Array:");
		printArray(wrstArr0);

		Sort srt = new Sort();

		long wStart0 = System.nanoTime();
		srt.mergeSort(wrstArr0, 0, wrstArr0.length - 1);
		long wEnd0 = System.nanoTime();
		System.out.println("\nMerge-sorted (for reverse) array:");
		printArray(wrstArr0);
		System.out.println("\nMerge-sorted (for reverse array) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((wEnd0 - wStart0) * 0.000001) + "\n");

		long wStart1 = System.nanoTime();
		srt.heapSort(wrstArr1);
		long wEnd1 = System.nanoTime();
		System.out.println("\nHeap-sorted (for reverse) array:");
		printArray(wrstArr1);
		System.out.println("\nHeap-sorted (for reverse array) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((wEnd1 - wStart1) * 0.000001) + "\n");
		
		long wStart2 = System.nanoTime();
		quickSort(wrstArr2, 0, wrstArr2.length - 1);
		long wEnd2 = System.nanoTime();
		System.out.println("\nQuick-sorted (for reverse array) array:");		
		printArray(wrstArr2);
		System.out.println("\nQuick-sorted (for reverse array) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((wEnd2 - wStart2) * 0.000001) + "\n");

		int avgArr0[] = new int[32];
		int avgArr1[] = new int[32];
		int avgArr2[] = new int[32];
		for (int i = 0; i < 32; i++)
		{
		    int x = 1 + (int)(Math.random() * (32 - 1 + 1));
			avgArr0[i] = x;
		    avgArr1[i] = x;
		    avgArr2[i] = x;
		}
		System.out.println("\n\nRandom array:");
		printArray(avgArr0);
		
		Globals.mCnt = 0;
		Globals.hCnt = 0;
		Globals.qCnt = 0;

		long aStart0 = System.nanoTime();
        srt.mergeSort(avgArr0, 0, avgArr0.length - 1);
        long aEnd0 = System.nanoTime();
		System.out.println("\nMerge-sorted (random) array:");
		printArray(avgArr0);
		System.out.println("\nMerge-sorted (for random array) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((aEnd0 - aStart0) * 0.000001) + "\n");

		long aStart1 = System.nanoTime();
		srt.heapSort(avgArr1);
		long aEnd1 = System.nanoTime();
		System.out.println("\nHeap-sorted (random) array:");
		printArray(avgArr1);
		System.out.println("\nHeap-sorted (for random array) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((aEnd1 - aStart1) * 0.000001) + "\n");

		long aStart2 = System.nanoTime();
		quickSort(avgArr2, 0, avgArr2.length - 1);
		long aEnd2 = System.nanoTime();
		System.out.println("\nQuick-sorted (random) array:");		
		printArray(avgArr2);
		System.out.println("\nQuick-sorted (for random array) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((aEnd2 - aStart2) * 0.000001) + "\n");
		
		int bstArr0[] = new int[32];
		int bstArr1[] = new int[32];
		int bstArr2[] = new int[32];
		for (int i = 0; i < 32; i++)
		{
			bstArr0[i] = i + 1;
		    bstArr1[i] = i + 1;
		    bstArr2[i] = i + 1;
		}
		System.out.println("\n\nSorted array:");
		printArray(bstArr0);
		
		Globals.mCnt = 0;
		Globals.hCnt = 0;
		Globals.qCnt = 0;
		
		long bStart0 = System.nanoTime();
		srt.mergeSort(bstArr0, 0, bstArr0.length - 1);
		long bEnd0 = System.nanoTime();
		System.out.println("\nMerge-sorted (sorted) array:");
		printArray(bstArr0);
		System.out.println("\nMerge-sorted (sorted) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((bEnd0 - bStart0) * 0.000001) + "\n");
		
		long bStart1 = System.nanoTime();
		srt.heapSort(bstArr1);
		long bEnd1 = System.nanoTime();
		System.out.println("\nHeap-sorted (sorted) array:");
		printArray(bstArr1);
		System.out.println("\nHeap-sorted (sorted) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((bEnd1 - bStart1) * 0.000001) + "\n");
		
		long bStart2 = System.nanoTime();
		quickSort(bstArr2, 0, bstArr2.length - 1);
		long bEnd2 = System.nanoTime();
		System.out.println("\nQuick-sorted (sorted) array:");		
		printArray(bstArr2);
		System.out.println("\nQuick-sorted (sorted) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((bEnd2 - bStart2) * 0.000001) + "\n");
        
        int rndArr0[] = new int[1024];
		int rndArr1[] = new int[32768];
		int rndArr2[] = new int[1048576];
		for (int i = 0; i < 1024; i++)
		{
			int x = 1 + (int)(Math.random() * (1024 - 1 + 1));
			rndArr0[i] = x;
		}
		for (int i = 0; i < 32768; i++)
		{
			int x = 1 + (int)(Math.random() * (32768 - 1 + 1));
		    rndArr1[i] = x;
		}
		for (int i = 0; i < 1048576; i++)
		{
			int x = 1 + (int)(Math.random() * (1048576 - 1 + 1));
		    rndArr2[i] = x;
		}
		
		System.out.println("\n********************| For arrays of lengths 1024, 32768 and 1048576 |********************");
		
		Globals.mCnt = 0;
		Globals.hCnt = 0;
		Globals.qCnt = 0;
		
		System.out.println("\n\nFor array of length 1024:");
		printArray(rndArr0);

		long rmStart0 = System.nanoTime();
		srt.mergeSort(rndArr0, 0, rndArr0.length - 1);
		long rmEnd0 = System.nanoTime();
		System.out.println("\nMerge-sorted (sorted) array:");
		printArray(rndArr0);
		System.out.println("\nMerge-sorted (sorted) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rmEnd0 - rmStart0) * 0.000001) + "\n");

		long rhStart0 = System.nanoTime();
		srt.heapSort(rndArr0);
		long rhEnd0 = System.nanoTime();
		//System.out.println("\nHeap-sorted (sorted) array:");
		//printArray(rndArr0);
		System.out.println("\nHeap-sorted (sorted) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rhEnd0 - rhStart0) * 0.000001) + "\n");

		long rqStart0 = System.nanoTime();
		quickSort(rndArr0, 0, rndArr0.length - 1);
		long rqEnd0 = System.nanoTime();
		//System.out.println("\nQuick-sorted (sorted) array:");
		//printArray(rndArr0);
		System.out.println("\nQuick-sorted (sorted) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rqEnd0 - rqStart0) * 0.000001) + "\n");
		
		System.out.println("The arrays (both originally generated and sorted) of lengths 32768 and 1048576 are not printed here to save time.\nThey can be printed by uncommenting the printArray() statements below this print statement in the code (also 2 statements above this).");
		
		Globals.mCnt = 0;
		Globals.hCnt = 0;
		Globals.qCnt = 0;
		
		System.out.println("\n\nFor array of length 32768:");
		//printArray(rndArr1);

		long rmStart1 = System.nanoTime();
		srt.mergeSort(rndArr1, 0, rndArr1.length - 1);
		long rmEnd1 = System.nanoTime();
		//System.out.println("\nMerge-sorted (sorted) array:");
		//printArray(rndArr1);
		System.out.println("\nMerge-sorted (sorted) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rmEnd1 - rmStart1) * 0.000001) + "\n");

		//printArray(rndArr1);
		long rhStart1 = System.nanoTime();
		srt.heapSort(rndArr1);
		long rhEnd1 = System.nanoTime();
		//System.out.println("\nHeap-sorted (sorted) array:");
		//printArray(rndArr1);
		System.out.println("\nHeap-sorted (sorted) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rhEnd1 - rhStart1) * 0.000001) + "\n");

		long rqStart1 = System.nanoTime();
		quickSort(rndArr1, 0, rndArr1.length - 1);
		long rqEnd1 = System.nanoTime();
		//System.out.println("\nQuick-sorted (sorted) array:");		
		//printArray(rndArr1);
		System.out.println("\nQuick-sorted (sorted) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rqEnd1 - rqStart1) * 0.000001) + "\n");
		
		Globals.mCnt = 0;
		Globals.hCnt = 0;
		Globals.qCnt = 0;
		
		System.out.println("\n\nFor array of length 1048576:");
		//printArray(rndArr2);

		long rmStart2 = System.nanoTime();
		srt.mergeSort(rndArr2, 0, rndArr2.length - 1);
		long rmEnd2 = System.nanoTime();
		//System.out.println("\nMerge-sorted (sorted) array:");
		//printArray(rndArr1);
		System.out.println("\nMerge-sorted (sorted) cmpcnt: " + Globals.mCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rmEnd2 - rmStart2) * 0.000001) + "\n");

		long rhStart2 = System.nanoTime();
		srt.heapSort(rndArr2);
		long rhEnd2 = System.nanoTime();
		//System.out.println("\nHeap-sorted (sorted) array:");
		//printArray(rndArr1);
		System.out.println("\nHeap-sorted (sorted) cmpcnt: " + Globals.hCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rhEnd2 - rhStart2) * 0.000001) + "\n");

		long rqStart2 = System.nanoTime();
		quickSort(rndArr2, 0, rndArr2.length - 1);
		long rqEnd2 = System.nanoTime();
		//System.out.println("\nQuick-sorted (sorted) array:");		
		//printArray(rndArr2);
		System.out.println("\nQuick-sorted (sorted) cmpcnt: " + Globals.qCnt);
		System.out.println("\nElapsed Time in milliseconds: "+ ((rqEnd2 - rqStart2) * 0.000001) + "\n");
	}
}