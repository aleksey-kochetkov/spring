package e.domain;

public class Person {
  private String name;
  private int age;
  private float height;
  private boolean programmer;
  private Long id;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getHeight() {
    return this.height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public boolean isProgrammer() {
    return this.programmer;
  }

  public void setProgrammer(boolean programmer) {
    this.programmer = programmer;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format(
                  "Person{name:%s,age:%d,height:%f,programmer:%b,id:%d}",
             this.name, this.age, this.height, this.programmer, this.id);
  }
}
