package fiit.Lekaren;

import fiit.Lekaren.Colours.Colours;
import fiit.Lekaren.database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    static Colours colours = Colours.getInstance();

    public static void main (String[] args) throws SQLException {

        SqlDB sql = new SqlDB();
        Pharmacist Dana = new Pharmacist();


        Storage polka = new Storage();
        polka.newProducts();

        ArrayList<User> people = new ArrayList<User>();
        sql.User_out(people);
        Scanner input = new Scanner(System.in);
        String str;
        int is = 0;

      while(true) {
          for (int i = 0; i < people.size(); i++) {
              Dana.Hello(people.get(i));
              boolean next = false;
                  while(!next){
                      System.out.println("\n1)I want to buy a certain product\t2)Can you show me all your products\t  3)Could you advise me?\t" +
                              "\n4)I need to look in my wallet, to get know how much money do i have.\t 5)You know, i would go..Bye )" +
                              " \t 6) How much did i already spent? \nJust put the number...");
                      str = input.nextLine();
                      switch (str){
                          case "1":
                              Dana.Sertain(people.get(i), polka);
                              break;
                          case "2":
                              int idCount = Dana.PrintProducts(polka);
                              if (is == 2) is = 0;
                              while(is == 0) {
                                  is = Dana.Scan(people.get(i), polka, idCount);
                                  if(people.get(i).getSpent() == 0) System.out.println("You have to buy something...Try again :)");
                              }
                              while(is == 1) {
                                  System.out.println("\nDo you want to buy more?");
                                  str = input.nextLine();
                                  if (str.equals("Yes") || str.equals("yes")) {
                                      is = Dana.Scan(people.get(i), polka, idCount);
                                      continue;
                                  }
                                  if (str.equals("No") || str.equals("no")) {
                                      is = 0;
                                  }
                                  else {
                                      System.out.println("Please, give only {yes, no} answers :)");
                                  }
                              }
                              break;
                          case "3":
                              System.out.println("\nTemporally in development.");
                              break;
                          case "4":
                              System.out.printf("My balance is: "+ colours.getANSI_BLUE() + "%.2f$" + colours.getAnsiReset() +"\n", people.get(i).getBalance());
                              break;
                          case "5":
                              if(people.get(i).getSpent() > 0){

                                  System.out.println("Have a good day :)");
                                  next = true;
                                  break;
                              }
                              System.out.println("I dont think so, just buy something and I'll make sure THEY let you out.");
                              break;
                          case "6":
                              System.out.printf("Ive spent: "+ colours.getANSI_BLUE() + "%.2f$" + colours.getAnsiReset() +"\n", people.get(i).getSpent());
                              break;
                          default:
                              System.out.println("\nPut only available 'numbers'. Try again.");
                      }
                  }
          }
      }
    }
}




