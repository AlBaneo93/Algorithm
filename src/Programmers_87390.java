/*
 * Title : n^2 배열 자르기
 * */
public class Programmers_87390 {

  static int ey = 0, ex = 0;

  public int[] solution(int n, long left, long right) {
    ey = (int) (right / n);
    ex = (int) (right % n);

    int y = (int) (left / n);
    int x = (int) (left % n);
    int idx = 0;
    int[] ans = new int[(int) (right - left + 1)];
    while (y != ey || x != ex) {
      ans[idx++] = Math.max(y + 1, x + 1);
      left++;
      y = (int) (left / n);
      x = (int) (left % n);
    }
    ans[idx] = Math.max(y + 1, x + 1);
    return ans;
  }

}
