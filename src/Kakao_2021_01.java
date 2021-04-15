import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kakao_2021_01 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./test_case.txt")));
    //    int t = Integer.parseInt(br.readLine());
    //    for (int i = 0; i < t; i++) {
    System.out.println(solution(br.readLine()));
    //    }
  }

  public static String solution(String new_id) {
    String answer = "";
    // 1
    new_id = new_id.toLowerCase();
    // 2
    StringBuffer tmpSB = new StringBuffer();
    for (int i = 0; i < new_id.length(); i++) {
      char tmp = new_id.charAt(i);
      if ((tmp - '0' >= 0 && tmp - '0' <= 9) || tmp == '-' || tmp == '_' || tmp == '.' || (tmp - 'a' >= 0 && tmp - 'a' < 26)) {
        tmpSB.append(tmp);
      }
    }
    new_id = tmpSB.toString();
    // 3
    char bef = new_id.charAt(0);
    char[] tmpChars = new_id.toCharArray();
    StringBuffer sb = new StringBuffer();
    sb.append(bef);
    for (int i = 1; i < tmpChars.length; i++) {
      if (bef != tmpChars[i]) {
        sb.append(tmpChars[i]);
        bef = tmpChars[i];
      }
    }
    new_id = sb.toString();
    // 4
    if (new_id.charAt(0) == '.')
      new_id = new_id.substring(1);
    if (new_id.charAt(new_id.length() - 1) == '.')
      new_id = new_id.substring(0, new_id.length() - 1);
    // 5
    if (new_id.isEmpty()) {
      new_id = "a";
    }

    if (new_id.length() >= 16) {
      new_id = new_id.substring(0, 15);

      if (new_id.charAt(new_id.length() - 1) == '.')
        new_id = new_id.substring(0, 15);
    }

    char tmplast = new_id.charAt(new_id.length() - 1);
    StringBuilder new_idBuilder = new StringBuilder(new_id);
    while (new_idBuilder.length() < 3) {
      new_idBuilder.append(tmplast);
    }
    new_id = new_idBuilder.toString();
    return new_id;
  }

}
