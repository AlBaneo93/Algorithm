/*
 * Title : GPS
 * 모든 도로는 왕복도로
 * 경로 오류가 발생할 경우, 최소한의 횟수로 경로를 수정가능 할때 오류의 수
 * */
public class Programmers_1837 {

  static int answer;

  static int[][] dp;

  static boolean[][] map;

  /**
   * gps_log의 순서대로 따라가다가 오류가 발생(map[start][end]=false)하면 길을 찾고 tmp++
   */
  public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
    answer = Integer.MAX_VALUE;
    map = new boolean[201][201];
    dp = new int[201][201];

    for (var arr : edge_list) {
      map[arr[0]][arr[1]] = true;
      map[arr[1]][arr[0]] = true;
    }

    //    fun(gps_log, 1, gps_log[0], 0);

    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  public int fun(int[] gps, int idx, int start, int n) {

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int val = 1;
      if (val == -1)
        continue;
      min = Math.min(min, val);
    }


    if (min == Integer.MAX_VALUE) {
      dp[idx][gps[idx + 1]] = -1;
    }
    dp[idx][gps[idx + 1]] = min;
    return dp[idx][gps[idx + 1]];
  }

}
