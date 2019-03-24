package e;

public class Name {
  private String first;
  private String last;

  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public String toString() {
    return String.format("Name{first:%s,last:%s}",
                                                  this.first, this.last);
  }
}
