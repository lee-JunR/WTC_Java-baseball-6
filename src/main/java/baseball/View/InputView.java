package baseball.View;

import baseball.domain.BallNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

  private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
  public static final String RETRY_NUMBERS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  public static final String INPUT_ERROR_MESSAGE = "올바른 입력 형식이 아닙니다.";
  public static final String RESTART_NUMBER = "1";
  public static final String END_NUMBER = "2";

  public static List<BallNumber> inputTryNumbers() {
    String input = readInput(INPUT_NUMBERS_MESSAGE);
    validateInputInteger(input);
    return IntegerToBallNumberList(input);
  }

  private static List<BallNumber> IntegerToBallNumberList(String input) {
    List<BallNumber> ballNumberList = input.chars()
        .mapToObj(c -> new BallNumber(Character.getNumericValue((char) c)))
        .collect(Collectors.toList());
    return ballNumberList;
  }

  public static int inputRetryNumber() {
    String input = readInput(RETRY_NUMBERS_MESSAGE);
    validateInputInteger(input);
    validateRange(input);
    return Integer.parseInt(input);
  }

  private static void validateRange(String input) {
    if (!checkRange(input)) {
      throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
  }

  private static boolean checkRange(String input) {
    return input.equals(RESTART_NUMBER) || input.equals(END_NUMBER);
  }

  private static void validateInputInteger(String input) {
    if (!isInteger(input)) {
      throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
  }

  private static boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static String readInput(String message) {
    System.out.print(message);
    return Console.readLine();
  }
}
