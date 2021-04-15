import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Title : 매직 스퀘어로 변경하기
 * Type : 완전 탐색
 * 대각선의 수만 같으면 된다
 * */
public class Baek_16945 {

  static int ans = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[3][3];
    StringTokenizer st;
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    boolean[] visit = new boolean[10];
    visit[5] = true;
    go(arr, Math.abs(5 - arr[1][1]), visit, 0, 0);
    System.out.println(ans);
  }

  public static void go(int[][] arr, int cost, boolean[] visit, int y, int x) {

    if (45 < cost) {
      // pruning
      return;
    }

    if (x == 0 && y == 3) {
      for (int i = 1; i <= 9; i++) {
        if (!visit[i]) {
          return;
        }
      }

      if (chk(arr)) {
        ans = Math.min(ans, cost);
      }
      return;
    }


    for (int i = 1; i <= 9; i++) {
      int tcost = Math.abs(i - arr[y][x]);
      int tmp = arr[y][x];
      if (!visit[i]) {
        arr[y][x] = i;
        visit[i] = true;
        if (x == 2) {
          go(arr, cost + tcost, visit, y + 1, 0);
        } else {
          go(arr, cost + tcost, visit, y, x + 1);
        }
        arr[y][x] = tmp;
        visit[i] = false;
      }
    }
  }

  public static boolean chk(int[][] arr) {
    int[] sum = new int[8];

    for (int i = 0; i < 3; i++) {
      sum[0] += arr[i][0]; // 세로 1
      sum[1] += arr[i][1]; // 세로 2
      sum[2] += arr[i][2]; // 세로 3
      sum[3] += arr[0][i]; // 가로 1
      sum[4] += arr[1][i]; // 가로 2
      sum[5] += arr[2][i]; // 가로 3
      sum[6] += arr[i][i]; // 좌상 우하
      sum[7] += arr[2 - i][i]; // 좌하 우상
    }

    int tt = sum[0];
    for (var tmp : sum) {
      if (tt != tmp) {
        return false;
      }
    }
    return true;
  }
}
