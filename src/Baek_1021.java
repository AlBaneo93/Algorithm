import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * Title : 회전하는 큐
 * */
public class Baek_1021 {

  static ArrayList<Integer> queue;

  static HashSet<Integer> set;

  static int N, M, ans = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    queue = new ArrayList<>();
    set = new HashSet<>();

    for (int i = 0; i < N; i++) {
      queue.add(i + 1);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    func(0, 0);

    System.out.println(ans);
  }

  public static void func(int sum, int del) {
    if (sum > ans) {
      return;
    }


    if (set.size() == 0) {
      System.out.println(sum + ", " + ans);
      ans = Math.min(ans, sum);
      return;
    }

    if (queue.size() == 0)
      return;

    int tstart = queue.get(0);
    int tlast = queue.get(queue.size() - 1);

    // 1 pop
    if (set.contains(tstart)) {
      queue.remove(0);
      set.remove(tstart);
      func(sum, del + 1);
      queue.add(0, tstart);
      set.add(tstart);
    } else {
      queue.remove(0);
      func(sum, del);
      queue.add(0, tstart);
    }

    // 3 push right
    queue.remove(queue.size() - 1);
    queue.add(0, tlast);
    func(sum + 1, del);
    queue.add(tlast);
    queue.remove(0);

    // 2 push left
    queue.add(tstart);
    queue.remove(0);
    func(sum + 1, del);
    queue.add(0, tstart);
    queue.remove(queue.size() - 1);
  }
}
