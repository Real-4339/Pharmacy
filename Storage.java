package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Storage {

    private ArrayList<ArrayList<? extends Product>> products = new ArrayList<>();

    public ArrayList<ArrayList<? extends Product>> getProducts() {
        return products;
    }

    public void newProducts() throws SQLException {
        /*ArrayList<Product> baseList = (ArrayList)new ArrayList<Antibiotics>();
        baseList = (ArrayList)new ArrayList<Antiviral>();
        baseList = (ArrayList)new ArrayList<PainKillers>();*/

        SqlDB sql = new SqlDB(true);
        sql.Product_out(products);
        }

    }
