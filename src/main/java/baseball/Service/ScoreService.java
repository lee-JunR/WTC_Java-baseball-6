package baseball.Service;

import baseball.Constant.BallStatus;
import baseball.domain.BaseBallNumbers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class ScoreService {

  private static BaseBallNumbers answerNumbers;

  public ScoreService(BaseBallNumbers answerNumbers) {
    this.answerNumbers = answerNumbers;
  }

  public Boolean isStrike(BaseBallNumbers playerNumbers, int index) {
    return playerNumbers.getNumbers(index) == answerNumbers.getNumbers(index);
  }

  public Boolean isBall(BaseBallNumbers playerNumbers, int index) {
    return (playerNumbers.getNumbers(index) != answerNumbers.getNumbers(index)
    ) && (answerNumbers.getNumbers().stream()
        .anyMatch(x -> x.getBallNumber() == playerNumbers.getNumbers(index)));
  }

  public Boolean isNothing(BaseBallNumbers playerNumbers, int index) {
    return answerNumbers.getNumbers().stream()
        .allMatch(x -> x.getBallNumber() != playerNumbers.getNumbers(index));
  }

  public HashMap<BallStatus, Integer> countScore(BaseBallNumbers playerNumbers) {
    // TODO : 더 좋은 방법은 없을까?
    int countStrike = (int) IntStream.range(0, 3)
        .filter(i -> isStrike(playerNumbers, i))
        .count();
    int countBall = (int) IntStream.range(0, 3)
        .filter(i -> isBall(playerNumbers, i))
        .count();
    LinkedHashMap<BallStatus, Integer> countMap = new LinkedHashMap<>();
    countMap.put(BallStatus.BALL, countBall);
    countMap.put(BallStatus.STRIKE, countStrike);
    return countMap;
  }
}
