import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Baek_16968 {
  static int chars, digits, ans;

  static char[] pattern;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    pattern = br.readLine().toCharArray();
    ans = 1;
    digits = 10;
    chars = 26;
    char before = pattern[0];
    if (before == 'c') {
      ans = chars;
    } else {
      ans = digits;
    }
    int duple = 0;
    for (int i = 1; i < pattern.length; i++) {
      if (pattern[i] == before) {
        duple = 1;
      } else {
        duple = 0;
      }
      before = pattern[i];
      ans *= before == 'c' ? chars - (1 * duple) : digits - (1 * duple);
    }


    System.out.println(ans);
  }

}