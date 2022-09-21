

class Link{
    public int coeff;
    public int exp;
    public Link next;

    public Link(int x,int p){
        coeff=x;
        exp=p;
        next=null;
    }
    public void displayLink(){
        System.out.print(coeff+"x^"+exp);
    }
}

class LinkedList{
    public Link first;
    public LinkedList(){
        first=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertFirst(int x,int p){
        Link nl =new Link(x,p);
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
    public void insertLast(int x,int p){
        Link nl =new Link(x,p);
        Link current=first;
        while(current!=null){
            if(current.next==null){
                break;
            }
            current=current.next;
        }
        
            if(isEmpty()){
                first=nl;
            }else{
                current.next=nl;
            }
        }        
    
    public void displayList(){
        Link current=first;
        while(current!=null){
            if(current.exp==0){
                System.out.print(current.coeff);
            }else {
                current.displayLink();
                if(current.next!=null){
                    System.out.print("+");
                }
            }
            // current.displayLink();
            current=current.next;
        }
    }
    

}


public class PolynomialAddition {
    public  static LinkedList addPoly(LinkedList l1,LinkedList l2){
        LinkedList temp=new LinkedList();
        Link node1=l1.first;
        Link node2=l2.first;
        Link res=new Link(0,0);
        while(node1!=null || node2!=null){

            if(node1==null){
                res.coeff=node2.coeff;
                res.exp=node2.exp;
                node2=node2.next;
            }
            else if(node2==null){
                res.coeff=node1.coeff;
                res.exp=node1.exp;
                node1=node1.next;
            }
            else if(node1.exp==node2.exp){
                res.coeff=node1.coeff+node2.coeff;
                res.exp=node1.exp;
                node1=node1.next;
                node2=node2.next;
            }

            else if(node1.exp<node2.exp){
                res.coeff=node2.coeff;
                res.exp=node2.exp;
                node2=node2.next;
            }

            else if(node1.exp > node2.exp){
                res.coeff=node1.coeff;
                res.exp=node1.exp;
                node1=node1.next;
            }
            System.out.println(res.coeff+"--"+res.exp);
            temp.insertLast(res.coeff,res.exp);
        
        }
        

        return temp;
    }
    
    public static void main(String args[]){
        System.out.println("\nFirst list");

        LinkedList l1=new LinkedList();
        l1.insertLast(10, 2);
        l1.insertFirst(6, 3);
        l1.insertLast(11, 2);
        l1.displayList();

        System.out.println("\nSecond list");
        LinkedList l2=new LinkedList();
        l2.insertLast(11, 2);
        l2.insertFirst(7, 3);
        l2.insertLast(9, 6);
        l2.displayList();
        System.out.println("\nAdded list");

        LinkedList temp=addPoly(l1, l2);
        temp.displayList();
    }
}
