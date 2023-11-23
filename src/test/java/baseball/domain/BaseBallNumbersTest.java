package baseball.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumbersTest {

  @Test
  @DisplayName("BaseBallNumbers의 초기화 테스트")
  void BaseBallNumbers_초기화_테스트() {
    List<BallNumber> ballNumbers = Arrays.asList(
        new BallNumber(1),
        new BallNumber(2),
        new BallNumber(3)
    );
    BaseBallNumbers baseBallNumbers = new BaseBallNumbers(ballNumbers);

    Assertions.assertEquals(ballNumbers, baseBallNumbers.getNumbers());
  }

  @Test
  @DisplayName("중복값_입력_테스트")
  void 중복값_입력_테스트() {
    List<BallNumber> ballNumbers = Arrays.asList(
        new BallNumber(1),
        new BallNumber(1),
        new BallNumber(2)
    );
    Assertions.assertThrows(IllegalArgumentException.class, () -> new BaseBallNumbers(ballNumbers));
  }

  @Test
  @DisplayName("BaseBallNumbers의_자리수_테스트")
  void BaseBallNumbers_인자가_1개() {
    List<BallNumber> ballNumbers = Arrays.asList(
        new BallNumber(1)
    );
    Assertions.assertThrows(IllegalArgumentException.class, () -> new BaseBallNumbers(ballNumbers));
  }

  @Test
  @DisplayName("BaseBallNumbers의_자리수_테스트")
  void BaseBallNumbers_인자가_4개() {
    List<BallNumber> ballNumbers = Arrays.asList(
        new BallNumber(1),
        new BallNumber(2),
        new BallNumber(3),
        new BallNumber(4)
    );
    Assertions.assertThrows(IllegalArgumentException.class, () -> new BaseBallNumbers(ballNumbers));
  }

}