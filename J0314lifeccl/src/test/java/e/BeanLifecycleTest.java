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
    String[] expected = {"I: Construction",
                         "II.1: Setter dependency injection",
                         "II.2: ApplicationContextAware"};
    int i = 0;
    try (Scanner in =
               new Scanner(new ByteArrayInputStream(ba.toByteArray()))) {
      while (in.hasNextLine()) {
        if (expected[i].equals(in.nextLine())) {
          i++;
        }
      }
    }
    assertEquals(3, i);
  }
}
