import java.util.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine().trim());
        while(size-->0){
            String[] input = br.readLine().trim().split(" "); 
            int length = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            String[] necklace = br.readLine().trim().split(" ");
            System.out.println(movePearls(necklace, k, length));
        }
        
        br.close();
	}
	
	public static String movePearls(String[] necklace, int k, int length){
	    if(k >= length || k < 0){
	        k = k%length;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<length; i++){
	        sb.append(necklace[(i+k)%length]).append(" ");
	    }
	    
	    return sb.toString().trim();
	}
}
