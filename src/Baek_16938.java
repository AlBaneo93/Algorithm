import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/*
 * Title : 캠프 준비
 * Type : 완전 탐색 ( 0-1 knapsack)
 * 문제를 고르는 방법의 수 구하기
 * */
public class Baek_16938 {

  /*
   * 완전탐색, 난이도 배열을 순회하면서 고르고 안고르고~
   * 조건에 맞으면 ans 변수 1씩 증가
   * */

  static int N, L, R, X, ans;

  static int[] level;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = parseInt(st.nextToken());
    L = parseInt(st.nextToken());
    R = parseInt(st.nextToken());
    X = parseInt(st.nextToken());

    level = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      level[i] = parseInt(st.nextToken());
    }

    func(0, Integer.MAX_VALUE, 0, 0);

    System.out.println(ans);
  }

  public static void func(int idx, int low, int high, int levSum) {
    if (idx > level.length)
      return;

    if (levSum > R) {
      return;
    }

    if (idx == level.length) {
      if (levSum >= L && levSum <= R) {
        // update
        if (high - low >= X) {
          ans++;
        }
      }
      return;
    }

    // 안고름
    func(idx + 1, low, high, levSum);
    // 고름
    func(idx + 1, Math.min(level[idx], low), Math.max(level[idx], high), levSum + level[idx]);
  }
}
