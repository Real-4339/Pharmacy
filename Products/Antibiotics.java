package fiit.Lekaren.Products;

import fiit.Lekaren.IBonus;
import fiit.Lekaren.Product;
import org.jetbrains.annotations.NotNull;

public class Antibiotics extends Product implements IBonus {

    private String clas;

    public String getClas(){return clas;}
    private void setClas(String Clas){ clas = Clas;}

    public void Free(){
        System.out.println("\nYou bought Antibiotics product/s, so you get free" + Gematogen);
    }

    public Antibiotics (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String clas, String describe, int number) {
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setCountry_manufacturer(country_manufacturer);
        this.setPrice(price);
        this.setFormat(format);
        this.setCount(count);
        this.setClas(clas);
        this.setDescribe(describe);
        this.setNumber(number);
    }
}
