package e;

import org.springframework.beans.factory.FactoryBean;

public class ItemFactoryBean implements FactoryBean<Item> {
  private static int current;
  private final boolean isSingleton;

  public ItemFactoryBean(boolean isSingleton) {
    this.isSingleton = isSingleton;
  }

  @Override
  public Item getObject() {
    return new Item(String.format("0%d", ++current));
  }

  @Override
  public Class<Item> getObjectType() {
    return Item.class;
  }

  @Override
  public boolean isSingleton() {
    return isSingleton;
  }
}
