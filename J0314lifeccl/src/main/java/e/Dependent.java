package e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Dependent implements ApplicationContextAware {
  private ApplicationContext context;
  private Dependency dependency;

  public Dependent() {
    System.out.println("I: Construction");
  }

  @Override
  public void setApplicationContext(ApplicationContext context) {
    System.out.println("II.2: ApplicationContextAware");
    this.context = context;
  }

  public void setDependency(Dependency dependencey) {
    System.out.println("II.1: Setter dependency injection");
    this.dependency = dependency;
  }
}
