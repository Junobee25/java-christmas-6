package christmas.view;

public class ErrorMessage {
    private static final String inputDateError = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String inputOrderError = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";


    public static void inputDateError() {
        System.out.println(inputDateError);
    }

    public static void inputOrderError() {
        System.out.println(inputOrderError);
    }
}
