import java.io.*;
import java.nio.file.FileStore;
import java.util.*;


class node{
    public node next;
    public int data;

    public node(int d){
        data=d;
    }
    public void displayLink(){
        System.out.println(data);
    }
}
class CircularQueue{
    private node first;
    private node rear;

    public CircularQueue(){
        first=rear=null;
    }

    public boolean isEmpty(){
        return first==null;
    }
    public void enQueue(int d){
        node n=new node(d);
        if(isEmpty()){
            first=n;
            rear=n;
        }else{
            rear.next=n;
        }
        
        n.next=first;
        rear=n;
        System.out.println("Added");
    }
    public void deQueue(){
        if(!isEmpty()){
            if(rear==first){
                first=rear=null;
            }else{
                first=first.next;

                rear.next=first;
                System.out.println("Deleted");

            }
        }else{
            System.out.println("Queue is Empty");
        }
    }

    public void displayQueue(){
        
            node current=first;
            System.out.println("\nElements in Circular Queue are: ");
            while(current!=null){
                System.out.println(current.data);
                current = current.next;
			    if (current == first)
			    {
				current = null;
			    }
            }
        
    }

}
public class test {
    public static void main(String args[]){
        CircularQueue q=new CircularQueue();
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
