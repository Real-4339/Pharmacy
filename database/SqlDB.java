package fiit.Lekaren.database;

import fiit.Lekaren.User;

import java.sql.*;
import java.io.File;
import java.util.ArrayList;

public class SqlDB {
    Connection connection;
    Statement statement;

    public SqlDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("\nConnecting to database ...");
            connection = DriverManager.getConnection("jdbc:sqlite:I:\\zoop\\src\\fiit\\Lekaren\\database\\SQL.db");
            statement = connection.createStatement();
            System.out.println("DataBase was connected ->\n _       __          __                                \n" +
                    "| |     / /  ___    / /  _____  ____    ____ ___   ___ \n" +
                    "| | /| / /  / _ \\  / /  / ___/ / __ \\  / __ `__ \\ / _ \\\n" +
                    "| |/ |/ /  /  __/ / /  / /__  / /_/ / / / / / / //  __/\n" +
                    "|__/|__/   \\___/ /_/   \\___/  \\____/ /_/ /_/ /_/ \\___/ \n" +
                    "                                                       \n");
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Error, could not connect to DataBase :( ");
        }
    }

    public void Output(ArrayList<User> guys) throws SQLException {
        String SQLREQUEST = "Select * from Users";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
            guys.add(new User(res.getString("name"), res.getString("adress"), res.getDouble("balance"), res.getDouble("spent")));
        }
    }

    /*public ArrayList<User> Output() throws SQLException {
        ArrayList<User> guys = new ArrayList<User>();
        String SQLREQUEST = "Select first_name from Users";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
            System.out.println(res.getString("first_name"));
            //guys.add();
        }
        return guys;
    }*/

}
