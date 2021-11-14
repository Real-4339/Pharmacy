package fiit.Lekaren.Products;

import fiit.Lekaren.Product;
import fiit.Lekaren.User;
import org.jetbrains.annotations.NotNull;

public class Vitamins extends Product {

   private String group;

   public String getGroup(){return group;}
   private void setGroup(String Group){ group = Group;}


   public Vitamins(String name, String manufacturer, String country_manufacturer, double price, String format, String count, String group, String describe, int number) {

      this.setName(name);
      this.setManufacturer(manufacturer);
      this.setCountry_manufacturer(country_manufacturer);
      this.setPrice(price);
      this.setFormat(format);
      this.setCount(count);
      if(group != "") this.setGroup(group);
      this.setDescribe(describe);
      this.setNumber(number);
   }

   @Override public double GetDiscount(@NotNull User user) {
      return this.getPrice() * 0.05;
   }
}
