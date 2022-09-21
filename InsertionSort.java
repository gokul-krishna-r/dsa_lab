import java.io.*;
import java.util.Scanner;





public class InsertionSort {
    public static void insertionSort(int arr[]){
        int j;
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            for(j=i-1;j>=0;j--){
                if(arr[j]>key){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
                
            }
            arr[j+1]= key;

            }
        }  


    
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }
    }
    public static void main(String args[]){
       int arr[]={10,8,12,7,18,3,4,1,7,8};
       insertionSort(arr);
       printArray(arr);
    }
   
}
 