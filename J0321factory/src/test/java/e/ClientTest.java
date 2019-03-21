package e;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {
  @Test
  public void whenSimple() {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      assertEquals("01", context.getBean("item", Item.class).getCode());
      assertEquals("02", context.getBean("item", Item.class).getCode());
      assertEquals("03",
                     context.getBean("singleton", Item.class).getCode());
      assertEquals("03",
                     context.getBean("singleton", Item.class).getCode());
    }
  }
}
