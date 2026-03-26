import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力パラメータを読み込む
        String input = br.readLine();
        String[] param = input.split(" ");//入力値を空白で分解する

        //計算して出力
        int result = calculate(param);
        System.out.println(result);
    }

    /**
     * 複数回の加算・減算を順番に処理して結果を返す
     */
    private static int calculate(String[] param) {
        int result = Integer.parseInt(param[0]);

        for (int i = 1; i < param.length; i += 2) {
            String operator = param[i];
            int nextNum = Integer.parseInt(param[i + 1]);

            if (operator.equals("+")) {
                result += nextNum;
            } else if (operator.equals("-")) {
                result -= nextNum;
            }
        }

        return result;
    }
}
