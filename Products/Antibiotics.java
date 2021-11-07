package fiit.Lekaren.Products;

import fiit.Lekaren.Product;

public class Antibiotics extends Product {

    private String clas;

    public String getClas(){return clas;}
    private void setClas(String Clas){ clas = Clas;}

    public Antibiotics (String name, String manufacturer, String country_manufacturer, double price, String clas) {
        super(); // я не понимаю, зачем он тут нужен
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setCountry_manufacturer(country_manufacturer);
        this.setPrice(price);
        this.setClas(clas);
    }

}
