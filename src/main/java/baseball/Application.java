package baseball;

import baseball.Controller.BaseBallGameController;

public class Application {

  public static void main(String[] args) {
    BaseBallGameController baseBallGameController = new BaseBallGameController();
    baseBallGameController.init();
    do {
      baseBallGameController.playRound();
    }while(baseBallGameController.askRestart());
  }
}
