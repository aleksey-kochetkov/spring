package e;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
  @Test
  public void whenSimple() throws IOException {
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    try (PrintStream out = new PrintStream(ba)) {
      PrintStream tmp = System.out;
      System.setOut(out);
      try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      }
      System.setOut(tmp);
    }
    ba.close();
    String[] expected = {"II: Construction",
                        "III: Setter dependency injection",
                        "IV: BeanNameAware",
                        "V: BeanClassLoaderAware",
                        "VI: ApplicationContextAware",
                        "VII: @PostConstruct",
                        "VIII: InitializingBean#afterPropertiesSet()",
                        "IX: <bean init-method=\"init\"/>",
                        "X: @PreDestroy",
                        "XI: DisposableBean#destroy()",
                        "XII: <bean destroy-method=\"destroyMethod\"/>"};
    int i = 0;
    try (Scanner in =
               new Scanner(new ByteArrayInputStream(ba.toByteArray()))) {
      while (in.hasNextLine()) {
        String s = in.nextLine();
        if (i < expected.length && expected[i].equals(s)) {
          i++;
        }
      }
    }
    assertEquals(expected.length, i);
  }
}
