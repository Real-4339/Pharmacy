package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Vitamins extends Product {

   private String group;
   private String benefits;

   public String getGroup(){return group;}
   public String getBenefits(){return benefits;}

   private void setGroup(String Group){ group = Group;}
   private void setBenefits(String Benefits){ benefits = Benefits;}

   public Vitamins(String name, String manufacturer, String country_manufacturer, double price, String format, String count, String group, String benefits) {
      super(); // я не понимаю, зачем он тут нужен
      this.setName(name);
      this.setManufacturer(manufacturer);
      this.setCountry_manufacturer(country_manufacturer);
      this.setPrice(price);
      this.setFormat(format);
      this.setCount(count);
      this.setGroup(group);
      this.setBenefits(benefits);
   }

   public Vitamins(String name, String manufacturer, String country_manufacturer, double price, String format, String count, String benefits) {
      super(); // я не понимаю, зачем он тут нужен
      this.setName(name);
      this.setManufacturer(manufacturer);
      this.setCountry_manufacturer(country_manufacturer);
      this.setPrice(price);
      this.setFormat(format);
      this.setCount(count);
      this.setBenefits(benefits);
   }

}
