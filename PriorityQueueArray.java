class PriorityQueue{
    private int max;
    private int arr[];
    private int front;
    private int rear;
        public PriorityQueue(int item){
            max=item;
            arr=new int[max];
            front=0;
            rear=-1;
        }
    
        public void insertItem(int s){
            if(rear == -1){
                arr[++rear]=s;
            }else{
                int j;
                for(j=rear;j>=0;j--){
                    if(s>arr[j]){
                        arr[j+1]=arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+1]=s;
                rear++;
            }
             
        }
    
        public int remove(){
            return arr[front++];
        }
        public void display(){
            for(int i=front;i<=rear;i++){
                System.out.println(arr[i]);
            }
        }
        
        
    
    }
    //Descending Priority Queue
    class PriorityQueueArray{
        public static void main(String args[]){
            PriorityQueue q=new PriorityQueue(10);
            q.insertItem(10);
            q.insertItem(5);
            q.insertItem(3);
            q.insertItem(12);
            q.display();
            q.remove();
            q.remove();
            q.display();
        }
    }