package baseball.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.Constant.BallStatus;
import baseball.Service.ScoreService;
import baseball.domain.BallNumber;
import baseball.domain.BaseBallNumbers;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreServiceTest {

  private BaseBallNumbers playerNumbers;
  private BaseBallNumbers computerNumbers = new BaseBallNumbers( // 컴퓨터가 생성한 정답 Numbers
      Arrays.asList(
          new BallNumber(4),
          new BallNumber(2),
          new BallNumber(5)
      )
  );
  ScoreService score = new ScoreService(computerNumbers);

  @Test
  @DisplayName("스트라이크_카운팅_체크")
  public void 스트라이크_카운팅_체크() {
    playerNumbers = new BaseBallNumbers( // 컴퓨터가 생성한 정답 Numbers
        Arrays.asList(
            new BallNumber(1),
            new BallNumber(2),
            new BallNumber(3)
        )
    );
    HashMap<BallStatus, Integer> scoreCount = score.countScore(playerNumbers);
    for (BallStatus key : scoreCount.keySet()) {
      System.out.println(key.getStatus() + scoreCount.get(key).toString());
    }
    assertEquals(scoreCount.get(BallStatus.STRIKE), 1);
  }

  @Test
  @DisplayName("볼_카운팅_체크")
  public void 볼_카운팅_체크() {
    playerNumbers = new BaseBallNumbers( // 컴퓨터가 생성한 정답 Numbers
        Arrays.asList(
            new BallNumber(4),
            new BallNumber(5),
            new BallNumber(6)
        )
    );
    HashMap<BallStatus, Integer> scoreCount = score.countScore(playerNumbers);
    for (BallStatus key : scoreCount.keySet()) {
      System.out.println(key.getStatus() + scoreCount.get(key).toString());
    }
    assertEquals(scoreCount.get(BallStatus.BALL), 1);
  }

  @Test
  @DisplayName("낫싱_카운팅_체크")
  public void 낫싱_카운팅_체크() {
    playerNumbers = new BaseBallNumbers( // 컴퓨터가 생성한 정답 Numbers
        Arrays.asList(
            new BallNumber(7),
            new BallNumber(8),
            new BallNumber(9)
        )
    );
    HashMap<BallStatus, Integer> scoreCount = score.countScore(playerNumbers);
    for (BallStatus key : scoreCount.keySet()) {
      System.out.println(key.getStatus() + scoreCount.get(key).toString());
    }
    assertEquals(scoreCount.get(BallStatus.NOTHING), 3);
  }
}