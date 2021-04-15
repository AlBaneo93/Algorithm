import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* Title : 달팽이는 올라가고 싶다
* Type : Mathematics
* */
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    double a = Double.parseDouble(st.nextToken());
    double b = Double.parseDouble(st.nextToken());
    double v = Double.parseDouble(st.nextToken());
    double time = (v - b) / (a - b);

    System.out.println((int)Math.ceil(time));
  }
}