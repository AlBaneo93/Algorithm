import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Title : 블록 놀이
 * Type : Math
 * Kx + b = Tower의 높이
 * */
public class Baek_16951 {
  static int N, K, ans;

  static int[] towers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    ans = Integer.MAX_VALUE;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    towers = new int[N];
    for (int i = 0; i < N; i++) {
      towers[i] = Integer.parseInt(st.nextToken());
    }

    loop:
    for (int i = 0; i < N; i++) {
      int tmp = 0;
      int bias = towers[i];

      for (int j = i + 1; j < N; j++) {
        if (towers[j] != (Math.abs(j - i) * K) + bias) {
          tmp++;
        }
      }

      for (int j = 0; j < i; j++) {
        if (towers[j] != bias - (Math.abs(i - j) * K)) {
          tmp++;
        }

        if (bias - (Math.abs(i - j) * K) < 1)
          continue loop;
      }

      ans = Math.min(ans, tmp);
    }

    System.out.println(ans);
  }


}
