package e;

import org.junit.Test;
import java.util.Locale;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {
  private static final Locale POLISH = new Locale("pl");

  @Test
  public void whenSimple() {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      assertEquals("Curvecious bottom of Ann", context.getMessage(
                         "one", new String[] {"of Ann"}, Locale.ENGLISH);
      assertEquals("Duży tyłek Anji", context.getMessage(
                                   "one", new String[] {"Anji"}, POLISH);
      assertEquals("This is a cat of Ann", context.getMessage(
                         "two", new String[] {"of Ann"}, Locale.ENGLISH);
      assertEquals("To jest kot Anji", context.getMessage(
                                   "two", new String[] {"Anji"}, POLISH);
    }
  }
}
