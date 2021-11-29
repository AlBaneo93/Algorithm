import java.util.Arrays;

/**
 * Title : 쿼드압축 후 개수 세기
 */
public class Programmers_68936 {

  static int N = 0, one = 0, zero = 0;

  static int[][] map;

  public int[] solution(int[][] arr) {
    N = arr.length;
    map = arr.clone();

    // 초기 시작
    fun(0, N, 0, N);

    return new int[]{zero, one};
  }


  public void fun(int sy, int ey, int sx, int ex) {
    // 길이 나누어서 실행
    int halfY = (sy + ey) / 2;
    int halfX = (sx + ex) / 2;

    if (!chkRectangle(sy, ey, sx, ex)) {
      fun(sy, halfY, sx, halfX);
      fun(sy, halfY, halfX, ex);
      fun(halfY, ey, sx, halfX);
      fun(halfY, ey, halfX, ex);
    } else {
      if (map[sy][sx] == 1)
        one++;
      else
        zero++;
    }
  }

  public boolean chkRectangle(int sy, int ey, int sx, int ex) {
    int before = map[sy][sx];
    for (int i = sy; i < ey; i++) {
      for (int j = sx; j < ex; j++) {
        if (before != map[i][j])
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
    System.out.println(Arrays.toString(new Programmers_68936().solution(arr)));
  }

}
