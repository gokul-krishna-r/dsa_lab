import java.io.*;
import java.util.Scanner;





public class BinarySeach {
    public static int binarySearch(int arr[],int key){
        int high=arr.length-1;
        int low=0;

        while(low<=high){
            int mid=(high+low)/2;
            if(arr[mid]==key){
                System.out.print("Found");
                return mid;
            }else if(arr[mid]>key){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.print("Not Found");

        return -1;


    }
    public static void main(String args[]){
        System.out.println("x");
       int arr[]={1,3,5,7,8,9,10};
       System.out.println(binarySearch(arr, 8));
    }
   
}
 