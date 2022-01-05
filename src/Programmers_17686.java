import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 100글자 이내, 대소문자, 공백, 마침뾰, 빼기로 구성
 * HEAD : 숫자가 아닌 문자, 최소 한 글자 이상
 * NUMBER : 1~5자리, 연속된 숫자, 맨앞에 0 가능
 * TAIL : HEAD NUMBER를 뺀 나머지, 비어있을 수 있음
 *
 * 정렬 규칙 : HEAD 사전 순 정렬, 대소문자 구분 X -> (HEAD가 대소문자 차이 외에 같으면) NUMBER의 숫자 순 정렬
 * -> HEAD와 NUMBER 모두가 같으면, 원래 입력에 주어진 순서 유지
 * */
public class Programmers_17686 {

  static Pattern pattern = Pattern.compile("(^[a-zA-Z\\-\\.\s]*)([0-9]{1,5})");

  //  static Pattern pattern2 = Pattern.compile("");

  static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    //    System.out.println(Arrays.toString(new Programmers_17686().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
    System.out.println(Arrays.toString(new Programmers_17686().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
  }

  public String[] solution(String[] files) {
    int idx = 0;
    for (var file : files) {
      map.put(file, idx++);
    }
    return Arrays.stream(files).sorted((o1, o2) -> {
      Matcher m1 = pattern.matcher(o1);
      Matcher m2 = pattern.matcher(o2);
      //      Matcher mi1 = pattern2.matcher(o1);
      //      Matcher mi2 = pattern2.matcher(o2);
      //      mi1.find();
      //      mi2.find();
      if (m1.group(0).compareToIgnoreCase(m2.group(0)) < 0) {
        return -1;
      } else if (m1.group(0).compareToIgnoreCase(m2.group(0)) == 0) {
        int i1 = Integer.parseInt(m1.group(1));
        int i2 = Integer.parseInt(m2.group(1));
        if (i1 < i2) {
          return -1;
        } else if (i1 == i2) {
          return Integer.compare(map.get(o1), map.get(o2));
        }
      }
      return 1;
    }).toArray(String[]::new);
  }

}
