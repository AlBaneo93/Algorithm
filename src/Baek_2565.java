import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Title : 전깃줄
 * 전깃줄이 교차하지 않게 하기위해 없애야하는 최소한의 전깃줄 갯수는?
 *
 * 역발상 필요 - 최대로 겹치지 않게 설치할 수 있는 전깃줄의 갯수를 구하고
 * 전체 전깃줄 갯수에서 빼서 구한다
 *
 * 최대로 겹치지 않게 설치할 수 있는 전깃줄의 갯수 : LIS(최장 부분 증가 수열)
 * */
public class Baek_2565 {

  static int N = 0;

  static int[][] wire;

  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    wire = new int[N][2];
    dp = new int[N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      wire[i][0] = a;
      wire[i][1] = b;
    }

    Arrays.sort(wire, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    int tmp = 0;
    // 현재 연결하려는 전깃줄
    for (int i = 0; i < N; i++) {
      // i번째 전깃줄을 연결할 때 겹치지 않고 최대로 연결될 수 있는 전깃줄의 갯수
      dp[i] = 1;  // 전깃줄을 연결할 수 있는 최소갯수
      // 현재 전깃줄 보다 이전에 연결된 전깃줄
      for (int j = 0; j < i; j++) {
        if (wire[j][1] < wire[i][1]) { // 전깃줄이 겹치지 않기 위한 조건
          dp[i] = Math.max(dp[i], dp[j] + 1); // 과거의 최대 전깃줄 개수 + 1
        }
      }
      tmp = Math.max(dp[i], tmp);
    }
    System.out.println(N - tmp);
  }

}
