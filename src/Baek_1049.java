import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1049 {
  static int N, M;

  static int[] six, one;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    six = new int[M];
    one = new int[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      six[i] = Integer.parseInt(st.nextToken());
      one[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(six);
    Arrays.sort(one);

    int tmp = (N / 6) * six[0] + (N % 6) * one[0];
    int tmp1 = (N / 6 + 1) * six[0];
    int tmp2 = N * one[0];
    int tmp4 = Integer.MAX_VALUE;
    if (N % 6 == 0) {
      tmp4 = (N / 6) * six[0];
    }

    System.out.println(Math.min(Math.min(tmp, tmp1), Math.min(tmp2, tmp4)));
  }


}
