import java.io.*;
import java.util.*;


class HeapSort{

    public void sort(int arr[]) {
        int n = arr.length;
    
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
          heapify(arr, n, i);
        }
    
        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;
    
          // Heapify root element
          heapify(arr, i, 0);
        }
      }


    void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
      
        if (left < n && arr[left] > arr[largest])
          largest = left;
      
        if (right < n && arr[right] > arr[largest])
          largest = right;
      
          // Swap and continue heapifying if root is not largest
          if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
      }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");
    }

  
    public static void main(String args[]){
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
  
  
        HeapSort hs = new HeapSort();
        hs.sort(arr);
    
        System.out.println("Sorted array is");
        printArray(arr);
    }
    

}
