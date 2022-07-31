import java.io.*;

class Link{
    public int data;
    public Link next;

    public Link(int d){
        data=d;
    }
    public void displayLink(){
        System.out.println(data);
    }
}

class LinkedList{
    private Link first;
    public LinkedList(){
        first=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertFirst(int d){
        Link nl =new Link(d);
        if(isEmpty()){
            first=nl;
        }else{
            nl.next=first;
            first=nl;
        }
    }
    public Link deleteFirst(){
        Link temp=first;
        first=first.next;
        return temp;
        
    }
    public void insertLast(int d){
        Link nl=new Link(d);
        Link current=first;
        Link previous=first;
        if(isEmpty()){
            first=nl;
        }else{
            while(current!=null){
                
                    if(current==first && current.data>nl.data){
                        nl.next=current;
                        first=nl;
                    }else if(current.data>nl.data){
                        previous.next=nl;
                        nl.next=current;
                    }else if(current.next==null && nl.data>current.data){
                        current.next=nl;
                    }else{
                        previous=current;
                        current=current.next;
                        continue;
                    }
                    break;
                  
                }
            
        }

    }
    public void displayList(){
        Link current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }
    
}

public class PriorityQueueLinkedList {
    public static void main(String args[]){
        LinkedList q=new LinkedList();
        q.insertLast(20);
        q.insertLast(10);
        q.insertLast(5);
        q.insertLast(3);
        q.insertLast(12);
        q.displayList();
        q.deleteFirst();
        q.deleteFirst();
        q.displayList();

    }
   
}
