package baseball.View;

import baseball.Constant.BallStatus;
import java.util.Map;

public class OutputView {

  public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
  public static final String GAME_RESULT_MESSAGE = "\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String END_GAME_MESSAGE = "게임 종료";
  public static final int MAX_STRIKE_COUNT = 3;

  public static void printGameStart() {
    System.out.println(START_GAME_MESSAGE);
  }

  public static void printBallsStatus(Map<BallStatus, Integer> scoreCount) {
    boolean nothingCondition = isNothing(scoreCount);

    if (nothingCondition) {
      System.out.printf("%s", BallStatus.NOTHING.getStatus()); // 낫싱
    }
    scoreCount.forEach((status, count) -> {
      if (!nothingCondition && count > 0) { // 스트라이크와 볼의 개수가 0보다 크면 실행
        System.out.printf("%d%s ", count, status.getStatus()); // %d개 스트라이크
      }
    });
    printResult(scoreCount);
  }

  private static boolean isNothing(Map<BallStatus, Integer> scoreCount) {
    return scoreCount.get(BallStatus.BALL) == 0
        && scoreCount.get(BallStatus.STRIKE) == 0; // 스트라이크와 볼의 개수가 0 이면 nothing
  }

  public static void printResult(Map<BallStatus, Integer> scoreCount) {
    if (scoreCount.get(BallStatus.STRIKE) == MAX_STRIKE_COUNT) {
      System.out.printf(GAME_RESULT_MESSAGE, MAX_STRIKE_COUNT);
    }
    System.out.println();
  }

  public static void printGameEnd() {
    System.out.println(END_GAME_MESSAGE);
  }
}
