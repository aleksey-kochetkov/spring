package e;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
  private static ConfigurableApplicationContext context;

  @BeforeClass
  public static void setUpClass() {
    context = new ClassPathXmlApplicationContext("/beans.xml");
  }

  @Test
  public void whenStd() {
    assertEquals(context.getBean("std", LockOpener.class).openLock(),
                 context.getBean("std", LockOpener.class).openLock());
  }

  @Test
  public void whenAbs() {
    assertNotEquals(context.getBean("abs", LockOpener.class).openLock(),
                    context.getBean("abs", LockOpener.class).openLock());
  }

  @AfterClass
  public static void tearDownClass() {
    context.close();
  }
}
