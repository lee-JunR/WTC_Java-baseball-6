package baseball.Controller;

import baseball.Constant.BallStatus;
import baseball.Service.ScoreService;
import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.domain.BaseBallNumbers;
import baseball.utils.CreateRandomNumber;
import java.util.HashMap;

public class BaseBallGameController {

  public static final int MAX_STRIKE_COUNT = 3;
  public static final String END_GAME_MESSAGE = "게임 종료";
  private BaseBallNumbers playerNumbers;
  private BaseBallNumbers computerNumbers;
  private ScoreService score;

  public void init() {
    OutputView.printGameStart();
  }

  public void playRound() {
    computerNumbers = new BaseBallNumbers(CreateRandomNumber.createRandomNumbers());
    HashMap<BallStatus, Integer> scoreCount;
    do {
      playerNumbers = new BaseBallNumbers(InputView.inputTryNumbers());
      score = new ScoreService(computerNumbers);
      scoreCount = score.countScore(playerNumbers);
      OutputView.printBallsStatus(scoreCount);
    } while (checkRound(scoreCount));
  }

  private static boolean checkRound(HashMap<BallStatus, Integer> scoreCount) {
    return scoreCount.getOrDefault(BallStatus.STRIKE, 0) != MAX_STRIKE_COUNT;
  }

  public boolean askRestart() {
    int restartNumber = InputView.inputRetryNumber();
    if (restartNumber == 1){
      return true;
    }
    System.out.println(END_GAME_MESSAGE);
    return false;
  }
}
