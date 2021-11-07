package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class PainKillers extends Product {

     private boolean drug;

     public boolean isDrug() {return drug;}
     public void setDrug(boolean Drug){ drug = Drug;}

     public PainKillers (String name, String manufacturer, String country_manufacturer, double price, boolean drug) {
          super(); // я не понимаю, зачем он тут нужен
          this.setName(name);
          this.setManufacturer(manufacturer);
          this.setCountry_manufacturer(country_manufacturer);
          this.setPrice(price);
          this.setDrug(drug);
     }
}
