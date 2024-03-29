package fiit.Lekaren;

import org.jetbrains.annotations.NotNull;

abstract public class Product {
     private String name;
     private String manufacturer;
     private String country_manufacturer;
     private double price;
     private String format;
     private String count;
     private String describe;
     private int number;

     public String getName(){return name;}
     public String getManufacturer(){return manufacturer;}
     public String getCountry_manufacturer(){return country_manufacturer;}
     public double getPrice(){return price;}
     public String getFormat(){return format;}
     public String getCount(){return count;}
     public String getDescribe(){return describe;}
     public int getNumber() {return number;}

     public void setName(String Name){ name = Name;}
     public void setManufacturer(String Manufacturer){ manufacturer = Manufacturer;}
     public void setCountry_manufacturer(String Country_manufacturer){ country_manufacturer = Country_manufacturer;}
     public void setPrice(double Price){ price = Price;}
     public void setFormat(String Format){ format = Format;}
     public void setCount(String Count){ count = Count;}
     public void setDescribe(String Describe){ describe = Describe;}
     public void setNumber(int Number) {this.number = Number;}

     protected double GetDiscount(@NotNull User user){
          if (user.getSpent() < 80)
          {
               return this.getPrice();
          }

          if (user.getSpent() < 150)
          {
               return this.getPrice() * 0.14;
          }

          return this.getPrice() * 0.3;
     }
}
