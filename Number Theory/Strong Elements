import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {

    // Function to calculate GCD
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // Main function to solve the problem
    static void mainSolve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];
        int[] pref_gcd = new int[n];
        int[] suff_gcd = new int[n];

        // Reading the input
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(input[i]);
        }

        int all_gcd = v[0];

        pref_gcd[0] = v[0];
        suff_gcd[n - 1] = v[n - 1];

        // Calculate prefix GCDs
        for (int i = 1; i < n; i++) {
            all_gcd = gcd(all_gcd, v[i]);
            pref_gcd[i] = gcd(pref_gcd[i - 1], v[i]);
        }

        // Calculate suffix GCDs
        for (int i = n - 2; i >= 0; i--) {
            suff_gcd[i] = gcd(suff_gcd[i + 1], v[i]);
        }

        int ans = 0;

        // Calculate the result
        for (int i = 0; i < n; i++) {
            int curr_gcd;
            if (i == 0) {
                curr_gcd = suff_gcd[i + 1];
            } else if (i == n - 1) {
                curr_gcd = pref_gcd[i - 1];
            } else {
                curr_gcd = gcd(pref_gcd[i - 1], suff_gcd[i + 1]);
            }

            if (curr_gcd != 1) {
                ++ans;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // Process each test case
        while (t-- > 0) {
            mainSolve(br);
        }
    }
}