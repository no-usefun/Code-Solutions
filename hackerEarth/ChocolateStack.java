
import java.io.*;
import java.util.*;

class TestClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_C = br.readLine().split(" ");
        int[] C = new int[N];
        for (int i_C = 0; i_C < arr_C.length; i_C++) {
            C[i_C] = Integer.parseInt(arr_C[i_C]);
        }

        int[] out_ = solution(N, C);
        System.out.print(out_[0]);
        for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
            System.out.print(" " + out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static int[] solution(int N, int[] C) {
        Stack<Integer> chocolateStack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!chocolateStack.isEmpty() && C[i] == 0) {
                list.add(chocolateStack.pop());
            } else {
                if (C[i] != 0) {
                    chocolateStack.push(C[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
