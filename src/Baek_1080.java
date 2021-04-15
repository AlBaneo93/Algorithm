import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1080 {
  static int N, M, ans;

  static boolean[][] mapA, mapB;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ans = -1;
    mapA = new boolean[N][M];
    mapB = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        mapA[i][j] = tmp[j] == '1';
      }
    }
    for (int i = 0; i < N; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        mapB[i][j] = tmp[j] == '1';
      }
    }

    func(0, 0, 0);

    System.out.println(ans);

  }

  public static void func(int y, int x, int sum) {

    if (x + 3 > M || y + 3 > N)
      return;

    if (wholeChk()) {
      ans = sum;
      return;
    }


    func(y + (x + 1 / M), (x + 1) % M, sum);
    //    바꿔보기
    change(y, x);
    func(y + (x + 1 / M), (x + 1) % M, sum + 1);
    //    원래대로
    change(y, x);

  }

  public static void change(int y, int x) {
    for (int i = 0; i < 3; i++) {
      int ny = y + i;
      for (int j = 0; j < 3; j++) {
        int nx = x + j;
        mapA[ny][nx] = !mapA[ny][nx];
      }
    }
  }

  public static boolean chk(int y, int x) {
    return y >= 0 && x >= 0 && y < N && x < M;
  }

  public static boolean wholeChk() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (mapA[i][j] != mapB[i][j])
          return false;
      }
    }
    return true;
  }
}
