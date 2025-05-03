package level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

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

            Number result = calculator.calculate(leftOperand, rightOperand, operator);

            if (result != null)
                System.out.println("결과: " + result);

            if (calculator.getResults().size() > 10)
                calculator.removeResult();

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
