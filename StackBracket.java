import java.util.*;

class OStack{
    private int top;
    private int max;
    private char arr[];

    public OStack(int n){
        max=n;
        top=-1;
        arr=new char[max];
    }

    public void push(char a){
        top++;
        arr[top]=a;
    }

    public char pop(){
        return arr[top--];
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(top==max-1){
            return true;
        }else{
            return false;
        }
    }
    public char peek(){
        return arr[top];
    }
}

class StackBracket{
    public static void main(String args[]){
        String expr;        
        int n,flag=0;
        System.out.println("Enter expression");

        Scanner scn=new Scanner(System.in);
        expr=scn.nextLine();
        n=expr.length();

        OStack stck=new OStack(n);

        for(int i=0;i<n;i++){
            if(!stck.isFull()){
                flag=0;
                char curr=expr.charAt(i);
                if(curr=='{'||curr=='('||curr=='['){
                    stck.push(curr);
                }
              
                if(curr=='}'||curr==']'||curr==')'){
                    
                    if(stck.isEmpty()){
                        break;
                    }
                    char open=stck.pop();
                    if((open=='{'&& curr=='}') ||(open=='('&& curr==')') ||(open=='['&& curr==']')){
                        flag=1;
                    }else{
                        break;
                    }
                }
                
            } 
        }
        if(stck.isEmpty()){
            if(flag==1){
                System.out.println("Expression is valid");
            }else{
                System.out.println("Expression is invalid");
            }
        }else{
            System.out.println("Expression is invalid");
        }
        
 

    
        }

    }


