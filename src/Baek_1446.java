import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Title : 지름길
 *
 * */
public class Baek_1446 {

  static int N, D;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    int[] ans = new int[D + 1];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = i;
    }
    ArrayList<Pair>[] adj = new ArrayList[D + 1];

    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      if (end <= D) {
        adj[end].add(new Pair(start, time));
      }
    }

    // 지름길을 타는 경우와 안타는 경우
    // 현재 위치에서 K까지 바로가는 경우와, 지름길을 타고 가는 경우 중 짧은것을 업데이트

    int time = 0;
    for (int i = 0; i <= D; i++) {
      ans[i] = time;
      if (adj[i].size() > 0) {
        for (Pair p : adj[i]) {
          ans[i] = Math.min(ans[i], ans[p.start] + p.time);
        }
      }
      time = ans[i];
      time++;
    }

    System.out.println(ans[D]);
  }

  static class Pair {

    int start, time;

    public Pair(int dst, int len) {
      this.start = dst;
      this.time = len;
    }

  }

}