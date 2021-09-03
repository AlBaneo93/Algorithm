import java.util.*;

/*
 * Type : 프로그래머스 위클리 챌린지 3
 *
 * 도형 돌리는 방법
 * y, x
 * -x, y
 * y, -x
 * x, -y
 * */
public class Programmers_week3 {

  public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public static int len;

  public static List<Pair<Pair<Integer, Integer>, Integer>> emptyFields = new ArrayList<>();

  public static List<Pair<List<Pair<Integer, Integer>>, Integer>> puzzles = new ArrayList<>();

  public static void main(String[] args) {

  }

  public int solution(int[][] game_board, int[][] table) {
    int answer = -1;
    // 빈공간 시작 좌표 찾기
    findEmptyFields(game_board);
    separatePuzzle(table);

    Collections.sort(emptyFields, (o1, o2) -> Integer.compare(o1.right, o2.right));
    Collections.sort(puzzles, (o1, o2) -> Integer.compare(o1.right, o2.right));
    boolean[] used = new boolean[puzzles.size()];

    for (var empty : emptyFields) {
      for (var puzz : puzzles) {
        // 넣어보기
      }
      // 카운트
    }

    return answer;
  }

  public int count(int[][] map) {
    int ret = 0;
    for (var arr : map) {
      for (var val : arr) {
        ret += val > 0 ? 1 : 0;
      }
    }
    return ret;
  }

  public void findEmptyFields(int[][] map) {
    boolean[][] visit = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (!visit[i][j] && map[i][j] == 0) {
          int tmp = 0;
          Queue<Pair<Integer, Integer>> q = new LinkedList<>();
          q.add(Pair.of(i, j));
          visit[i][j] = true;
          while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            for (int k = 0; k < 4; k++) {
              int ny = p.left + dir[k][0];
              int nx = p.right + dir[k][1];
              if (!visit[ny][nx] && map[ny][nx] == 0) {
                if (rangeChk(ny, nx)) {
                  visit[ny][nx] = true;
                  q.add(Pair.of(ny, nx));
                  tmp++;
                }
              }
            }
          }
          emptyFields.add(Pair.of(Pair.of(i, j), tmp));
        }
      }
    }
  }

  public void separatePuzzle(int[][] map) {
    boolean[][] visit = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (!visit[i][j] && map[i][j] == 1) {
          Queue<Pair<Integer, Integer>> q = new LinkedList<>();
          q.add(Pair.of(i, j));
          visit[i][j] = true;
          List<Pair<Integer, Integer>> tlist = new ArrayList<>();
          tlist.add(Pair.of(i, j));
          while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();

            for (int k = 0; k < 4; k++) {
              int ny = p.left + dir[k][0];
              int nx = p.right + dir[k][1];
              if (!visit[ny][nx] && map[ny][nx] == 1) {
                if (rangeChk(ny, nx)) {
                  visit[ny][nx] = true;
                  q.add(Pair.of(ny, nx));
                  // TODO: 2021-08-18 : 퍼즐 찾기
                  tlist.add(Pair.of(ny, nx));
                }
              }
            }
          }
          puzzles.add(Pair.of(tlist, tlist.size()));
        }
      }
    }
  }

  public boolean rangeChk(int y, int x) {
    return !(y >= len || x >= len || x < 0 || y < 0);
  }

  static class Pair<L, R> {

    L left;

    R right;

    public Pair(L left, R right) {
      this.left = left;
      this.right = right;
    }

    static <L, R> Pair<L, R> of(L left, R right) {
      return new Pair<L, R>(left, right);
    }

  }

}
