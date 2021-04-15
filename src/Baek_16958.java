import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Title : 텔레포트
 * Type : 플로이드-워샬 가능, 다른 방법 존재
 * */
public class Baek_16958 {
  static City[] cities;

  static int[][] map;

  static int N, T, ans;

  static boolean[] special;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    cities = new City[N];
    special = new boolean[N];
    map = new int[N][N];


    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      special[i] = Integer.parseInt(st.nextToken()) == 1;
      cities[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = map[j][i] = Integer.MAX_VALUE;
        int tDist = Math.abs(cities[i].x - cities[j].x) + Math.abs(cities[i].y - cities[j].y);
        if (i != j) {
          if (special[i] && special[j])
            map[i][j] = map[j][i] = Math.min(T, tDist);
          else
            map[i][j] = map[j][i] = tDist;
        } else {
          map[i][j] = 0;
        }
      }
    }

    floyd();

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      System.out.println(map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]);
    }

  }

  public static void floyd() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (map[j][k] > map[j][i] + map[i][k]) {
            map[j][k] = map[j][i] + map[i][k];
          }
        }
      }
    }
  }

  public static int func(int start, int goal) {
    int direct = map[start][goal];
    if (special[start] && special[goal]) {
      direct = Math.min(T, direct);
    }

    int sNear = near(start);
    int gNear = near(goal);

    if (sNear != -1 && gNear != -1) {
      direct = Math.min(direct, map[start][sNear] + T + map[gNear][goal]);
    }

    return direct;
  }

  // idx 마을 주변의 텔레포트 가능한 마을 중, 가장 가까운 마을을 찾아 인덱스 반환
  public static int near(int idx) {
    int ret = -1;
    int midx = -1;

    for (int i = 0; i < N; i++) {
      if (!special[i])
        continue;
      if (ret < 0 || ret > map[idx][i]) {
        ret = map[idx][i];
        midx = i;
      }
    }

    return midx;
  }

  public static class City {
    int y, x;

    public City(int y, int x) {
      this.y = y;
      this.x = x;
    }

  }
}
