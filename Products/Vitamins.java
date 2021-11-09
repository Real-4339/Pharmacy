package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Vitamins extends Product {

   private String group;

   public String getGroup(){return group;}
   private void setGroup(String Group){ group = Group;}


   public Vitamins(String name, String manufacturer, String country_manufacturer, double price, String format, String count, String group, String describe) {

      this.setName(name);
      this.setManufacturer(manufacturer);
      this.setCountry_manufacturer(country_manufacturer);
      this.setPrice(price);
      this.setFormat(format);
      this.setCount(count);
      if(group != "") this.setGroup(group);
      this.setDescribe(describe);
   }

}
