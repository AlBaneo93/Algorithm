import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_14681 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean x = Integer.parseInt(br.readLine()) > 0;
    boolean y = Integer.parseInt(br.readLine()) > 0;
    int ans = 0;
    if (y) {
      if (x)
        ans = 1;
      else
        ans = 2;
    } else {
      if (!x)
        ans = 3;
      else
        ans = 4;
    }
    System.out.println(ans);
  }
}
