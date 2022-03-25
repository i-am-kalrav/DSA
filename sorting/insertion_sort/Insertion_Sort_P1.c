// Kalrav Srivastava
// ks874
// CS435 003
// Fall 2021

#include <math.h>
#include <stdio.h>
#include <stdlib.h>

int KeyCount;
void insertionSort(int A[], int n)
{
    KeyCount = 0;
    int k, j;
    for (int i = 1; i < n; i++)
    {
        j = i;
        while (j > 0 && A[j] < A[j-1])
        {
            k = A[j];
            A[j] = A[j-1];
            A[j-1] = k;
            j--;
            KeyCount++;
        }
        if (A[j-1] <= A[j])
        {
            KeyCount++;
        }
    }
    //KeyCount++;
}

int main()
{
    int n = 32;
    //int n = 100;
    //int n = 1000;
    //int n = 10000;
    
    //Random
    int A[n];
    for (int h = 0; h < n; h++)
    {
        A[h] = rand() % 50;
    }
    
    //Best Case
    int B[n];
    for (int h = 0; h < n; h++)
    {
        B[h] = h+1;
    }
    
    //Worst Case
    int C[n];
    for (int h = n; h > 0; h--)
    {
        C[n-h] = h;
    } 
    
    printf("n = %d\n", n);
    
    //Best
    printf("Best case:\nBefore:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", B[h]);
    }
    insertionSort(B, n);
    printf("\nAfter:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", B[h]);
    }
    printf("\nKey Comparison Count: %d\n", KeyCount);
    
    
    //Worst
    printf("\n\nWorst case:\nBefore:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", C[h]);
    }
    insertionSort(C, n);
    printf("\nAfter:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", C[h]);
    }
    printf("\nKey Comparison Count: %d\n", KeyCount);
    
    
    //Random
    printf("\n\nAverage case (random values):\nBefore:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", A[h]);
    }
    insertionSort(A, n);
    printf("\nAfter:\n");
    for (int h = 0; h < n; h++)
    {
        printf("%d ", A[h]);
    }
    printf("\nKey Comparison Count: %d\n", KeyCount);
 
    return 0;
}