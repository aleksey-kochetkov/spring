package e;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support
                                         .ClassPathXmlApplicationContext;

public class Client {
  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
    }
  }
}
