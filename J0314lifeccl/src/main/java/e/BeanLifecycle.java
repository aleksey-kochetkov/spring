package e;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * I.    Scanning configuration
 * II.   Construction
 * III.  Setter dependency injection
 * IV.   BeanNameAware#setBeanName()
 * V.    BeanClassLoaderAware#setBeanClassLoader()
 * IV.   ApplicationContextAware#setApplicationContext()
 * VII.  @PostConstruct
 * VIII. InitializingBean#afterPropertiesSet()
 * IX.   &lt;bean init-method="init"/&gt;
 * X.    @PreDestroy
 * XI.   DisposableBean#destroy()
 * XII.  &lt;bean destroy-method="destroyMethod"/&gt;
 */
@Configuration
public class BeanLifecycle {
  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
                      new ClassPathXmlApplicationContext("/beans.xml")) {
    }
  }

  public BeanLifecycle() {
    System.out.format("cp0:%s%n", this.getClass().getClassLoader().getParent());
  }

  @Bean
  public String test() {
    return "";
  }
}
