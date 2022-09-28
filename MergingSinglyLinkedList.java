import java.util.concurrent.CountDownLatch;

class Link{

    public int data;
    Link next;
    public Link(int x){
        data=x;
    }
    public void displayLink(){
        System.out.println(data);
    }
}

class LinkedList{
    Link first;
    public LinkedList(){
        first=null;
    }
    public void insertFirst(int x){
        Link nl=new Link(x);
        if(first==null){
            first=nl;
        }else{
            nl.next=first;
            first=nl;
        }
    }
    public int deleteFirst(){
       Link current=first;
       while(current!=null){
            if(current.next==null){
                break;
            }else{
                current=current.next;
            }
       }
       int temp;
       temp=current.data;
       if(current==first){
            first=null;
       }else{
            first=first.next;
       }
       return temp;
    }

    public void insertLast(int x){
        Link nl=new Link(x);
        Link current=first;

        while(current!=null){
            if(current.next==null){
                break;
            }else{
                current=current.next;
            }
        }

        if(first==null){
            first=nl;
        }else{
            current.next=nl;
        }
    }

    public int deleteLast(){
        Link previous=first;
        Link current=first;

        while(current!=null){
            if(current.next==null){
                break;
            }else{
                previous=current;
                current=current.next;
            }
        }
        int temp;
        temp=current.data;
        if(current==first){
            first=null;
        }else{
            previous.next=null;
        }

        return temp;
    
    }

    public void display(){
        Link current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }
    public void insertSorted(int x){
        Link nl=new Link(x);
        Link current=first;
        Link previous=first;
        if(current==null){
            first=nl;
        }else{
        while(current!=null){
            if(current==first && current.data>=nl.data){
                nl.next=first;
                first=nl;
                break;
            }else if(current.data>=nl.data){
                previous.next=nl;
                nl.next=current;
                break;
            }else if(current.next==null && current.data<=nl.data){
                current.next=nl;
                break;
            }else{
                previous=current;
                current=current.next;
            }
        }
    }
    }

    public  void mergeList(LinkedList l1,LinkedList l2){
        Link n1=l1.first;
        Link n2=l2.first;
       
    while(n1!=null || n2!=null){
        if(n1==null){
            this.insertSorted(n2.data);
            n2=n2.next;

        }else if(n2==null){
            this.insertSorted(n1.data);
            n1=n1.next;

        }else if(n2.data==n1.data){
            this.insertSorted(n1.data);
            this.insertSorted(n1.data);
            n1=n1.next;
            n2=n2.next;

         }
        else if(n1.data>n2.data){
            this.insertSorted(n2.data);
            n2=n2.next;

        }else if(n2.data>n1.data){
            this.insertSorted(n1.data);
            n1=n1.next;
        }
    }


}

    public int max_count(){
        int max_count=0;
        int count=0;
        Link current=first;
        Link cur_ptr;
        int key=current.data;
        while(current!=null){
            cur_ptr=current;
            count=0;
            while(cur_ptr!=null){
                if(cur_ptr.data==current.data){
                    count++;
                }
                if(cur_ptr.next==null){
                    break;
                }else{
                    cur_ptr=cur_ptr.next;
                } 
            }
            if(max_count<count){
                max_count=count;
                key=current.data;
            }
            if(current.next==null){
                break;
            }else{
                current=current.next;
            }
        }

        System.out.println(key+" "+max_count);
        return max_count;
    }
    public int getCount(){
        int count=0;
        Link current=first;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
    public void unique_elements(LinkedList n2){
        Link l2=n2.first;
        Link l1=this.first;
        int flag=0;
        int unique_element=0;
        while(l1!=null){
            flag=0;
            unique_element=l1.data;
            l2=n2.first;
            while(l2!=null){
                if(unique_element==l2.data){
                    flag=1;
                    break;
                }
                if(l2.next==null){
                    break;
                }else{
                    l2=l2.next;

                }
            }
            System.out.println(flag);
            if(flag==0){
                System.out.println("Unique ELements  :"+unique_element);
            }
            if(l1.next==null){
                break;
            }else{
                l1=l1.next;
            }

        }
    }
}

class MergingSinglyLinkedList{

    
    public static void main(String args[]){
        LinkedList nl=new LinkedList();
        nl.insertLast(10);
        nl.insertLast(20);
        nl.insertLast(30);
        nl.insertLast(25);
        nl.insertLast(10);
        nl.display();
        System.out.println("-------");
        LinkedList n2=new LinkedList();
        n2.insertLast(10);
        n2.insertLast(20);
        n2.insertLast(40);
        n2.insertLast(10);
        n2.insertLast(6);
        n2.insertLast(50);
        n2.display();
        System.out.println("-------");
        LinkedList n3=new LinkedList();
        n3.mergeList(nl,n2);
        n3.display();
        System.out.println("-------");
        nl.max_count();
        System.out.println("-------");
        n2.unique_elements(nl);
        nl.unique_elements(n2);

        }


    }
