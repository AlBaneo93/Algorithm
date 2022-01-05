import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    Integer[] numbers = Arrays.stream(input.split("\\+")).flatMap(s -> Arrays.stream(s.split("\\-"))).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
    List<Integer> exps = new ArrayList<>();
    answer = numbers[0];

  }

}
