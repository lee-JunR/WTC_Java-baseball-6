package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallNumberTest {

  @Test
  @DisplayName("베이스볼 넘버의 숫자 범위 테스트")
  void 베이스볼_넘버_숫자_범위_테스트() {
    assertThrows(IllegalArgumentException.class, () -> new BallNumber(0));
  }

}
