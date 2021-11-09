package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Program {

    public static void main (String[] args) throws SQLException {

        SqlDB sql = new SqlDB();
        ArrayList<User> people = new ArrayList<User>();
        sql.User_out(people);
        Pharmacist Dana = new Pharmacist();

        for (int i = 0; i < people.size(); i++) {
            Dana.Hello(people.get(i));
        }

        Storage agg = new Storage();
        agg.newProducts();
        Dana.PrintProducts(agg);

    }
}




