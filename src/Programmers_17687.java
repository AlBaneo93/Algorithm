/*
 *
 * */
public class Programmers_17687 {

  static StringBuilder sb;

  public static void main(String[] args) {
    System.out.println(new Programmers_17687().solution(2, 4, 2, 1));
  }

  public String solution(int n, int t, int m, int p) {
    int total = m * t;
    int cnt = 0;
    sb = new StringBuilder(m * t);
    sb.append(0);
    // m * t 만큼은 돌아야함
    while (sb.length() < total) {
      String tmp = String.valueOf(translate(cnt, n));
      sb.append(tmp);
      cnt++;
    }


    int idx = p - 1;
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < t; i++) {
      answer.append(sb.charAt(idx));
      idx += m;
    }

    return answer.toString();
  }

  public StringBuilder translate(int i, int j) {
    StringBuilder tmpStringBuilder = new StringBuilder();

    while (i > 0) {
      tmpStringBuilder.append(fun(i % j));
      i /= j;
    }
    return tmpStringBuilder.reverse();
  }

  public String fun(int val) {
    switch (val) {
      case 10 -> {
        return "A";
      }
      case 11 -> {
        return "B";
      }
      case 12 -> {
        return "C";
      }
      case 13 -> {
        return "D";
      }
      case 14 -> {
        return "E";
      }
      case 15 -> {
        return "F";
      }
      default -> {
        return "" + val;
      }
    }
  }

}
