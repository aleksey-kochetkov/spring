package e;

public class Dependent {
  private Name name;

  public Name getName() {
    return this.name;
  }

  public void setName(Name name) {
    System.out.format("NameEditor:%s%n", name);
    this.name = name;
  }
}
