import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * Title : 캐슬 디펜스
 * Type : 구현, 조합, 완전탐색
 * Notice : 재귀함수를 이용한 구현들에서 구멍이 발생한다
 * TODO: 2021-04-15 - 시간 단축이 가능할것 같다
 * */
public class Baek_17135 {

  static int N, M, D, ans, total;

  static int[][] map, tmap, dir = {{0, -1}, {-1, 0}, {0, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    tmap = new int[N][M];
    ans = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        total += map[i][j];
      }
    }

    func(0, 0, new int[3]);
    System.out.println(ans);
  }

  public static void func(int idx, int sidx, int[] sel) {

    if (idx > M) {
      return;
    }

    if (sidx == 3) {
      for (int i = 0; i < N; i++) {
        tmap[i] = Arrays.copyOf(map[i], map[i].length);
      }

      int tans = 0;
      int tmpTotal = total;
      // TODO : Set을 쓰지 않아도 될것 같다
      Set<Pair> list = new HashSet<>();

      for (int i = 0; i < N; i++) {
        for (var ival : sel) {
          Pair p = archerAttack(N, ival, new boolean[N][M], tmap);
          if (p != null)
            list.add(p);
        }

        // TODO : 여기가 가장 별로야
        for (Pair p : list) {
          if (p != null && tmap[p.y][p.x] == 1) {
            tmap[p.y][p.x] = 0;
            tmpTotal--;
            tans++;
          }
        }
        list.clear();

        tmpTotal -= enemyMove(tmap);


        if (tmpTotal == 0) {
          break;
        }
      }

      ans = Math.max(ans, tans);
      return;
    }

    func(idx + 1, sidx, sel);
    sel[sidx] = idx;
    func(idx + 1, sidx + 1, sel);
  }

  public static int enemyMove(int[][] map) {
    int tmp = 0;
    for (int j = 0; j < M; j++) {
      tmp -= map[N - 1][j];
      map[N - 1][j] = 0;
    }
    for (int j = N - 1; j >= 1; j--) {
      swap(j, j - 1, map);
    }
    return tmp;
  }

  /*
   * 거리가 D 이하, 가장 가까운 적 (거리 비교, 거리 > 0)
   * 다수일 경우 가장 왼쪽의 적 (x값 비교)
   * TODO : 마름모 탐색으로 탐색시간 줄이기
   * */
  public static Pair archerAttack(int ay, int ax, boolean[][] visit, int[][] map) {

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(ay, ax, 0)); // 궁수 바로 앞 좌표

    Pair target = null;

    while (!q.isEmpty()) {
      Pair tp = q.poll();

      for (int i = 0; i < 3; i++) {
        int ny = tp.y + dir[i][0];
        int nx = tp.x + dir[i][1];


        if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
          if (!visit[ny][nx]) {
            int ndist = Math.abs(ny - ay) + Math.abs(nx - ax);

            if (map[ny][nx] == 1 && ndist <= D && ndist > 0) {
              Pair tmp = new Pair(ny, nx, ndist);
              if (target == null) {
                target = tmp;
              } else {
                if (target.compareTo(tmp) > 0) {
                  target = tmp;
                }
              }
            }
            visit[ny][nx] = true;
            q.add(new Pair(ny, nx, ndist));
          }
        }
      }
    }

    return target;
  }

  public static void swap(int idx, int idx2, int[][] map) {
    int[] tmp = map[idx];
    map[idx] = map[idx2];
    map[idx2] = tmp;
  }

  static class Pair implements Comparable<Pair> {

    int y, x, dist;

    public Pair(int y, int x, int dist) {
      this.y = y;
      this.x = x;
      this.dist = dist;
    }

    @Override
    public int compareTo(Pair o) {
      if (this.dist < o.dist) {
        return -1;
      } else if (this.dist == o.dist) {
        return Integer.compare(this.x, o.x);
      }
      return 1;
    }

  }

}
