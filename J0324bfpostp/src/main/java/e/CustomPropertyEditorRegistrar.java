package e;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomPropertyEditorRegistrar
                                     implements PropertyEditorRegistrar {
  public void registerCustomEditors(PropertyEditorRegistry registry) {
    registry.registerCustomEditor(Name.class, new NameEditor());
  }
}
