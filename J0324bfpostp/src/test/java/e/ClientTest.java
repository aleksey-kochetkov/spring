package e;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support
                                         .ClassPathXmlApplicationContext;

public class ClientTest {
  @Test
  public void whenSimple() {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      Name name =
                 context.getBean("dependent", Dependent.class).getName();
      assertEquals("Name{first:Johnny,last:Walker}", name.toString());
    }
  }
}
