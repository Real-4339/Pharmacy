package fiit.Lekaren;

import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) throws SQLException {

        SqlDB sql = new SqlDB();
        Pharmacist Dana = new Pharmacist();

        Storage polka = new Storage();
        polka.newProducts();

        ArrayList<User> people = new ArrayList<User>();
        sql.User_out(people);
        Scanner input = new Scanner(System.in);
        String str;

      while(true) {
          for (int i = 0; i < people.size(); i++) {
              Dana.Hello(people.get(i));
              System.out.println("\n1)I want to buy a certain product\t2)Can you show me all your products\t  3)Could you advise me?\nJust put the number...");
              str = input.nextLine();
              switch (str){
                  case "1":

                  break;
                  case "2":
                      int idCount = Dana.PrintProducts(polka);
                      boolean is = Dana.Scan(people.get(i), polka, idCount);
                      while(is) {
                          System.out.println("Do you want to buy more?");
                          str = input.nextLine();
                          if (str == "Yes" || str == "No" || str == "yes" || str == "no") {
                              is = Dana.Scan(people.get(i), polka, idCount);
                          } else {
                              System.out.println("Please, give only yes, no answers :)\n");
                          }
                      }
                      if(!is){
                          System.out.println("You have to buy something...");
                          if(people.get(i).getSpent() > 0) break;
                      }
                  break;
                  case "3":

                  break;
              }
          }
      }
    }
}




