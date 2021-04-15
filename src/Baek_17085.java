import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Title : 십자가 2개 놓기
 * ANSWER : 십자가 2개 넓이의 곱의 최대값 구하기
 * */
public class Baek_17085 {
  /*
   * 4방이 #인 지점에서 가장 큰 십자가를 놓았을때를 비교
   * 십자가를 놓을 수 있는 지점을 먼저 탐색 --> 입력을 받을 때 가능, 좌표를 리스트에 저장
   * 각 좌표에 십자가를 놓는 것을 완전탐색으로 풀기
   * */

  static int N, M, ans, minLen;

  static boolean[][] map;

  static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  static ArrayList<Pair> pos;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ans = 1;

    map = new boolean[N][M];
    pos = new ArrayList<>();
    minLen = Math.min(N, M) / 2;

    for (int i = 0; i < N; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        map[i][j] = tmp[j] == '#';
        if (map[i][j] && isPutCross(i, j, 0)) {
          //          십자가를 놓을 수 있는 좌표를 추가
          pos.add(new Pair(i, j));
        }
      }
    }

    func(0);

    System.out.println(ans);
  }

  public static void func(int idx) {


    Pair p = pos.get(idx);

    for (int i = 0; i < minLen; i++) {
      func(idx + 1);
    }
  }

  public static boolean isPutCross(int y, int x, int mul) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dir[i][0];
      int nx = x + dir[i][1];
      if (ny < 0 || nx < 0 || ny >= N || nx >= M)
        return false;
    }
    return true;
  }

  static class Pair {
    int y, x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
