package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Antibiotics extends Product {

    private String clas;

    public String getClas(){return clas;}
    private void setClas(String Clas){ clas = Clas;}


    public Antibiotics (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String clas, String describe) {
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setCountry_manufacturer(country_manufacturer);
        this.setPrice(price);
        this.setFormat(format);
        this.setCount(count);
        this.setClas(clas);
        this.setDescribe(describe);
    }

}
