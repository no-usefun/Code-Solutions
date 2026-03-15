import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        
        while(size--!=0){
            String parenthesis = br.readLine();
            System.out.println(validParenthesis(parenthesis));
        }
        
        br.close();
	}
	
	public static int validParenthesis(String parenthesis){
	    Stack<Character> parenthesisStack = new Stack<Character>();
	    
	    for(char bracket: parenthesis.toCharArray()){
	        if(bracket=='('){
	            parenthesisStack.push(bracket);
	        } else if(!parenthesisStack.isEmpty() && bracket==')'){
	            parenthesisStack.pop();
	        } else{
	            return 0;
	        }
	    }
	    
	    return parenthesisStack.isEmpty() ? 1:0;
	}
}
