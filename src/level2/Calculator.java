package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Number> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    public Number calculate(int leftOperand, int rightOperand, char operator) {
        Number result;
        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                // zero divisor 방지
                if (rightOperand == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    result = null;
                    break;
                }

                // 나눗셈 결과가 소수인 경우 판별
                if (leftOperand % rightOperand != 0) {
                    result = (double)leftOperand / rightOperand;
                    break;
                }

                result = leftOperand / rightOperand;
                break;
            default:
                System.out.println("잘못된 연산자를 입력하셨습니다.");
                result = null;
        }

        if (result != null)
            results.add(result);

        return result;
    }

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    public void removeResult() {
        if (!results.isEmpty())
            results.remove(0);
    }
}
