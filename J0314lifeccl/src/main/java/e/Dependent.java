package e;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Dependent implements BeanNameAware, BeanClassLoaderAware,
              ApplicationContextAware, InitializingBean, DisposableBean {
  private String name;
  private ClassLoader classLoader;
  private ApplicationContext context;
  private Dependency dependency;

  public Dependent() {
    System.out.println("II: Construction");
  }

  public void setDependency(Dependency dependencey) {
    System.out.println("III: Setter dependency injection");
    this.dependency = dependency;
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("IV: BeanNameAware");
    this.name = name;
  }

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    System.out.println("V: BeanClassLoaderAware");
    this.classLoader = classLoader;
  }

  @Override
  public void setApplicationContext(ApplicationContext context) {
    System.out.println("VI: ApplicationContextAware");
    this.context = context;
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("VII: @PostConstruct");
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("VIII: InitializingBean#afterPropertiesSet()");
  }

  public void init() {
    System.out.println("IX: <bean init-method=\"init\"/>");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("X: @PreDestroy");
  }

  private boolean flag;

  @Override
  public void destroy() {
    if (this.flag) {
      System.out.println("XII: <bean destroy-method=\"destroy\"/>");
    } else {
      System.out.println("XI: DisposableBean#destroy()");
      this.flag = true;
    }
  }

  public void destroyMethod() {
    System.out.println("XII: <bean destroy-method=\"destroyMethod\"/>");
  }
}
