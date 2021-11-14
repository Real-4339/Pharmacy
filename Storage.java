package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;

public class Storage {

    private SqlDB sql;
    private ArrayList<ArrayList<? extends Product>> products = new ArrayList<>();



    public ArrayList<ArrayList<? extends Product>> getProducts() {
        return products;
    }

    public void newProducts() throws SQLException {
        /*ArrayList<Product> baseList = (ArrayList)new ArrayList<Antibiotics>();
        baseList = (ArrayList)new ArrayList<Antiviral>();
        baseList = (ArrayList)new ArrayList<PainKillers>();*/

        this.sql = new SqlDB(true);
        sql.Product_out(products);
        }

    public void MinimizeAmount(Product product, int amount, int i){
        product.setNumber(product.getNumber() - amount);
        if(product.getNumber() == 0){
            products.get(i).remove(product);
        }
    }
}
