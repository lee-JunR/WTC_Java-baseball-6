package baseball.utils;

import static baseball.utils.CreateRandomNumber.createRandomNumbers;

import baseball.domain.BaseBallNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateRandomNumbersTest {
  @Test
  @DisplayName("랜덤넘버_생성")
  public void 랜덤넘버_생성(){
    BaseBallNumbers randomNumbers = new BaseBallNumbers(createRandomNumbers());
    randomNumbers.getNumbers().stream().map(x -> x.getBallNumber()).forEach(System.out::println);
  }
}
