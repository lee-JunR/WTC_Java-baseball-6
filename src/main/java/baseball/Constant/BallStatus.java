package baseball.Constant;

public enum BallStatus {
  BALL("볼"),
  STRIKE("스트라이크"),
  NOTHING("낫싱");

  private final String status;

  BallStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
