package baseball.Service;

import baseball.Constant.BallStatus;
import baseball.domain.BallNumber;
import baseball.domain.BaseBallNumbers;

public class Score {

  private static BaseBallNumbers answerNumbers;

  public Score(BaseBallNumbers answerNumbers) {
    this.answerNumbers = answerNumbers;
  }

  public BallStatus checkStrike(BallNumber ballNumber, int location) {
    if (isStrike(ballNumber, location)) {
      return BallStatus.STRIKE;
    }
    return BallStatus.NOTHING;
  }

  private boolean isStrike(BallNumber ballNumber, int location) {
    return answerNumbers.getNumbers(location).getBallNumber() == ballNumber.getBallNumber();
  }

  public BallStatus checkBall(BallNumber ballNumber, int location) {
    if (isBall(ballNumber, location)) {
      return BallStatus.BALL;
    }
    return BallStatus.NOTHING;
  }

  private boolean isBall(BallNumber ballNumber, int location) {
    return (answerNumbers.getNumbers(location).getBallNumber() != ballNumber.getBallNumber())
        && answerNumbers.getNumbers().stream()
        .anyMatch(x -> x.getBallNumber() == ballNumber.getBallNumber());
  }
}
