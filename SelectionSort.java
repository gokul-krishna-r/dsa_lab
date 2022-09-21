import java.io.*;
import java.util.Scanner;





public class SelectionSort {
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minimum=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minimum]){
                    minimum=j;
                }
            }
            if(minimum!=arr[i]){
                int temp=arr[i];
                arr[i]=arr[minimum];
                arr[minimum]=temp;

            }
        }  


    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }
    }
    public static void main(String args[]){
       int arr[]={10,8,12,7,18,3,4,1,7,8};
       selectionSort(arr);
       printArray(arr);
    }
   
}
 