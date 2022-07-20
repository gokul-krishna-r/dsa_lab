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
    public void displayList(){
        Link current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }
    public void insertAfterKey(int key,int d){
        Link nl=new Link(d);
        Link current =first;
        while(current!=null){
            if(current.data==key){
                break;
            }else{
                current=current.next;
            }
        }
        if(current.data==key){
            nl.next=current.next;
            current.next=nl;
        }
    }

    public Link deleteKey(int key){
        Link current=first;
        Link previous=first;
        while(current!=null){
            if(current.data==key){
                break;
            }else{
                previous=current;
                current=current.next;
            }
        }

        if(current.data==key){
            if(current==first){

            }else{
                previous.next=current.next;
            }
        }

        return current;
    }
}

class LinkStack{
    LinkedList l;
    public LinkStack(){
        l=new LinkedList();
    }
    public void push(int j){
        l.insertFirst(j);
    }
    public Link pop(){
        return l.deleteFirst();
    }
    
}

public class StackUsingLink {
    

    public static void main(String args[]){
        LinkedList l=new LinkedList();
        l.insertFirst(10);
        l.insertAfterKey(10,20);
        l.insertFirst(30);
        l.displayList();
    }
}
