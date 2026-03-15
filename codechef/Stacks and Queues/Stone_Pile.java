import java.util.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine().trim());
        while(size-->0){
            int length = Integer.parseInt(br.readLine().trim());
            String[] stones = br.readLine().trim().split(" ");
            findLastPersonAndStone(stones,length);
        }
        br.close();
	}
	
	public static void findLastPersonAndStone(String[] stones, int length){
	    Deque<Integer> box = new ArrayDeque<>();
	    
	    for(String stone: stones){
	        box.offer(Integer.parseInt(stone));
	    }
	    
	    boolean isAmanTurn = true;
	    while(box.size()>1){
	        if(isAmanTurn){
	            move1(box);
	            move2(box);
	            isAmanTurn = false;
	        } else{
	            move1(box);
	            move1(box);
	            move2(box);
	            isAmanTurn = true;
	        }
	    }
	    
	    System.out.println((isAmanTurn? 0:1) +" "+box.poll());
	}
	
	public static void move1(Deque<Integer> box){
	    int stone = box.poll();
	    box.offer(stone);
	}
	
	public static void move2(Deque<Integer> box){
	    if(!box.isEmpty()){
	        box.poll();
	    }
	}
}
