import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] custom_input_1 = br.readLine().split(" ");
            int N = Integer.parseInt(custom_input_1[0]);
            int K = Integer.parseInt(custom_input_1[1]);
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int[] out_ = solve(N, K, A);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    static int[] solve(int N, int K, int[] A){

        Integer[] result = new Integer[N];

        for(int i = 0; i < N; i++){
            result[i] = A[i];
        }

        Arrays.sort(result, (a, b) -> {
            int d1 = Integer.bitCount(a ^ K);
            int d2 = Integer.bitCount(b ^ K);

            if(d1 != d2) return d1 - d2;
            return a - b;
        });

        int[] ans = new int[N];

        for(int i = 0; i < N; i++){
            ans[i] = result[i];
        }

        return ans;
    }
}