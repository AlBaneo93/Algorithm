import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Title : 트리
 * 어렵게 생각한 결과 못풀었음
 * */
public class Baek_1068 {

  static int N, ans, root;

  static boolean[] visit;

  static ArrayList<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    adj = new ArrayList[N + 1];
    visit = new boolean[N + 1];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (tmp == -1)
        root = i;
      else
        adj[tmp].add(i);
    }
    int rm = Integer.parseInt(br.readLine());
    visit[rm] = true;
    func();
    System.out.println(ans);
  }

  public static void func() {
    Queue<Integer> q = new LinkedList<>();
    q.add(root);
    // root 노드를 지웠을 경우 처리
    if (visit[root])
      return;
    visit[root] = true;

    while (!q.isEmpty()) {
      int tcur = q.poll();

      int cnt = 0;
      for (int i = 0; i < adj[tcur].size(); i++) {
        int tmp = adj[tcur].get(i);
        if (!visit[tmp]) {
          q.add(tmp);
          visit[tmp] = true;
          cnt++;
        }
      }

      if (cnt == 0) {
        // tcur is leaf node
        ans++;
      }
    }

  }

}
