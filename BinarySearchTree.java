import java.io.*;
import java.util.*;


class QueueNode{
    public QueueNode next;
    public BinaryNode data;

    public QueueNode(BinaryNode d){
        data=d;
    }
    public void displayLink(){
        System.out.println(data);
    }
}
class CircularQueue{
    private QueueNode first;
    private QueueNode rear;

    public CircularQueue(){
        first=rear=null;
    }

    public boolean isEmpty(){
        return first==null;
    }
    public void enQueue(BinaryNode d){
        QueueNode n=new QueueNode(d);
        if(isEmpty()){
            first=n;
            rear=n;
        }else{
            rear.next=n;
        }
        
        n.next=first;
        rear=n;
    }
    public BinaryNode deQueue(){
        QueueNode temp;
        if(!isEmpty()){
            if(rear==first){
                temp=rear;
                first=rear=null;
            }else{
                temp=first;
                first=first.next;
                rear.next=first;

            }
        }else{
            temp=null;
            System.out.println("Queue is Empty");
        }

        return temp.data;

        
    }

    public void displayQueue(){
        
        QueueNode current=first;
            System.out.println("\nElements in Circular Queue are: ");
            while(current!=null){
                System.out.println(current.data.data);
                current = current.next;
			    if (current == first)
			    {
				current = null;
			    }
            }
        
    }
}


class BinaryNode{
    public int data;
	public int height;
	public BinaryNode lchild;
	public BinaryNode rchild;

    public BinaryNode(int data){
		this.data = data;
		this.lchild = null;
		this.rchild = null;
    }
    public void displayNode(){
        System.out.print(data);
    }
}

class BinarySearch {
    public BinaryNode root;

    public BinarySearch(){
        root=null;
    }
    public Boolean isEmpty(){
        return root==null;
    }

    public void insert(int i){
        BinaryNode newNode=new BinaryNode(i);
        if(isEmpty()){
            root=newNode;
        }else{
            BinaryNode current=root;
            BinaryNode parent;
            while(true){
                parent=current;
                if(current.data>i){
                    current=current.lchild;
                    if(current==null){
                        parent.lchild=newNode;
                        return;
                    }
                }else{
                    current=current.rchild;
                    if(current==null){
                        parent.rchild=newNode;
                        return;
                    } 
                }
            }
        }
    }
    public void search(int key){
        int flag=0;
        if(isEmpty()){
            System.out.println("Tree is Empty");
        }else{
            BinaryNode current=root;
            while(true){
                if(key<current.data){
                    current=current.lchild;
                    if(current==null){
                        flag=1;
                        break;
                    }
                }else if(key>current.data){
                    current=current.rchild;
                    if(current==null){
                        flag=1;
                        break;
                    }
                }else if(key==current.data){
                    flag=0;
                    break;
                }else{
                    flag=1;
                }
            }
        }

        if(flag==0){
            System.out.println("Item is found");
        }else{
            System.out.println("Item is not found");
        }
    }

    public void inOrder(BinaryNode localRoot){
        if(localRoot!=null){
            inOrder(localRoot.lchild);
            localRoot.displayNode();
            inOrder(localRoot.rchild);
        }
    }
 

    public void preOrder(BinaryNode localRoot){
        if(localRoot!=null){
            localRoot.displayNode();
            preOrder(localRoot.lchild);
            preOrder(localRoot.rchild);
        }
    }

    public void postOrder(BinaryNode localRoot){
        if(localRoot!=null){
            postOrder(localRoot.lchild);
            postOrder(localRoot.rchild);
            localRoot.displayNode();
        }
    }
    public int maxDepth(BinaryNode localRoot){
        BinaryNode current=localRoot;
        if(current==null){
            return -1;
        }else{
            int lDepth= maxDepth(current.lchild);
            int rDepth= maxDepth(current.rchild);
            if(lDepth>rDepth){
                return lDepth+1;
            }else{
                return rDepth+1;
            }
        }
    }

    public void levelOrder(BinaryNode localRoot){
        CircularQueue q=new CircularQueue();
        BinaryNode current=localRoot;
        q.enQueue(current);
        q.enQueue(null);
        System.out.println("Level Order Traversal: ");
        int height=0;
        while(!q.isEmpty()){
            current=q.deQueue();
            
            if(current==null){
                height++;
            }
            
            
            if(current!=null){
                System.out.print(current.data+" ");
                if(current.lchild!=null){
                    q.enQueue(current.lchild);
                }
                if(current.rchild!=null){
                    q.enQueue(current.rchild);
                }
    

            }
           else if(!q.isEmpty()){
                q.enQueue(null);
            }
{}
        }
        System.out.println("+++"+height);
    }

    public void postOrderIterative(BinaryNode localRoot){
        if(localRoot==null){
            return;
        }else{
            Stack<BinaryNode> s=new Stack<>();
            s.push(localRoot);
            Stack<Integer> out = new Stack<>();
            BinaryNode current;

            while(!s.isEmpty()){
                current=s.pop();
                out.push(current.data);
                if (current.lchild != null) {
                    s.push(current.lchild);
                }
        
                if (current.rchild != null) {
                    s.push(current.rchild);
                }
            }
            System.out.println("PostOrder Traversal: ");
            while(!out.isEmpty()){
                System.out.print(out.pop()+" ");
            }

            }
        }
        public void preOrderIterative(BinaryNode localRoot){
            // return if the tree is empty
        if (localRoot == null) {
            return;
        }else{
        Stack<BinaryNode> s = new Stack<>();
        s.push(localRoot);
        System.out.println("PreOrder Traversal: ");
        while (!s.isEmpty())
        {
            // pop a node from the stack and print it
            BinaryNode curr = s.pop();
            System.out.print(curr.data + " ");
    
            // push the right child of the popped node into the stack
            if (curr.rchild != null) {
                s.push(curr.rchild);
            }
            if (curr.lchild != null) {
                s.push(curr.lchild);
            }

        }
        }
    }

    public BinaryNode minimumElement(BinaryNode localRoot) {
        if (localRoot.lchild == null) {
            return localRoot;
        } else {
            return minimumElement(localRoot.lchild);
        }
    }
    

    }

	


public class BinarySearchTree{
    public static void main(String args[]){
        BinarySearch bs=new BinarySearch();
        bs.insert(14);
        System.out.println(bs.maxDepth(bs.root));

        bs.insert(15);
        bs.insert(4);
        System.out.println(bs.maxDepth(bs.root));

        bs.insert(9);
        bs.insert(7);
        bs.insert(18);
        bs.insert(3);
        bs.insert(5);
        bs.insert(16);
        bs.insert(4);
        bs.insert(20);
        bs.insert(17);
        bs.insert(9);
        bs.insert(14);
        bs.insert(5);
        bs.search(5);
        System.out.println(bs.maxDepth(bs.root));
    
        bs.levelOrder(bs.root);
        bs.inOrder(bs.root);
        System.out.println(" ");
        bs.preOrder(bs.root);
        System.out.println(" ");
        bs.postOrder(bs.root);
    }
}