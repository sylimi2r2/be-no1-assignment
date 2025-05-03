package level3;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator<Double>();
        boolean running = true;

        // exit 전까지 무한루프
        while (running) {
            System.out.println("1. 계산");
            System.out.println("2. 연산 기록 보기");
            System.out.println("3. 연산 기록 중 큰 값들 보기");
            System.out.println("4. exit");
            System.out.print("메뉴 입력: ");
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    Double leftOperand = sc.nextDouble();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    Double rightOperand = sc.nextDouble();

                    // 연산 기호 input
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    OperatorType operator;
                    try {
                        operator = OperatorType.ret(sc.next().charAt(0));
                    } catch(IllegalArgumentException e) {
                        System.out.println(e);
                        continue;
                    }

                    Number result = calculator.calculate(leftOperand, rightOperand, operator);

                    if (result != null)
                        System.out.println("결과: " + result);

                    break;
                case 2:
                    List results = calculator.getResults();
                    System.out.print("결과: ");
                    results.stream()
                            .map(num -> num + ", ")
                            .forEach(System.out::print);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("기준값 입력: ");
                    double value = sc.nextDouble();
                    List resultsGreater = calculator.getResultsGreater(value);
                    System.out.print("결과: ");
                    resultsGreater.stream()
                            .map(num -> num + ", ")
                            .forEach(System.out::print);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("종료 중...");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력");
            }
        }
    }
}
