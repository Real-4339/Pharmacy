package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Steroids extends Product {

    private String type;

    public String getType(){return type;}
    private void setType(String Type){ type = Type;}


    public Steroids (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String type, String describe, int number) {
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setCountry_manufacturer(country_manufacturer);
        this.setPrice(price);
        this.setFormat(format);
        this.setCount(count);
        this.setType(type);
        this.setDescribe(describe);
        this.setNumber(number);
    }
}
