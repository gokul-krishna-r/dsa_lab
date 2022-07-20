import java.io.Console;
import java.io.StringBufferInputStream;
import java.util.*;

class OStack{
    private int top;
    private int max;
    private String arr[];

    public OStack(int n){
        max=n;
        top=-1;
        arr=new String[max];
    }

    public void push(String a){
        top++;
        arr[top]=a;
    }

    public String pop(){
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
    public String peek(){
        return arr[top];
    }
}

public class PostfixToPrefix {


    public static int precedence(String ch)
    {
        switch (ch.charAt(0))
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            default:
                return -1;
        }
        
    }

    

    public static void main(String args[]){
        String postfix,prefix="";
        
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter expression");
        postfix=scn.nextLine();
        OStack stck=new OStack(postfix.length());




        int i=0;
        while(i!=(postfix.length())){
            System.out.println("Entered");
            String opThis=String.valueOf(postfix.charAt(i));
            String opTop;
            
            opTop=stck.peek();
            
            
            if(Character.isLetterOrDigit(opThis.charAt(0))){
                stck.push(opThis);
                System.out.println("Entered 3");
                System.out.println("Stack is "+stck.peek());

            }else if (opThis == "/" || opThis == "*" || opThis == "+" ||opThis == "-" || opThis =="^" ||opThis=="("||opThis==")"){
                char operand2=stck.pop().charAt(0);
                char operand1=stck.pop().charAt(0);
                String temp=opThis+operand1+operand2;
                System.out.println(operand1+" "+operand2);
                stck.push(temp);
                
            }else{
                System.out.println("Syntax error");
                break;
            }
            i++;
        }

        while(!stck.isEmpty()){
            prefix+=stck.pop();
        }
        System.out.println("Prefix is "+prefix);
    }
    
}
