package baseball.View;

import baseball.Constant.BallStatus;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

  @Test
  @DisplayName("볼_스코어_테스트")
  void 볼_스코어_테스트() {
    HashMap<BallStatus, Integer> scoreCount = new HashMap<BallStatus, Integer>();
    scoreCount.put(BallStatus.BALL, 3);
    scoreCount.put(BallStatus.STRIKE, 0);

    OutputView.printBallsStatus(scoreCount);
  }
}
