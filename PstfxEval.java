import java.util.*;

class OStack{
    private int top;
    private int max;
    private float arr[];

    public OStack(int n){
        max=n;
        top=-1;
        arr=new float[max];
    }

    public void push(float a){
        top++;
        arr[top]=a;
    }

    public float pop(){
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
    public float peek(){
        return arr[top];
    }
}

public class PstfxEval {
        static float performOperation(char op,float oprnd1,float oprnd2){
            switch(op){
                case '+':
                    return oprnd1+oprnd2;
                case '-':
                    return oprnd1-oprnd2;
                case '/':
                    return oprnd1/oprnd2;
                case '*':
                    return oprnd1*oprnd2;
                case '^':
                    return (float)Math.pow(oprnd1,oprnd2);
                default:
                 return -1;
            }
        }        
        public static void main(String args[]){
            String infix;
            Scanner scn=new Scanner(System.in);
            System.out.println("Enter expression");
            infix=scn.nextLine();
            OStack stck=new OStack(infix.length());
            int i=0;
            float result=0;
            String temp="";
            while(i!=(infix.length())){
                char opThis=infix.charAt(i);
    
                
                if(Character.isLetterOrDigit(opThis)){
                    
                    System.out.println("Entered");
                    stck.push(Float.parseFloat(String.valueOf(opThis))); 

                }
                else if (opThis == '/' || opThis == '*' || opThis == '+' ||opThis == '-' || opThis =='^'){
                float operand2=stck.pop();
                float operand1=stck.pop();
                System.out.println(operand1+" "+operand2);
                
                    result=performOperation(opThis,operand1,operand2);
                    stck.push(result);
                    
                }else{
                    System.out.println("Syntax error");
                    break;
                }
                i++;


            }
        System.out.println("Final result : "+ stck.pop());
        }   
}
