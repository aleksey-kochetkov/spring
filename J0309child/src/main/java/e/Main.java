package e;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.PrintStream;
import e.domain.Person;

/**
 * XML-конфигурация, использование SpEL, ApplicationContext nesting 
 */
public class Main {

  public static void main(String[] args) {
    new Main().run(System.out);
  }

  public void run(PrintStream out) {
    try (ConfigurableApplicationContext context =
                        new GenericXmlApplicationContext("/beans.xml");
         GenericXmlApplicationContext child =
                                    new GenericXmlApplicationContext()) {
      child.load("/child.xml");
      child.setParent(context);
      child.refresh();
      Person person = child.getBean("person", Person.class);
      out.format("%s%n", person);
      person = child.getBean("spel", Person.class);
      out.format("%s%n", person);
    }
  }
}
