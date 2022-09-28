class Link{
    public int data;
    public Link next;
    public Link prev;

    public Link(int d){
        data=d;
    }
    public void displayLink(){
        System.out.println(data);
    }
}

class DoublyLinkList{
    private Link first;
    public Link last;
    public DoublyLinkList(){
        first=null;
        last=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void displayForward(){
        Link current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        } 
    } 
public void displayBackward(){
        Link current=last;
        while(current!=null){
            current.displayLink();
            current=current.prev;
        }
}
    public void insertFirst(int s){
        Link nl=new Link(s);
        if(isEmpty()){
            first=nl;
            last=nl;
        }else{
            first.prev=nl;
            nl.next=first;
            first=nl;
        }
    }

    public void insertLast(int s){
        Link nl=new Link(s);
        if(isEmpty()){
            first=nl;
            last=nl;
        }else{
            last.next=nl;
            nl.prev=last;
            last=nl;
        }
    }
    public Link deleteFirst(){
        Link current=first;
        first=first.next;
        first.prev=null;
        return current;

        
    }
   
    public Link deleteLast(){
        Link current=first;
        last=last.prev;
        last.next=null;
        return current;
        
    }

 public void deleteKey(int key){
       
        Link current=first;
        while(current.data!=key){
            if(current.next==null){
                break;
            }else{
                current=current.next;
            }
        }
        if(current.data==key){
            if(current==last){
                last=last.prev;
                last.next=null;
            }else if(current==first){
                first=current.next;
                first.prev=null;
            }else{
                current.prev.next=current.next;
                current.next.prev=current.prev;
            }
        }
    }
    public void insertAfterKey(int key,int d){
        Link nl=new Link(d);
        Link current=first;
        while(current.data!=key){
            if(current.next==null){
                break;
            }else{
                current=current.next;
            }
        }
        if(current.data==key){
            if(current==last){
                nl.prev=last;
                last.next=nl;
                last=nl;
            }else{
                nl.prev=current;
                nl.next=current.next;
                current.next.prev=nl;
                current.next=nl;
            }
        }
    }

}

public class DoublyLinkedList {
    
   
        
    
    public static void main (String args[]){
     DoublyLinkList dl=new DoublyLinkList();
     dl.insertFirst(10);
     dl.insertFirst(20);
     dl.insertLast(30);
     dl.insertAfterKey(20, 50);
     dl.deleteFirst();
     dl.displayForward();
     dl.deleteLast();
     dl.displayForward();
     dl.deleteKey(50);
     dl.displayBackward();

    }
}
