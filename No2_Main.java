import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力パラメータを読み込む
        String input = br.readLine();
        String[] param = input.split(" ");//入力値を空白で分解する

        //数値と演算子を取得
        int num1 = Integer.parseInt(param[0]);
        String operator = param[1];
        int num2 = Integer.parseInt(param[2]);

        //計算して出力
        printResult(num1, operator, num2);
    }

    /**
     * 演算子に応じて計算結果を出力する
     */
    private static void printResult(int num1, String operator, int num2) {
        switch (operator) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                printDivisionResult(num1, num2);
                break;
        }
    }

    /**
     * 除算の結果を出力する（余りがある場合は「商 … 余り」形式）
     */
    private static void printDivisionResult(int num1, int num2) {
        int quotient = num1 / num2;
        int remainder = num1 % num2;

        if (remainder == 0) {
            System.out.println(quotient);
        } else {
            System.out.println(quotient + " … " + remainder);
        }
    }
}
