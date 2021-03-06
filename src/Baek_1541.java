import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Title : 잃어버린 괄호
 * 주어진 식에 괄호를 쳐 최소값을 만드는 문제
 * - 뒤에 나오는 모든 +와 양수는 하나로 묶는다
 * */
public class Baek_1541 {

  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    List<Integer> numbers = Arrays.stream(input.split("\\+")).map(s -> s.split("-")).flatMap(Arrays::stream).map(Integer::parseInt).collect(Collectors.toList());

    int idx = 1;
    for (var ch : input.toCharArray()) {
      if (ch == '-') {
        break;
      } else if (ch == '+') {
        idx++;
      }
    }

    for (int i = 0; i < idx; i++) {
      answer += numbers.get(i);
    }

    for (int i = idx; i < numbers.size(); i++) {
      answer -= numbers.get(i);
    }
    System.out.println(answer);
  }

}
