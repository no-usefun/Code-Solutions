import java.util.*;

public class Main {
    public static int[] nextHigherPeak(int[] heights) {
        int length = heights.length;
        int[] peak = new int[length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<length; i++){
            peak[i] = -1;
        }
        
        for(int i=0; i<length; i++){
            while(!st.isEmpty() && heights[i] > heights[st.peek()]){
                int idx = st.pop();
                peak[idx] = heights[i];
            }
            st.push(i);
        }
        
        return peak;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; ++i) {
            heights[i] = sc.nextInt();
        }

        int[] result = nextHigherPeak(heights);

        for (int height : result) {
            System.out.print(height + " ");
        }
        
        sc.close();
    }
}