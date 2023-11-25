package baseball.utils;

import baseball.domain.BallNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateRandomNumber {

  public static final int RANDOM_LIST_SIZE = 3;
  public static final int RANDOM_RANGE_START = 1;
  public static final int RANDOM_RANGE_END = 9;

  public static List<BallNumber> createRandomNumbers() {
    List<BallNumber> computer = new ArrayList<>();
    while (checkRandomListSize(computer)) {
      BallNumber randomNumber = new BallNumber(
          Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END));

      if (isDuplicatedNumber(computer, randomNumber)) {
        computer.add(randomNumber);
      }

    }
    return computer;
  }

  private static boolean isDuplicatedNumber(List<BallNumber> computer, BallNumber randomNumber) {
    return computer.stream().noneMatch(x -> x.getBallNumber() == randomNumber.getBallNumber());
  }

  private static boolean checkRandomListSize(List<BallNumber> computer) {
    return computer.size() < RANDOM_LIST_SIZE;
  }
}
