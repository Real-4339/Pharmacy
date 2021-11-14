package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Antiviral extends Product {

    private String form;

    public String getForm(){return form;}
    private void setForm(String Form){ form = Form;}


    public Antiviral (String name, String manufacturer, String country_manufacturer, double price, String format, String count, String form, String describe, int number) {

        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setCountry_manufacturer(country_manufacturer);
        this.setPrice(price);
        this.setFormat(format);
        this.setCount(count);
        this.setForm(form);
        this.setDescribe(describe);
        this.setNumber(number);
    }
}
