package e;

public abstract class Abstract implements LockOpener {

  public abstract KeyHelper getHelper();

  @Override
  public String openLock() {
    return this.getHelper().toString();
  }
}
