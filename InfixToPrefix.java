import java.io.Console;
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

public class InfixToPrefix {


    public static int precedence(char ch)
    {
        switch (ch)
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

    public static String reverseStr(String s){
        String rvrs="";
        char ch;
        for(int i=0,j=(s.length()-1);i<s.length();i++,j--){
            ch=s.charAt(j);
            if (ch == '(') {
                rvrs+=')';
            }
            else if (ch == ')') {
                rvrs+='(';  
            }else{
                rvrs+=s.charAt(j);
            }
                
        }
        System.out.println(rvrs);
        return rvrs;

    }

    public static void main(String args[]){
        String infix,postfix="";
        
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter expression");
        infix=scn.nextLine();
        OStack stck=new OStack(infix.length());

        infix=reverseStr(infix);


        int i=0;
        while(i!=(infix.length())){
            System.out.println("Entered");
            char opThis=infix.charAt(i);
            char opTop;
            if(stck.isEmpty()){
                opTop=' ';
                System.out.println("Entered 1");

            }else{
                System.out.println("Entered 2" +stck.peek());
                opTop=stck.peek();
            }
            
            if(Character.isLetterOrDigit(opThis)){
                postfix+=opThis;
                System.out.println("Entered 3");
                System.out.println("Postfix is "+postfix);

            }
            else if(opThis=='('){
                System.out.println("Entered 4");
                stck.push(opThis);
            }else if(opThis==(')')){
                while(!stck.isEmpty()){
                    System.out.println("Entered 5");
                    if(stck.peek()==('(')){
                        stck.pop();
                        break;
                    }else{
                        postfix+=stck.pop();
                        System.out.println("Postfix is "+postfix);

                    }
                }
            } else if (opThis == '/' || opThis == '*' || opThis == '+' ||opThis == '-' || opThis =='^' ||opThis=='('||opThis==')'){
                System.out.println("Optop is "+opTop);
                if(stck.isEmpty()){
                    stck.push(opThis);
                }else{
                    while(!stck.isEmpty()){
                        char item=stck.peek();
                        if(item=='('){
                            System.out.println("Entered 6");
                            break;
                        }else{
                            if(precedence(opTop)<=precedence(opThis)){
                                
                            }if(precedence(opTop)>precedence(opThis)){
                                postfix+=stck.pop();
                                System.out.println("Postfix is "+postfix);
                                
                            }if(precedence(opTop)<precedence(opThis) || item=='('){
                                break;
                            }
                        }
                    }
                    System.out.println("------Entered 7"+opThis);
                    stck.push(opThis);
                }
            }else{
                System.out.println("Syntax error");
                break;
            }
            i++;
        }

        while(!stck.isEmpty()){
            postfix+=stck.pop();
        }
        System.out.println("Prefix is "+reverseStr(postfix));
    }
    
}
