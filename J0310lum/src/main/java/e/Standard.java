package e;

public class Standard implements LockOpener {
  private KeyHelper helper;

  public KeyHelper getHelper() {
    return this.helper;
  }

  public void setHelper(KeyHelper helper) {
    this.helper = helper;
  }

  @Override
  public String openLock() {
    return this.getHelper().toString();
  }
}
