import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

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
     * 括弧を含む加算・減算を処理して結果を返す
     */
    private static int calculate(String[] param) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        int result = 0;
        String currentOp = "+";

        for (int i = 0; i < param.length; i++) {
            String token = param[i];

            if (token.equals("(")) {
                //括弧に入る前の状態を保存して、リセット
                numberStack.push(result);
                operatorStack.push(currentOp);
                result = 0;
                currentOp = "+";

            } else if (token.equals(")")) {
                //括弧の中の計算結果を、前の状態に反映
                int savedNum = numberStack.pop();
                String savedOp = operatorStack.pop();
                result = applyOperator(savedNum, savedOp, result);

            } else if (token.equals("+") || token.equals("-")) {
                //演算子を保存
                currentOp = token;

            } else {
                //数値を計算に反映
                int num = Integer.parseInt(token);
                result = applyOperator(result, currentOp, num);
            }
        }

        return result;
    }

    /**
     * 演算子に応じて加算または減算を実行する
     */
    private static int applyOperator(int num1, String operator, int num2) {
        if (operator.equals("+")) {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}
