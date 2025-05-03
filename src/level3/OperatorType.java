package level3;

import java.util.Arrays;

public enum OperatorType {
    ADD('+'), SUB('-'), MUL('*'), DIV('/');

    private final char op;

    OperatorType(char op) {
        this.op = op;
    }

    public static OperatorType ret(char operator) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.op == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자를 입력하였습니다."));
    }
}
