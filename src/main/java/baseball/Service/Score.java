package baseball.Service;

import baseball.domain.BallNumber;
import baseball.domain.BaseBallNumbers;
public class Score {

  private static BaseBallNumbers answerNumbers;

  public Score(BaseBallNumbers answerNumbers) {
    this.answerNumbers = answerNumbers;
  }

  public String checkStrike(BallNumber ballNumber, int location) {
    if (answerNumbers.getNumbers(location).getBallNumber() == ballNumber.getBallNumber()) {
      return "스트라이크";
    }
    return "스트라이크 아님";
  }
}
