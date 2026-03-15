
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().trim().split(" ");

            int[] moves = new int[n];
            for (int i = 0; i < n; i++) {
                moves[i] = Integer.parseInt(arr[i]);
            }

            int[] minMoves = findMinMoves(moves, n);

            for (int val : minMoves) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        br.close();
    }

    public static int[] findMinMoves(int[] moves, int n) {
        int[] minMoves = new int[n];

        Arrays.fill(minMoves, -1);

        Deque<Integer> box = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            box.offer(i);
        }

        while (!box.isEmpty()) {
            int count = 0;
            int left = box.peek() - 1;
            int right = box.peek() + 1;
            while (left >= 0 && right < n) {
                if (moves[box.peek()] > moves[left] && moves[box.peek()] > moves[right]) {
                    minMoves[box.peek()] = count;
                    break;
                } else if (moves[box.peek()] <= moves[left]) {
                    left--;
                    count++;
                } else if (moves[box.peek()] <= moves[right]) {
                    right++;
                    count++;
                }
            }
            box.pop();
        }

        return minMoves;
    }
}
