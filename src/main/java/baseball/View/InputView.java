package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
  public static final String RETRY_NUMBERS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  public static final String INPUT_ERROR_MESSAGE = "올바른 입력 형식이 아닙니다.";
  public static final String RESTART_NUMBER = "1";
  public static final String END_NUMBER = "2";

  public int inputTryCount() {
    String input = readInput(INPUT_NUMBERS_MESSAGE);
    validateInputInteger(input);
    return Integer.parseInt(input);
  }

  public int inputRetryNumber() {
    String input = readInput(RETRY_NUMBERS_MESSAGE);
    validateInputInteger(input);
    validateRange(input);
    return Integer.parseInt(input);
  }

  private void validateRange(String input) {
    if (!checkRange(input)){
      throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
  }

  private static boolean checkRange(String input) {
    return input.equals(RESTART_NUMBER) || input.equals(END_NUMBER);
  }

  private void validateInputInteger(String input) {
    if (!isInteger(input)) {
      throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
  }

  private boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private String readInput(String message) {
    System.out.println(message);
    return Console.readLine();
  }
}
