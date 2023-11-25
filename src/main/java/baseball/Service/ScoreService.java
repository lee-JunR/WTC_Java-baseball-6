package baseball.Service;

import baseball.Constant.BallStatus;
import baseball.domain.BaseBallNumbers;
import java.util.HashMap;
import java.util.stream.IntStream;

public class ScoreService {

  private static BaseBallNumbers answerNumbers;

  public ScoreService(BaseBallNumbers answerNumbers) {
    this.answerNumbers = answerNumbers;
  }

  public Boolean isStrike(BaseBallNumbers playerNumbers, int index) {
    // TODO : 디미터의 법칙 지킬것!
    return playerNumbers.getNumbers(index).getBallNumber() == answerNumbers.getNumbers(index).getBallNumber();
  }

  public Boolean isBall(BaseBallNumbers playerNumbers, int index) {
    return (playerNumbers.getNumbers(index).getBallNumber() != answerNumbers.getNumbers(index)
        .getBallNumber()) && (answerNumbers.getNumbers().stream()
        // TODO : 디미터의 법칙 지킬것!
        .anyMatch(x -> x.getBallNumber() == playerNumbers.getNumbers(index).getBallNumber()));
  }

  public Boolean isNothing(BaseBallNumbers playerNumbers, int index) {
    return answerNumbers.getNumbers().stream()
        // TODO : 디미터의 법칙 지킬것!
        .allMatch(x -> x.getBallNumber() != playerNumbers.getNumbers(index).getBallNumber());
  }

  public HashMap<BallStatus, Integer> countScore(BaseBallNumbers playerNumbers) {
    // TODO : 더 좋은 방법은 없을까?
    int countStrike = (int) IntStream.range(0, 3)
        .filter(i -> isStrike(playerNumbers, i))
        .count();
    int countBall = (int) IntStream.range(0, 3)
        .filter(i -> isBall(playerNumbers, i))
        .count();
    int countNothing = (int) IntStream.range(0, 3)
        .filter(i -> isNothing(playerNumbers, i))
        .count();
    HashMap<BallStatus, Integer> countMap = new HashMap<BallStatus, Integer>();
    countMap.put(BallStatus.BALL, countBall);
    countMap.put(BallStatus.STRIKE, countStrike);
    return countMap;
  }
}
