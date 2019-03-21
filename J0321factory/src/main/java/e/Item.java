package e;

public class Item {
  private String code;

  public Item(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    return String.format("Item{code:%s}", this.code);
  }
}
