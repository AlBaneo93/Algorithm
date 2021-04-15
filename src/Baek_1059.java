import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Title : 좋은 구간
 * */
public class Baek_1059 {
  static int n, l, ans;

  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    l = Integer.parseInt(br.readLine());
    arr = new int[l];
    ans = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < l; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    n = Integer.parseInt(br.readLine());
    Arrays.sort(arr);

    int idx = 0;
    for (int i = 0; i < l; i++) {
      if (n < arr[i]) {
        idx = i;
        break;
      } else if (n == arr[i]) {
        idx = -1;
        break;
      }
    }

    if (idx == -1) {
      ans = 0;
    } else {
      int small = 0;
      if (idx != 0)
        small = arr[idx - 1] + 1;
      else
        small = 1;
      int big = arr[idx] - 1;

      // small < x <= n
      int tmp = n - small;
      // n <= x < big
      int tmp1 = big - n;
      // small < x < big
      int tmp2 = tmp * tmp1;

      ans = tmp + tmp1 + tmp2;
    }

    System.out.println(ans);
  }

}
