package e;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Properties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
  private static final ConfigurableApplicationContext context =
                        new ClassPathXmlApplicationContext("/beans.xml");

  @Test
  public void whenMapSimple() {
    assertEquals(3, context.getBean("items", Map.class).size());
  }

  @Test
  public void whenListSimple() {
    assertEquals(3, context.getBean("list", List.class).size());
  }

  @Test
  public void whenSetSimple() {
    assertEquals(3, context.getBean("set", Set.class).size());
  }

  @Test
  public void whenPropsSimple() {
    assertEquals(3, context.getBean("props", Properties.class).size());
  }

  @AfterClass
  public static void tearDownClass() {
    context.close();
  }
}
