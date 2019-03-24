package e;

import java.beans.PropertyEditorSupport;

public class NameEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) {
    String[] subs = text.split("\\s");
    this.setValue(new Name(subs[0], subs[1]));
  }
}
