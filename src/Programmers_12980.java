public class Programmers_12980 {

  public int solution(int n) {
    int tmp = n;
    int ans = 0;

    while (tmp > 0) {
      if (tmp % 2 == 0) {
        tmp /= 2;
      } else {
        ans++;
        tmp--;
      }
    }
    return ans;
  }

}
