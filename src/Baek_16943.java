import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_16943 {
  static List<Integer> list = new ArrayList<>();

  static int B, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String tmp = st.nextToken();
    String tmp2 = st.nextToken();
    int N = tmp.length();
    int[] arr = new int[N];

    int tidx = 0;
    for (var a : tmp.toCharArray()) {
      arr[tidx++] = Character.digit(a, 10);
    }
    B = Integer.parseInt(tmp2);
    permutation(N, N, 0, arr);

    Collections.sort(list);
    ans = list.size() == 0 ? -1 : list.get(list.size() - 1);

    System.out.println(ans);
  }

  // Java를 이용해 Permutation 구하기
  // 배열의 첫번째 값 부터 순서대로 하나씩 바꾸어가며 스왑
  // depth를 기준 인덱스로 하여 depth보다 작은 인덱스 값은 고정
  // depth보다 큰 인덱스 값을 가지면 depth와 스왑을 하고 다음 단계로
  public static void permutation(int n, int r, int depth, int[] arr) {
    if (depth == r) {
      aPrint(arr);
      // 종료조건
//      int tmp = arrayToInt(arr, n);
//      if (tmp < B && tmp > 0)
//        list.add(tmp);
    }

    for (int i = depth; i < n; i++) {
      swap(arr, i, depth);
      permutation(n, r, depth + 1, arr);
      swap(arr, i, depth);
    }
  }

  public static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }

  public static int arrayToInt(int[] arr, int size) {

    int tmp = 0;
    for (int i = 0; i < size; i++) {
      if (tmp == 0 && arr[i] == 0)
        return 0;
      tmp += ((int) Math.pow(10, size - i - 1) * arr[i]);
    }
    return tmp;
  }

  public static void aPrint(int[] arr){
    for(var val : arr){
      System.out.print(val+" ");
    }
    System.out.println();
  }
}
