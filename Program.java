package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Program {

    public static void main (String[] args) throws SQLException {

        SqlDB sql = new SqlDB();
        Pharmacist Dana = new Pharmacist();

        Storage polka = new Storage();
        polka.newProducts();

        ArrayList<User> people = new ArrayList<User>();
        sql.User_out(people);


        for (int i = 0; i < people.size(); i++) {
            Dana.Hello(people.get(i));
        }


        int idCount = Dana.PrintProducts(polka);
        Dana.Scan(people.get(0), polka, idCount);

    }
}




