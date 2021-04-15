import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Title : 체스판 다시 칠하기
 * Type : 구현?
 * */
public class Baek_1018 {
  static int M, N, ans = Integer.MAX_VALUE, startX, startY;

  static String[] comp = {"WBWBWBWB", "BWBWBWBW"}, strMap;

  static boolean[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    strMap = new String[N];
    map = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      strMap[i] = tmp;
      char[] tmpCarr = tmp.toCharArray();

      for (int j = 0; j < M; j++) {
        map[i][j] = tmpCarr[j] == 'W';
      }
    }


    for (int i = 0; i <= N - 8; i++) {
      startY = i;
      for (int j = 0; j <= M - 8; j++) {
        startX = j;
        // 시작점 바꾸지 않고 시작
        func(i, startX + 1, 0, 2);
        // 시작점 바꾸고 시작
        map[startY][startX] = !map[startY][startX];
        func(i, startX + 1, 1, 2);
        map[startY][startX] = !map[startY][startX];
      }
    }

    System.out.println(ans);
  }

  private static void func(int y, int x, int sum, int idx) {

    if (sum > ans) {
      return;
    }

    if (idx == 64) {
      ans = Math.min(ans, sum);
      return;
    }


    if (y - 1 >= 0) {
      if (map[y][x] == map[y - 1][x]) {
        map[y][x] = !map[y - 1][x];
        func(startY + (idx / 8), startX + (idx % 8), sum + 1, idx + 1);
        map[y][x] = !map[y][x];
      } else {
        func(startY + (idx / 8), startX + (idx % 8), sum, idx + 1);
      }
    } else {
      if (map[y][x] == map[y][x - 1]) {
        map[y][x] = !map[y][x - 1];
        func(startY + (idx / 8), startX + (idx % 8), sum + 1, idx + 1);
        map[y][x] = !map[y][x];
      } else {
        func(startY + (idx / 8), startX + (idx % 8), sum, idx + 1);
      }
    }
  }

  public static int strFunc(int startComp, String[] curMap) {
    int ret = 0;
    for (int i = 0; i < 8; i++, startComp++) {
      // 비교
      if (!curMap[i].contentEquals(comp[startComp % 2])) {
        // 다름
        char[] tCharArr = curMap[i].toCharArray();
        char[] tCharArr2 = comp[startComp % 2].toCharArray();
        for (int j = 0; j < 8; j++) {
          if (tCharArr[j] != tCharArr2[j])
            ret++;
        }
      }
    }
    return ret;
  }
}
