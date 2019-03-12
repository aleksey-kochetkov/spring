package e.domain;

public class Item implements Comparable<Item> {
  private String code;
  private String descript;

  public Item(String code, String descript) {
    this.code = code;
    this.descript = descript;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescript() {
    return this.descript;
  }

  public void setDescript(String descript) {
    this.descript = descript;
  }

  @Override
  public int compareTo(Item other) {
    int result;
    if (this.code == null && other.code == null) {
      result = 0;
    } else {
      result = this.code == null ? -1 : this.code.compareTo(other.code);
    }
    return result;
  }
}
