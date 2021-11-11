package fiit.Lekaren;

import java.util.Scanner;
import java.util.SortedMap;

class Pharmacist extends Storage {

    public void Hello(User user){
        System.out.printf("Welcome %s, your balance is %.2f$. How can i help you?\n", user.getName(), user.getBalance());
    }

    public int PrintProducts(Storage pro){
        int a = 0;
        System.out.println("\nOur products:\n___________________________________");
        String[] arr = {"Antibiotics", "Antiviral", "PainKillers", "Steroids", "Vitamins"};
        for (int i = 0; i < pro.getProducts().size(); i++) {
            System.out.println("\nIn class " + arr[i] + ", we have products: ");
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
                System.out.printf("Product id:%d \n -%s, for %.2f$\n", a, pro.getProducts().get(i).get(y).getName(), pro.getProducts().get(i).get(y).getPrice());
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
                    System.out.println("Have a good day :)");
                    return 1;
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
        int count = pro.getProducts().get(0).size();
        if(id >= 0 && id < a){
            for(int i = 1; i <= pro.getProducts().size(); i++) {
                if (count > id) {
                    count -= id;
                    count = pro.getProducts().get(i-1).size() - count;
                    if(pro.getProducts().get(i-1).get(count).getPrice() < user.getBalance())
                    {
                        Notification(user, pro.getProducts().get(i-1).get(count));
                        return 1;
                    }
                    else{
                        System.out.println("You dont have money for that");
                        return 0;
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

    public void Notification(User user, Product product){
      double price = product.GetDiscount(user);
      user.MinimizeBalance(price);
      if(product.getPrice() != price) System.out.printf("You got discount on your purchases, old price: %.2f$\n", product.getPrice());
      System.out.printf("%s bought %s for %.2f$. The order was sent to the warehouse. \n", user.getName(),
              product.getName(), price);
    }
}
