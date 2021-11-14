package fiit.Lekaren.Products;

import fiit.Lekaren.Product;
import fiit.Lekaren.User;
import org.jetbrains.annotations.NotNull;

public class PainKillers extends Product {

     private String drug;

     public String getDrug() {return drug;}
     public void setDrug(String Drug){ drug = Drug;}


     public PainKillers (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String drug, String describe, int number) {

          this.setName(name);
          this.setManufacturer(manufacturer);
          this.setCountry_manufacturer(country_manufacturer);
          this.setPrice(price);
          this.setFormat(format);
          this.setCount(count);
          this.setDrug(drug);
          this.setDescribe(describe);
          this.setNumber(number);
     }
}
