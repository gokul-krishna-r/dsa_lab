import java.io.*;
import java.util.Scanner;





public class test {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                }
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
       bubbleSort(arr);
       printArray(arr);
    }
   
}
 