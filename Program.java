package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Program {

    public static void main (String[] args) throws SQLException {

        SqlDB sql = new SqlDB();
        ArrayList<User> people = new ArrayList<User>();
        sql.Output(people);
        Pharmacist Oleg = new Pharmacist();

        for (int i = 0; i < people.size(); i++) {
            Oleg.Hello(people.get(i));
        }

    }
}




