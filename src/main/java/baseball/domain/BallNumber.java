package baseball.domain;

public class BallNumber {

  private final static int MAX_BASEBALL_NUMBER = 9;
  private final static int MIN_BASEBALL_NUMBER = 1;
  private final static String OUT_OF_RANGE_ERROR_MESSAGE = "숫자는 1~9 사이여야합니다.";
  private final int ballNumber;


  public BallNumber(int number) {
    validate(number);
    this.ballNumber = number;
  }

  public int getBallNumber() {
    return ballNumber;
  }

  private void validate(int number) {
    if (MIN_BASEBALL_NUMBER > number || MAX_BASEBALL_NUMBER < number) {
      throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
    }
  }
}
