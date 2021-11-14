package fiit.Lekaren.database;

import fiit.Lekaren.Product;
import fiit.Lekaren.Products.*;
import fiit.Lekaren.User;

import java.lang.instrument.Instrumentation;
import java.sql.*;
import java.io.File;
import java.util.ArrayList;

public class SqlDB {
    Connection connection;
    Statement statement;

    public SqlDB(boolean a){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:I:\\zoop\\src\\fiit\\Lekaren\\database\\SQL.db");
            statement = connection.createStatement();
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Error, could not connect to DataBase :( ");
        }
    }

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

    public void User_out(ArrayList<User> guys) throws SQLException {
        String SQLREQUEST = "Select * from Users";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
            guys.add(new User(res.getString("name"), res.getString("adress"), res.getDouble("balance"), res.getDouble("spent")));
        }
    }

    public void Product_out(ArrayList<ArrayList<? extends Product>> products) throws SQLException {

        String[] arr_1 = {"Antibiotics", "Antiviral", "PainKillers", "Steroids", "Vitamins"};

        ArrayList<Antibiotics> antibiotics = new ArrayList<Antibiotics>();
        ArrayList<Antiviral> antivirals = new ArrayList<Antiviral>();
        ArrayList<PainKillers> painKillers = new ArrayList<PainKillers>();
        ArrayList<Steroids> steroids = new ArrayList<Steroids>();
        ArrayList<Vitamins> vitamins = new ArrayList<Vitamins>();

        for(int i = 0; i < arr_1.length; i++) {
            String sql_requests = "SELECT * FROM " + arr_1[i];
            ResultSet res = statement.executeQuery(sql_requests);
            while (res.next()) {
                if(i == 0) {
                    antibiotics.add(new Antibiotics(res.getString("name"), res.getString("manufacturer"), res.getString("country_manufacturer"),
                            res.getDouble("price"), res.getString("format"),
                            res.getString("count"), res.getString("class"), res.getString("describe"), (int) ((Math.random() * (10 - 1)) + 1)));
                }
                if(i == 1){
                    antivirals.add(new Antiviral(res.getString("name"), res.getString("manufacturer"), res.getString("country_manufacturer"),
                            res.getDouble("price"), res.getString("format"),
                            res.getString("count"),  res.getString("form"), res.getString("describe"), (int) ((Math.random() * (10 - 1)) + 1)));
                }
                if(i == 2){
                    painKillers.add(new PainKillers(res.getString("name"), res.getString("manufacturer"), res.getString("country_manufacturer"),
                            res.getDouble("price"), res.getString("format"),
                            res.getString("count"),  res.getString("drug"), res.getString("describe"), (int) ((Math.random() * (10 - 1)) + 1)));
                }
                if(i == 3){
                    steroids.add(new Steroids(res.getString("name"), res.getString("manufacturer"), res.getString("country_manufacturer"),
                            res.getDouble("price"), res.getString("format"),
                            res.getString("count"),  res.getString("type"), res.getString("describe"), (int) ((Math.random() * (10 - 1)) + 1)));
                }
                if(i == 4){
                    vitamins.add(new Vitamins(res.getString("name"), res.getString("manufacturer"), res.getString("country_manufacturer"),
                            res.getDouble("price"), res.getString("format"),
                            res.getString("count"),  res.getString("groop"), res.getString("describe"), (int) ((Math.random() * (10 - 1)) + 1)));
                }
            }
        }
        products.add(antibiotics);
        products.add(antivirals);
        products.add(painKillers);
        products.add(steroids);
        products.add(vitamins);
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
