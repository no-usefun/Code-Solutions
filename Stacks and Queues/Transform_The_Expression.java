import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		    int size = Integer.parseInt(br.readLine());
		    while(size--!=0){
		        String equation = br.readLine();
		        String RPN = infixToPrefix(equation);
		        System.out.println(RPN);
		    }
		} catch(IOException e){
		    System.out.println("Invalid input");
		} catch(NumberFormatException e){
		    System.out.println("Not an integer input");
		}
	}
	
	public static String infixToPrefix(String equation){
	    StringBuilder RPN = new StringBuilder();
	    Stack<Character> operator = new Stack<>();
	    
	    for(char c: equation.toCharArray()){
	        if(c >= 'a' && c<='z'){
	            RPN.append(c);
	        } else if(c!=')'){
	            operator.push(c);
	        } else{
	            while(!operator.isEmpty() && operator.peek()!='('){
	                RPN.append(operator.pop());
	            }
	            operator.pop();
	        }
	    }
	    
	    while(!operator.isEmpty()){
	        RPN.append(operator.pop());
	    }
	    
	    return RPN.toString();
	    
	}
}
