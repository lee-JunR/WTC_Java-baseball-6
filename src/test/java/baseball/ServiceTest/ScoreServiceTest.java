package baseball.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import baseball.Constant.BallStatus;
import baseball.Service.ScoreService;
import baseball.domain.BallNumber;
import baseball.domain.BaseBallNumbers;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreServiceTest {

  private BaseBallNumbers playerNumbers;
  private BaseBallNumbers computerNumbers = new BaseBallNumbers( // 컴퓨터가 생성한 정답 Numbers
      Arrays.asList(
          new BallNumber(1),
          new BallNumber(2),
          new BallNumber(3)
      )
  );
  ScoreService score = new ScoreService(computerNumbers);

//  // TODO : 이렇게 테스트 코드 안에서 DTO 를 만드는 것이 옳은지는 모르겠음 찾아볼것. https://blogshine.tistory.com/486
//  private List<Integer> ToIntegerList(BaseBallNumbers baseBallNumbers) {
//    List<Integer> integerList = baseBallNumbers.getNumbers().stream()
//        .map(BallNumber::getBallNumber)
//        .collect(Collectors.toList());
//    return integerList;
//  }

//  @Test
//  @DisplayName("비교_확인")
//  public void 비교_확인() {
//    List<BallNumber> expectedNumbers = Arrays.asList(
//        new BallNumber(1),
//        new BallNumber(2),
//        new BallNumber(3)
//    );
//
//    playerNumbers = new BaseBallNumbers(expectedNumbers);
//    assertIterableEquals(ToIntegerList(playerNumbers), ToIntegerList(computerNumbers));
//  }

  /**
   * BallNumbers 2개가 주어졌을 때 스트라이크인지 체크 - [ ]  같은 수가 같은 자리에 있으면 스트라이크 - [ ]  다른 자리에 있으면 볼 - [ ]  같은
   * 수가 전혀 없으면 낫싱 123 / 145 -> 1 스트라이크; 123 / 1,0 -> ㅅ트라이크; 123 / 1,1 -> 볼 123 / 4,2 -> 낫싱
   */
  @Test
  @DisplayName("스트라이크_확인")
  public void 스트라이크_확인() {
    // 123 / 1,0 -> 스트라이크
    int location = 0;
    assertEquals(BallStatus.STRIKE, score.checkStrike(new BallNumber(1), location));
  }

  @Test
  @DisplayName("볼_확인")
  public void 볼_확인() {
    // 123 / 1,1 -> 볼
    int location = 1;
    assertEquals(BallStatus.BALL, score.checkBall(new BallNumber(1), location));
  }

}