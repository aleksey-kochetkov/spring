package e;

import java.util.Locale;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support
                                         .ClassPathXmlApplicationContext;

public class Client {
  private static final Locale POLISH = new Locale("pl");

  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      System.out.println(context.getMessage(
                         "one", new String[] {"of Ann"}, Locale.ENGLISH));
      System.out.println(context.getMessage(
                         "one", new String[] {"Anji"}, POLISH));
      System.out.println(context.getMessage(
                         "two", new String[] {"of Ann"}, Locale.ENGLISH));
      System.out.println(context.getMessage(
                         "two", new String[] {"Anji"}, POLISH));
    }
  }
}
