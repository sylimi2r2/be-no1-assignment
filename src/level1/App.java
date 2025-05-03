package level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // exit 전까지 무한루프
        while (true) {
            // 양의 정수 input
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int leftOperand = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int rightOperand = sc.nextInt();

            // 연산 기호 input
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            // 연산자에 따른 result 계산
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
                System.out.println("결과: " + result);

            // 종료할지 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String command = sc.next();
            if (command.equals("exit")) {
                System.out.println("종료 중...");
                break;
            }
        }
    }
}
