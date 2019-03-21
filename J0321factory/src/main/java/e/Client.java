package e;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      System.out.format("isSingleton():%s%n",
                                           context.getBean("singleton"));
      System.out.format("isSingleton():%s%n",
                                           context.getBean("singleton"));
      System.out.format("not:%s%n", context.getBean("item"));
      System.out.format("not:%s%n", context.getBean("item"));
    }
  }
}
