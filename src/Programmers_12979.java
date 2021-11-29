/**
 * 각 영역별로 나누고 각 영역에서 이분탐색을 통해 몇개의 기지국이 들어가는지 찾아낸다
 */
public class Programmers_12979 {


  public int solution(int n, int[] stations, int w) {
    int answer = 0;
    int len = 2 * w + 1;
    int before = 0;

    for (var station : stations) {
      int min = station - w - 1;
      int max = station + w;

      if (min > before) {
        answer += (min - before) / len;
        if ((min - before) % len > 0) {
          answer++;
        }
      }
      before = max;
    }

    if (before < n) {
      answer += (n - before) / len;
      if ((n - before) % len > 0) {
        answer++;
      }
    }

    return answer;
  }

}
