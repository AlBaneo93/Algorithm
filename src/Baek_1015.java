import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1015 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    Pair[] pairs = new Pair[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      pairs[i] = new Pair(Integer.parseInt(st.nextToken()), i);
    }

    Arrays.sort(pairs);
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int[] ans = new int[N];
    for (var p : pairs) {
      ans[p.origin_idx] = idx++;
    }
    for (var i : ans) {
      sb.append(i).append(" ");
    }

    System.out.println(sb.toString().strip());

  }

  static class Pair implements Comparable<Pair> {
    int anum;

    int origin_idx;

    public Pair(int anum, int origin_idx) {
      this.anum = anum;
      this.origin_idx = origin_idx;
    }

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(this.anum, o.anum);
    }
  }

}