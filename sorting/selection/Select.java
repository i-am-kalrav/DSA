// Kalrav Srivastava
// ks874
// CS 435
// Fall 2021
import java.util.*;
public class Select
{
	private static int partition(int arr[], int start, int end)
	{
        int pivot = arr[end];
        int i = (start - 1);
        
        for (int j = start; j < end; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                Global.kCnt++;
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
	
	public static void qSort(int arr[], int start, int end)
	{
        if (start < end)
        {
            Global.kCnt++;
            int partitionIndex = partition(arr, start, end);
            qSort(arr, start, partitionIndex - 1);
            //Globals.kCnt++;
            qSort(arr, partitionIndex + 1, end);
            //Globals.kCnt++;
        }
    }
    
    static int Select1(int arr[], int n, int k)
    {
        //k--;
        Select srt = new Select();
        srt.qSort(arr, 0, n - 1);
        return arr[k];
    }
	
	public static void inSort(int arr[], int n)
    {
        //int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	
	static int Select2(int arr[], int n, int k)
    {
        //k--;
        if(n < 25)
        {
            Select srt = new Select();
            srt.inSort(arr, n);
            return arr[k];
        }
        
        int v = (int)(Math.random() * ((n - 1) + 1));
        int pivot = arr[v];
        //System.out.println("Position: " + v + " Pivot: " + pivot);

        int L[] = new int[n];
        int n1 = 0;
        
        int E[] = new int[n];
        int n2 = 0;
        
        int G[] = new int[n];
        int n3 = 0;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] < pivot)
            {
                L[n1] = arr[i];
                Global.kCnt++;
                n1++;
            }
            else if(arr[i] > pivot)
            {
                G[n3] = arr[i];
                Global.kCnt++;
                n3++;
            }
            else
            {
                E[n2] = arr[i];
                n2++;
            }
        }

        if (k < n1)
        {
            return Select2(L, n1, k);
        }
        else if (k < (n1 + n2))
        {
            return pivot;
        }
        else
        {
            return Select2(G, n3, k - (n1 + n2));
        }
    }
    
    static int Select3(int arr[], int n, int k)
    {
        //k--;
        if(n < 25)
        {
            Select srt = new Select();
            srt.inSort(arr, n);
            return arr[k];
        }
        
        int c = 0;
        int lst[][] = new int[n/5][5];
        int medns[] = new int[n/5];
        
        for (int i = 0; i < n/5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (c == n)
                {
                    break;
                }
                
                lst[i][j] = arr[c];
                c++;
            }
            
            Select srt = new Select();
            srt.inSort(lst[i], lst[i].length);
            
            if (lst[i].length % 2 == 0)
            {
                medns[i] = (lst[i][(lst[i].length)/2] + (lst[i][((lst[i].length)/2) - 1]))/2;
            }
            else
            {
                medns[i] = lst[i][(lst[i].length - 1)/2];
            }
        }
        
        int med;
        if ((n/5) % 2 != 0)
        {
            med = Select3(medns, n/5, ((n/5) + 1)/2);
        }
        else
        {
            med = Select3(medns, n/5, (n/5)/2);
        }
        
        int pivot = med;

        int L[] = new int[n];
        int n1 = 0;
        
        int E[] = new int[n];
        int n2 = 0;
        
        int G[] = new int[n];
        int n3 = 0;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] < pivot)
            {
                L[n1] = arr[i];
                Global.kCnt++;
                n1++;
            }
            else if(arr[i] > pivot)
            {
                G[n3] = arr[i];
                Global.kCnt++;
                n3++;
            }
            else
            {
                E[n2] = arr[i];
                n2++;
            }
        }

        if (k < n1)
        {
            return Select3(L, n1, k);
        }
        else if (k < (n1 + n2))
        {
            return pivot;
        }
        else
        {
            return Select3(G, n3, k - (n1 + n2));
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
    
    public static class Global
	{
        public static int kCnt = 0;
    }
    
    static void driver(int n)
    {
        int Arr1[] = new int[n];
        int Arr2[] = new int[n];
        int Arr3[] = new int[n];
        
		for (int i = 0; i < n; i++)
		{
		    int x = 1 + (int)(Math.random() * (n - 1 + 1));
		    //wrstArr[i] = 32 - i;
		    Arr1[i] = x;
		    Arr2[i] = x;
		    Arr3[i] = x;
		}
		
		//System.out.println("\nArray:");
		//printArray(Arr1);
		
		int ans1 = Select1(Arr1, n, (n/2));
		System.out.println("\nAlgorithm Select1: n = " + n + ", k = " + n/2 + ", A[k] = " + ans1 + ", Number of Key-Comparisons = " + Global.kCnt);
		
		Global.kCnt = 0;
		
		int ans2 = Select2(Arr2, n, (n/2));
		System.out.println("\nAlgorithm Select2: n = " + n + ", k = " + n/2 + ", A[k] = " + ans2 + ", Number of Key-Comparisons = " + Global.kCnt);
		
		Global.kCnt = 0;
		
		int ans3 = Select3(Arr3, n, (n/2));
		System.out.println("\nAlgorithm Select3: n = " + n + ", k = " + n/2 + ", A[k] = " + ans3 + ", Number of Key-Comparisons = " + Global.kCnt);
        
        Global.kCnt = 0;
        
    }
	
	public static void main(String[] args)
	{
		int lens[] = {10000, 100000, 1000000};
		for (int i = 0; i < lens.length; i++)
		{
		    System.out.println("\n\n****************** n = " + lens[i] + " ******************");
		    driver(lens[i]);
		}
	}
}