import java.io.*;
import java.util.*;

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
                if(i<current.data){
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

	
}

public class BinarySearchTree{
    public static void main(String args[]){
        BinarySearch bs=new BinarySearch();
        bs.insert(14);
        bs.insert(15);
        bs.insert(4);
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
        bs.inOrder(bs.root);
        System.out.println(" ");
        bs.preOrder(bs.root);
        System.out.println(" ");
        bs.postOrder(bs.root);
    }
}