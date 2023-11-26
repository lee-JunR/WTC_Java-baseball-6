package baseball.Service;

import baseball.Constant.BallStatus;
import baseball.domain.BaseBallNumbers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class ScoreService {

  public static final int START_NUMBERS_INCLUSIVE = 0;
  public static final int BASEBALL_NUMBERS_SIZE = 3;
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

  // TODO : nothing도 따로 메소드로 관리하는게 나을까?
  public Boolean isNothing(BaseBallNumbers playerNumbers, int index) {
    return answerNumbers.getNumbers().stream()
        .allMatch(x -> x.getBallNumber() != playerNumbers.getNumbers(index));
  }

  public HashMap<BallStatus, Integer> countScore(BaseBallNumbers playerNumbers) {
    // TODO : 더 좋은 방법은 없을까? + 따로 메소드 만들어서 해도 됐을듯. + 매직넘버 사용 위가 나을까 아래가 나을까?
    int countStrike = (int) IntStream.range(START_NUMBERS_INCLUSIVE, playerNumbers.getNumbers().size())

        .filter(i -> isStrike(playerNumbers, i))
        .count();
    int countBall = (int) IntStream.range(START_NUMBERS_INCLUSIVE, BASEBALL_NUMBERS_SIZE)
        .filter(i -> isBall(playerNumbers, i))
        .count();
    LinkedHashMap<BallStatus, Integer> countMap = new LinkedHashMap<>();
    countMap.put(BallStatus.BALL, countBall);
    countMap.put(BallStatus.STRIKE, countStrike);
    return countMap;
  }
}
