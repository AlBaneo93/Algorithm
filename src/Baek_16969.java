import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Baek_16969 {
  static long chars, digits, ans;

  static char[] pattern;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    pattern = br.readLine().toCharArray();
    ans = 1L;
    digits = 10L;
    chars = 26L;
    char before = pattern[0];
    if (before == 'c') {
      ans = chars;
    } else {
      ans = digits;
    }
    long duple = 0L;
    for (int i = 1; i < pattern.length; i++) {
      if (pattern[i] == before) {
        duple = 1L;
      } else {
        duple = 0L;
      }
      before = pattern[i];
      ans *= before == 'c' ? (chars - (1 * duple)) % 1000000009 : (digits - (1 * duple)) % 1000000009;
      ans %= 1000000009;
    }


    System.out.println(ans);
  }
}
