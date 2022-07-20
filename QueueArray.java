class Queue{
    private int rear;
    private int front;
    private int arr[];
    private int max;

    public Queue(int n){
        rear=-1;
        front=0;
        max=n;
        arr=new int[max];
    }
    public boolean isEmpty(){
        return front==rear+1;
    }
    public boolean isFull(){
        return rear==max-1;
    }
    public void insert(int d){
        if(!isFull()){
            rear++;
            arr[rear]=d;
        }else{
            System.out.println("Queue is Full");
        }
    }
    public int delete(){
        int item=arr[front];
        if(!isEmpty()){
            front++;
        }else{
            System.out.println("Queue is Empty");
        }
        return item;
        
    }
    public void display(){
        for(int i=front;i<=rear;i++){
            System.out.println(arr[i]);
        }
    }
    // No elements at any time = rear-front+1
}
public class QueueArray {
    public static void main(String args[]){
        Queue q=new Queue(5);
        q.insert(10);
        q.insert(12);
        q.display();
        q.delete();
        q.insert(28);
        q.insert(34);
        q.display();
        q.insert(8);
        q.insert(7);
        q.display();
    }
}