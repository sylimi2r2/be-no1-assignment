package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<Number> results;

    ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    public Number calculate(T leftOperand, T rightOperand, OperatorType operator) {
        Number result;
        switch (operator) {
            case ADD:
                result = leftOperand.doubleValue() + rightOperand.doubleValue();
                break;
            case SUB:
                result = leftOperand.doubleValue() - rightOperand.doubleValue();
                break;
            case MUL:
                result = leftOperand.doubleValue() * rightOperand.doubleValue();
                break;
            case DIV:
                if (rightOperand.doubleValue() == 0.0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    result = null;
                    break;
                }
                result = leftOperand.doubleValue() / rightOperand.doubleValue();
                break;
            default:
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

    public List<Number> getResultsGreater(double value) {
        return results.stream()
                .filter(num -> num.doubleValue() > value)
                .collect(Collectors.toList());
    }
}
