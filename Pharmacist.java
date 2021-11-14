package fiit.Lekaren;

import fiit.Lekaren.Products.Colours;

import java.util.Scanner;
import java.util.SortedMap;

class Pharmacist {

    Colours col;

    public void Hello(User user, Colours colours){
        this.col = colours;
        System.out.printf("Welcome" + col.ANSI_RED + " %s" + col.ANSI_RESET + ", your balance is" + col.ANSI_BLUE + " %.2f$" + col.ANSI_RESET +
                ". How can i help you?\n", user.getName(), user.getBalance());
    }

    public int PrintProducts(Storage pro){
        int a = 0;
        System.out.println("\nOur products:\n___________________________________");
        String[] arr = {"Antibiotics", "Antiviral", "PainKillers", "Steroids", "Vitamins"};
        for (int i = 0; i < pro.getProducts().size(); i++) {
            System.out.println("\nIn class " + col.ANSI_CYAN + arr[i] + col.ANSI_RESET + ", we have products: ");
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
                System.out.printf("Product "+ col.ANSI_GREEN +"id:%d"+ col.ANSI_RESET +"\n -"+col.ANSI_YELLOW + "%s"+ col.ANSI_RESET+", for "+ col.ANSI_BLUE + "%.2f$" + col.ANSI_RESET +"\nIn amount: %d\n", a, pro.getProducts().get(i).get(y).getName(),
                        pro.getProducts().get(i).get(y).getPrice(), pro.getProducts().get(i).get(y).getNumber());
                a++;
            }
        }
        return a;
    }

    public int Scan(User user, Storage pro, int a){
        Scanner input = new Scanner(System.in);
        String str = "";
        while (!str.equals("*")) {
            System.out.println("\n$)I changed my mind, i want to leave\t*)Continue with buying...");
            str = input.nextLine();
            if(str.equals("$")){
                if(user.getSpent() > 0){
                    System.out.println("\nWhat else i can do for you ?");
                    return 2;
                }
                System.out.println("I dont think so, just buy one or more and I'll make sure THEY let you out.");
            }
        }
        System.out.println("Choose one of the product and write the following ID: ");
        str = input.nextLine();
        str.replaceAll("[\r\n]", "");
        int id;
        try {
            id = Integer.valueOf(str);
        }
        catch (NumberFormatException e){
            System.out.println("Put only numbers");
            return 0;
        }
        int amount;
        System.out.println("How many of it do you want?");
        str = input.nextLine();
        try {
            amount = Integer.valueOf(str);
        }
        catch (NumberFormatException e){
            System.out.println("Put only numbers");
            return 0;
        }
        int count = pro.getProducts().get(0).size();
        if(id >= 0 && id < a){
            for(int i = 1; i <= pro.getProducts().size(); i++) {
                if (count > id) {
                    count -= id;
                    count = pro.getProducts().get(i-1).size() - count;
                    if(pro.getProducts().get(i-1).get(count).getNumber() >= amount){
                        if(pro.getProducts().get(i-1).get(count).getPrice()*amount < user.getBalance())
                        {
                            Notification(user, pro.getProducts().get(i-1).get(count), amount, pro, i-1);
                            return 1;
                        }
                        else{
                            System.out.println("You dont have money for that");
                            return 0;
                        }
                    }
                    else {
                        System.out.println("\nWe dont have that amount of that product");
                    }
                }
                if (count <= id) {
                    count = pro.getProducts().get(i).size() + count;
                }
            }
        }
        System.out.println("We dont have such product");
        return 0;
    }

    public void Notification(User user, Product product, int amount, Storage polka, int i){
      double price = product.GetDiscount(user) * amount;
      if(product.getPrice() * amount != price) {
          System.out.printf("You got discount on your purchases, new price: "+col.ANSI_BLUE + "%.2f$\n" + col.ANSI_RESET, product.getPrice() - product.GetDiscount(user));
          price = (product.getPrice() - product.GetDiscount(user)) * amount;
      }
      user.MinimizeBalance(price);
      polka.MinimizeAmount(product,amount, i);
      System.out.printf(col.ANSI_RED + "%s" + col.ANSI_RESET + " bought %d "+col.ANSI_YELLOW + "%s"+ col.ANSI_RESET+" for "+col.ANSI_BLUE + "%.2f$" + col.ANSI_RESET+". The order was sent to the warehouse. \n", user.getName(), amount,
              product.getName(), price);
    }
}
