import java.io.*;
import java.util.Scanner;





public class MergeSort {
    public static void mergeSort(int arr[],int low,int high){
        if(low<high){
            int q=low+((high-low)/2);
            mergeSort(arr, low, q);
            mergeSort(arr, q+1, high);
            merge(arr,low,q,high);
        }
        } 
    public static void merge (int arr[],int low,int q,int high){
        int temp[]=new int[high+1];
        int k;
        int i;
        i=k=low;
        int j=q+1;
        while(i<=q && j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=q){
            temp[k++]=arr[i++];
        }
        while(j<=high){
            temp[k++]=arr[j++];
        }


        for(i=low;i<=high;i++){
            arr[i]=temp[i];
        }
    }


    
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }
    }
    public static void main(String args[]){
       int arr[]={10,8,12,7,18,3,4,1,7,8};
       mergeSort(arr,0,arr.length-1);
       printArray(arr);
    }
   
}
 