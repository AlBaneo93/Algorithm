import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * Title : 킹
 * Type : 구현
 * */
public class Baek_1063 {

  static int N;

  static HashMap<String, Pair> map = new HashMap<>();

  static String[] xpos = {"A", "B", "C", "D", "E", "F", "G", "H"};

  static int[] ypos = {8, 7, 6, 5, 4, 3, 2, 1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    char[] tchar = st.nextToken().toCharArray();
    Pair kingPos = new Pair(7 - (tchar[1] - '1'), tchar[0] - 'A');
    tchar = st.nextToken().toCharArray();
    Pair rockPos = new Pair(7 - (tchar[1] - '1'), tchar[0] - 'A');
//    System.out.println("king- y: " + kingPos.y + ", x: " + kingPos.x);
//    System.out.println("rock- y: " + rockPos.y + ", x: " + rockPos.x);
//    System.out.println("--------------------------------------");

    map.put("T", new Pair(-1, 0));
    map.put("LT", new Pair(-1, -1));
    map.put("RT", new Pair(-1, 1));
    map.put("L", new Pair(0, -1));
    map.put("R", new Pair(0, 1));
    map.put("LB", new Pair(1, -1));
    map.put("B", new Pair(1, 0));
    map.put("RB", new Pair(1, 1));

    N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      Pair tmpPair = map.get(br.readLine());
      Pair tmpKing = new Pair(kingPos.y + tmpPair.y, kingPos.x + tmpPair.x);

      if (chk(tmpKing.y, tmpKing.x)) {
        // update
        if (tmpKing.y == rockPos.y && tmpKing.x == rockPos.x) {
          Pair tmp = new Pair(rockPos.y + tmpPair.y, rockPos.x + tmpPair.x);
          if (!chk(tmp.y, tmp.x))
            continue;
          rockPos.y = tmp.y;
          rockPos.x = tmp.x;
        }
        kingPos.y = tmpKing.y;
        kingPos.x = tmpKing.x;
      }
      System.out.println("king- y: " + kingPos.y + ", x: " + kingPos.x);
      System.out.println("rock- y: " + rockPos.y + ", x: " + rockPos.x + "\n");
    }

    System.out.println(xpos[kingPos.x] + ypos[kingPos.y] + "\n" + xpos[rockPos.x] + ypos[rockPos.y]);
  }

  public static boolean chk(int y, int x) {
    return y >= 0 && x >= 0 && x < 8 && y < 8;
  }

  static class Pair {
    int y, x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
