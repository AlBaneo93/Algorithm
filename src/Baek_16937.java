import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 두 스티커
 * */
public class Baek_16937 {
  static int N, ans;

  static Sticker[] stickers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    N = Integer.parseInt(br.readLine());

    stickers = new Sticker[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      stickers[i] = new Sticker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    combi(new boolean[N], N, 2, 0);
    System.out.println(ans);
  }

  public static void combi(boolean[] visit, int n, int r, int idx) {

    if (idx == r) {
      Sticker[] ss = new Sticker[2];
      int tidx = 0;
      for (int i = 0; i < N; i++) {
        if (visit[i]) {
          ss[tidx++] = stickers[i];
        }
      }

      if (func(ss[0], ss[1])) {
        int tmp = ss[0].height * ss[0].width;
        int tmp1 = ss[1].height * ss[1].width;
        ans = Math.max(ans, tmp + tmp1);
      }
      return;
    }

    if (idx == n) {
      return;
    }

    visit[idx] = true;
    combi(visit, n, r, idx + 1);

    visit[idx] = false;
    combi(visit, n, r, idx + 1);
  }

  public static boolean func(Sticker a, Sticker b) {
    //
    return false;
  }

  static class Sticker {
    int width;

    int height;

    public Sticker(int width, int height) {
      this.width = width;
      this.height = height;
    }
  }
}
