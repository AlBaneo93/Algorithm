import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Title : 행렬 곱셈 순서
 *
 * 행렬 N개와 각 행렬의 크기가 주어졌을 때
 * 모든 행렬의 곱셈 연산에 필요한 연산의 횟수의 최솟값은?? - 행렬의 순서 변경 불가
 *
 * 분할 정복 + DP 문제
 * */
public class Baek_11049 {

  static int N;

  static Pair[] mat = new Pair[502];

  static int[][] dp = new int[502][502];

  /*
   * 행렬의 순서를 바꾸지는 못하나, 연산의 순서는 변경할 수 있다.
   *
   * */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      mat[i] = Pair.of(r, c);
    }

    int result = func(0, N - 1);
    System.out.println(result);
  }

  public static int func(int x, int y) {
    if (x == y)
      return 0;
    if (dp[x][y] > 0)
      return dp[x][y];

    int tmp = Integer.MAX_VALUE;

    for (int i = x; i < y; i++) {
      tmp = Math.min(tmp, func(x, i) + func(i + 1, y) + mat[x].first * mat[i].second * mat[y].second);
    }
    return dp[x][y] = tmp;
  }

  public static class Pair {

    int first, second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public static Pair of(int first, int second) {
      return new Pair(first, second);
    }

  }

}
