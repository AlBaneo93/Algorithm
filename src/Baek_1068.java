import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
*
4
-1 0 0 1
3
correct : 2
answer : 1
* */
public class Baek_1068 {

  static int ans;

  static int[] parent = new int[50];

  static ArrayList[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    tree = new ArrayList[50];
    //    for (int i = 0; i < 50; i++) {
    //      tree[i] = new ArrayList();
    //    }

    StringTokenizer st = new StringTokenizer(br.readLine());

    int rootIdx = -1;
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());

      if (tmp == -1) {
        rootIdx = i;
        continue;
      }

      if (tree[tmp] == null)
        tree[tmp] = new ArrayList<>();

      parent[i] = tmp;
      tree[tmp].add(i);
    }

    int RM = Integer.parseInt(br.readLine());

    tree[RM] = null;
    tree[parent[RM]].remove(RM);  // RM부모에서 RM을 제거

    if (RM == rootIdx)
      ans = 0;
    else {
      int tas = getLeaf(tree[rootIdx]);
      System.out.println("tas: " + tas);
      if (tas == 0) {
        ans = tree[rootIdx].size();
      } else {
        ans = tas;
      }
    }

    System.out.println(ans);
  }

  public static int getLeaf(ArrayList<Integer> list) {
    if (list == null)
      return 0;

    if (list.size() == 0)
      return 1;

    int tmp = 0;
    for (int i = 0; i < list.size(); i++) {
      tmp += getLeaf(tree[list.get(i)]);
    }

    return tmp;
  }
}
