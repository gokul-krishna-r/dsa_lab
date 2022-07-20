import java.io.*;
import java.util.*;

class OurStack{
	private char arr[];
	private int max;
	private int top;
	
	public OurStack(int s){
		max = s;
		arr = new char[max];
		top = -1;
	}
	public void push(char a){
		top++;
		arr[top] = a;
	}
	public char pop(){
		char b;
		b = arr[top];
		top--;
		return b;
	}
	public boolean isEmpty(){
		if(top == -1)
			return true;
		else
			return false;
	}
	public boolean isFull(){
		if(top == max -1)
			return true;
		else
			return false;
	}
	public char peek(){
		return arr[top];
	}
	public int prec(char c){
	if(c == '+'||c == '-')
		return  1;
	else if(c == '/'||c == '*')
		return 2;
	else if(c == '^')
		return 3;
	return -1;
	}
}

class Infix{
	public static void main(String arg[]){
		OurStack obj = new OurStack(50);
		String k;
		String rev = "";
		int len,i;
		char g,item,opTop;
		Scanner con = new Scanner(System.in);
		System.out.println("Enter the expression : ");
		k = con.nextLine();
		len = k.length();
		
		for(i=0;i<len;i++){
			g = k.charAt(i);
			if(Character.isAlphabetic(g)||Character.isDigit(g))
				rev = rev + g;

			else if(g == '('){
				if(!obj.isFull())	
					obj.push(g);
				
			}
			
			else if(g == ')'){
				while(!obj.isEmpty()){
					item = obj.pop();
					if(item == '(')
						break;
					else
						rev = rev + item;
				}
			}
			
			else if(g == '+'||g == '-'||g == '/' ||g == '*' ||g == '^'){
				if(obj.isEmpty())
					obj.push(g);
				else{
					while(!obj.isEmpty()){
						item = obj.pop();
						
						if(item == '('){
							obj.push(item);
							break;
						}else{
							if(obj.prec(item) < obj.prec(g)){
								obj.push(item);
							}
							if(obj.prec(item) >= obj.prec(g))
								rev = rev + item;
							if(item == '(' || obj.prec(item) < obj.prec(g))
								break;
						}
						
					}
					obj.push(g);
					if(!obj.isEmpty()){
						System.out.println(obj.peek());
					}
				}
			}
			
		}
		while(!obj.isEmpty()){
			item = obj.pop();
			rev = rev + item;
		}
		System.out.println(rev);
	}
}
						
		
