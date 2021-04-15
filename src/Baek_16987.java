import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.GenericArrayType;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Baek_16987 {
  private static int ans, N;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    // INPUT
    ans = 0;
    N = Integer.parseInt(br.readLine());
    Egg[] eggs = new Egg[N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // Logic Start
    func(eggs, 0, 0, new boolean[N]);
    System.out.println(ans);

  }

  public static void func(Egg[] eggs, int cur_egg, int broken, boolean[] is_broken) {
    if (cur_egg == N) {
      ans = Math.max(ans, broken);
      return;
    }


    if (is_broken[cur_egg]) {
      //      손에 든 계란이 깨진 경우 넘어가기
      func(eggs, cur_egg + 1, broken, is_broken);

    } else {
      for (int i = 0; i < N; i++) {

        if (i != cur_egg && !is_broken[i]) {
          Egg tmpCurrent = new Egg(eggs[cur_egg].durable, eggs[cur_egg].weight);
          Egg tmpTable = new Egg(eggs[i].durable, eggs[i].weight);
          int broken_eggs = 0;

          eggs[cur_egg].durable = Math.max(eggs[cur_egg].durable - eggs[i].weight, 0);
          eggs[i].durable = Math.max(eggs[i].durable - eggs[cur_egg].weight, 0);

          if (eggs[cur_egg].durable == 0) {
            is_broken[cur_egg] = true;
            broken_eggs++;
          }
          if (eggs[i].durable == 0) {
            is_broken[i] = true;
            broken_eggs++;
          }

          func(eggs, cur_egg + 1, broken + broken_eggs, is_broken);

          // 원래대로 돌리기
          eggs[cur_egg] = eggs[cur_egg].durable == 0 ? tmpCurrent : eggs[cur_egg];
          eggs[i] = eggs[i].durable == 0 ? tmpTable : eggs[i];

          is_broken[i] = eggs[i].durable == 0;
          is_broken[cur_egg] = eggs[cur_egg].durable == 0;

        }
      }
    }
  }

  public static void ArrayPrint(GenericArrayType[] array) {
    for (var isbroke : array) {
      System.out.print(isbroke + " ");
    }
    System.out.println();
  }

  static class Egg {
    int durable;

    int weight;

    public Egg(int durable, int weight) {
      this.durable = durable;
      this.weight = weight;
    }

  }


}