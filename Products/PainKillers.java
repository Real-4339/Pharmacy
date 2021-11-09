package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class PainKillers extends Product {

     private String drug;

     public String getDrug() {return drug;}
     public void setDrug(String Drug){ drug = Drug;}


     public PainKillers (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String drug, String describe) {

          this.setName(name);
          this.setManufacturer(manufacturer);
          this.setCountry_manufacturer(country_manufacturer);
          this.setPrice(price);
          this.setFormat(format);
          this.setCount(count);
          this.setDrug(drug);
          this.setDescribe(describe);
     }
}
