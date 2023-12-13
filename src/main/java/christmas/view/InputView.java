package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너 입니다.";
    private static final String EXPECT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)";
    private static final String INPUT_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static String input() {
        return Console.readLine();
    }

    public static void welcome() {
        System.out.println(WELCOME);
        System.out.println(EXPECT_DATE);
    }

    public static void inputOrderAndCount() {
        System.out.println(INPUT_ORDER);
    }
}
