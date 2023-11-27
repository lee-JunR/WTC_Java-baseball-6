package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumbers {

  private static final int DIGITS = 3;
  private static final String OUT_OF_DIGITS_ERROR_MESSAGE = "세자리 수를 입력해주세요";
  private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자는 허용되지 않습니다.";

  private final List<BallNumber> baseBallNumbers;

  public BaseBallNumbers(List<BallNumber> numbers) {
    validateUnique(numbers);
    validateDigits(numbers);
    this.baseBallNumbers = numbers;
  }

  public List<BallNumber> getNumbers() {
    return this.baseBallNumbers;
  }

  // TODO : 이렇게 써도 좋을지 의문?
  // 어차피 벨리데이션 체크 완료했으니까 게터에서는 괜찮을듯?
  public int getNumbers(int index) {
    return this.baseBallNumbers.get(index).getBallNumber();
  }

  private void validateUnique(List<BallNumber> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>();
    for (BallNumber ballNumber : numbers) {
      if (!uniqueNumbers.add(ballNumber.getBallNumber())) {
        throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
      }
    }
  }

  private void validateDigits(List<BallNumber> numbers) {
    if (isaBoolean(numbers)) {
      throw new IllegalArgumentException(OUT_OF_DIGITS_ERROR_MESSAGE);
    }
  }

  private boolean isaBoolean(List<BallNumber> numbers) {
    return numbers.size() != DIGITS;
  }

}
