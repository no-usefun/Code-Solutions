
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {

    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            String[] arr_inp = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arr_inp[i]);
            }

            Integer[] res = solve(n, arr);

            for (Integer a : res) {
                System.out.print(a + " ");
            }

            System.out.println();
        }
    }

    static Integer[] solve(int n, int[] arr) {
        Integer[] res = new Integer[n];

        for (int i = 0; i < n; i++) {
            res[i] = arr[i];
        }

        Arrays.sort(res, (a, b) -> {
            int I1 = Integer.bitCount(a) % 2;
            int I2 = Integer.bitCount(b) % 2;

            if (I1 != I2) {
                return I1 - I2;
            }
            return a - b;
        });

        return res;
    }
}
