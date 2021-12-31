import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Title : 잃어버린 괄호
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
