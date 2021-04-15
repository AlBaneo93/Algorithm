import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1051 {
  static int N, M, ans;

  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        map[i][j] = Character.digit(tmp[j], 10);
      }
    }

    int minLen = Math.min(N, M);
    ans = Integer.MAX_VALUE;
    loop:
    for (int k = minLen; k >= 1; k--) {
      for (int i = 0; i < N - k; i++) {
        for (int j = 0; j < M - k; j++) {
          if (map[i][j] == map[i + k][j] && map[i][j + k] == map[i + k][j + k]) {
            if (map[i][j] == map[i + k][j + k]) {
              ans = k + 1;
              break loop;
            }
          }
        }
      }
    }

    System.out.println(ans * ans);
  }
}
