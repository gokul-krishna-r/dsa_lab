import java.util.*;
import java.io.*;

class stack{
	private int top;
	private int max;
	private int a[];
	public stack(int m){
		max=m;
		top=-1;
		a=new int[max];
		}
	public void push(int j){
		a[++top]=j;
		}
	public int pop(){
		return a[top--];
		}
	public boolean isempty(){
		if(top==-1)
			return true;
		else
			return false;
			}
	public boolean isfull(){
		if(top==max-1)
			return true;
		else 
			return false;
			}
	public int peek(){
		return a[top];
		}
		}
class postfixev{
	public static void main(String st[])throws IOException{
		String str;
		System.out.println("enter the postfix expression:");
		Scanner ob=new Scanner(System.in);
		str=ob.nextLine();
		stack stck=new stack(str.length());
		char item;
		//int temp=0;
		for(int i=0;i<str.length();i++){
			item=str.charAt(i);
			if(Character.isDigit(item))
				stck.push(item-'0');
			else if(item=='+'||item=='-'||item=='*'||item=='/'||item=='^') {
				int val2=stck.pop();
				int val1=stck.pop();
				switch(item){
					case '+':
						stck.push(val1+val2);
						 break;
					case '-':
						stck.push(val1-val2);
						 break;
					case '*':
						stck.push(val1*val2);
						 break;
					case '/':
						stck.push(val1/val2);
						 break;
					case '^':
						stck.push((int)Math.pow(val1,val2));
						 break;	 	 			
					}
					
					}
		}
					 //temp+=stck.pop();
					//return temp;
					System.out.println("Result:"+stck.pop());
			}
	}