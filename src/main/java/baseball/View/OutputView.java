package baseball.View;

import baseball.Constant.BallStatus;
import java.util.Map;

public class OutputView {

  public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

  public void printGameStart() {
    System.out.println(START_GAME_MESSAGE);
  }

  public static void printBallsStatus(Map<BallStatus, Integer> scoreCount) {
    boolean nothingCondition = isNothing(scoreCount);

    if (nothingCondition) {
      System.out.printf("%s", BallStatus.NOTHING.getStatus());
    }
    scoreCount.forEach((status, count) -> {
      if (!nothingCondition && count > 0) {
        System.out.printf("%d%s ", count, status.getStatus());
      }
    });
    System.out.println();
  }

  private static boolean isNothing(Map<BallStatus, Integer> scoreCount) {
    return scoreCount.get(BallStatus.BALL) == 0
        && scoreCount.get(BallStatus.STRIKE) == 0; // 스트라이크와 볼의 개수가 0 이면 nothing
  }
}
