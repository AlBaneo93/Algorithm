/*
 * 로봇의 방향전환은 한 칸을 축으로 해서 90도 움직이는데,
 * 이 때 움직이는 방향으로 벽이 있으면 회전하지 못한다
 * */
public class Programmers_60063 {

  static int[][]
      dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {0, 0}, {0, 0}},
      dir2 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {0, 0}, {0, 0}, {-1, -1}, {1, -1}},
      map;

  static int N = 0, answer = Integer.MAX_VALUE;

  static boolean[][][] visit;

  public int solution(int[][] board) {
    N = board.length;
    map = board.clone();
    visit = new boolean[2][N][N];
    visit[0][0][0] = visit[1][0][1] = true;

    // false : 가로, true: 세로
    fun(0, 0, 0, 1, false, 1);

    return answer;
  }

  // 회전 or 이동이 가능한지 판단
  public boolean isMove(int y, int x) {
    return map[y][x] != 1;
  }

  public boolean isFinished(int y, int x) {
    return y == N && x == N;
  }

  public boolean chk(int y, int x) {
    return y >= 0 && y < N && x >= 0 && x < N;
  }

  public void fun(int w1y, int w1x, int w2y, int w2x, boolean state, int sec) {
    System.out.println(String.format("original:: w1 (%d, %d) / w2 (%d, %d)", w1y, w1x, w2y, w2x));

    // 종료조건, 두 날개중 하나가 N, N일 때
    if (isFinished(w1y, w1x) || isFinished(w2y, w2x)) {
      System.out.println(String.format("종료지점 도착 - w1 (%d, %d) / w2 (%d, %d)", w1y, w1x, w2y, w2x));
      answer = Math.min(answer, sec);
      return;
    }


    // 모든 이동을 시행
    for (int i = 0; i < 8; i++) {
      int nw1y = w1y + dir[i][0];
      int nw1x = w1x + dir[i][1];
      int nw2y = w2y + dir2[i][0];
      int nw2x = w2x + dir2[i][1];

      if (i >= 4) {
        int tmp = state ? -1 : 1;
        nw1y = w1y + (dir[i][0] * tmp);
        nw1x = w1x + (dir[i][1] * tmp);
        nw2y = w2y + (dir2[i][0] * tmp);
        nw2x = w2x + (dir2[i][1] * tmp);
        System.out.println(String.format("w1 (%d, %d) / w2 (%d, %d)", nw1y, nw1x, nw2y, nw2x));
      }


      if (chk(nw1y, nw1x) && chk(nw2y, nw2x)) {
        // 다음 위치가 맵의 내부일 때
        if (i >= 4) {
          // 회전할 경우 가로 -> 세로, 세로->가로
          state = !state;
        }

        if (isMove(nw1y, nw1x) && isMove(nw2y, nw2x)) {
          // 이동 가능
          if (!visit[0][nw1y][nw1x] && !visit[1][nw2y][nw2x]) {
            // 각 날개가 방문한적이 없을 때
            visit[0][nw1y][nw1x] = true;
            visit[1][nw2y][nw2x] = true;
            fun(nw1y, nw1x, nw2y, nw2x, i >= 4 ? !state : state, sec + 1);
            visit[0][nw1y][nw1x] = false;
            visit[1][nw2y][nw2x] = false;
            state = !state;
          }
        }
      }
    }

    System.out.println();

  }

  public static void main(String[] args) {
    int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
    System.out.println(new Programmers_60063().solution(board));
  }

}
