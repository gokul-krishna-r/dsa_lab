import java.io.*;
import java.nio.file.FileStore;
import java.util.*;

import javax.sound.midi.SysexMessage;



class CircularQueue{
    private int front;
    private int rear;
    private int max;
    private int arr[];

    public CircularQueue(int x){
        front=0;
        rear=-1;
        max=x;
        arr=new int[max];
    }

    public boolean isEmpty(){
        return (rear+1)%max==front;
    }
    public boolean isFull(){
        return (rear+2)%max==front;
    }
    public void enQueue(int d){
        if(!isFull()){
        rear=(rear+1)%max;
        arr[rear]=d;
        System.out.println("Added");
        }else{
            System.out.println("Queue is Full");
        }
    }
    public int deQueue(){
        if(!isEmpty()){
            int temp=arr[front];
            front=(front+1)%max;
            return temp;
        }else{
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
    }
    public int size(){
        int s;
        if(rear>front){
            s=rear-front;
        }else{
            s=(max-front)+(rear+1);
        }

        return s;
    }
    public void displayQueue(){
        int i=0;
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }else{
            
            for( i=front;i<=rear;i=(i+1)%max){
                System.out.println("---"+arr[i] + " ");
            }

        }
        
    }

}
public class CircularQueueArray {
    public static void main(String args[]){
        CircularQueue q=new CircularQueue(5);
        Scanner scn=new Scanner(System.in);
        int choice=0;
        int d;
       
        do{
            System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
            System.out.println("Enter choice: ");
            choice=scn.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter value: ");
                    d=scn.nextInt();
                    q.enQueue(d);
                    break;
                case 2:
                    q.deQueue();
                    break;
                case 3:
                    q.displayQueue();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Something went wrong");
            }
    
        }while(choice!=4);
        scn.close();

    }

}
