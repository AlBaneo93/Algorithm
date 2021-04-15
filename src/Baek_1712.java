import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1712 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long cost = Long.parseLong(st.nextToken());
    long varCost = Long.parseLong(st.nextToken());
    long value = Long.parseLong(st.nextToken());
    long ans = 0L;
    long sum = 0L;

    if (varCost > value)
      ans = -1;
    else {
      while (cost >= sum) {
        cost += varCost;
        sum += value;
        ans++;
      }
    }

    System.out.println(ans);
  }
}
