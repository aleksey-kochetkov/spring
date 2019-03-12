package e;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Properties;
import e.domain.Item;

@Component
public class App {

  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
      System.out.println(context.getBean("items"));
      System.out.println(context.getBean("list"));
      System.out.println(context.getBean("set"));
      System.out.println(context.getBean("props"));
    }
  }

  @Resource(name = "items")
  private Map<String, Object> items;

  @Resource(name = "list")
  private List<Object> list;

  @Resource(name = "set")
  private Set<Object> set;

  @Resource(name = "props")
  private Properties props;
}
