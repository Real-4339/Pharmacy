package fiit.Lekaren;

import java.util.Scanner;

class Pharmacist extends Storage {

    public void Hello(User user){
        System.out.printf("Welcome %s, your balance is %.2f. How can i help you?\n", user.getName(), user.getBalance());
    }

    public int PrintProducts(Storage pro){
        int a = 0;
        System.out.println("\nOur products:\n___________________________________");
        String[] arr = {"Antibiotics", "Antiviral", "PainKillers", "Steroids", "Vitamins"};
        for (int i = 0; i < pro.getProducts().size(); i++) {
            System.out.println("\nIn class " + arr[i] + ", we have products: ");
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
                System.out.printf("Product id:%d \n -%s, for %.2f\n", a, pro.getProducts().get(i).get(y).getName(), pro.getProducts().get(i).get(y).getPrice());
                a++;
            }
        }
        return a;
    }

    public void Scan(User user, Storage pro, int a){
        System.out.println("\nChoose one of the product and write the following ID: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int id;
        try {
            id = Integer.valueOf(str);
        }
        catch (NumberFormatException e){
            System.out.println("Put only numbers\n");
            return;
        }
        int count = pro.getProducts().get(0).size();
        if(id >= 0 && id < a){
            for(int i = 1; i <= pro.getProducts().size(); i++) {
                if (count >= id) {
                    count -= id;
                    count = pro.getProducts().get(i-1).size() - count;
                    if(pro.getProducts().get(i-1).get(count).getPrice() < user.getBalance())
                    {
                        Notification(user, pro.getProducts().get(i-1).get(count));
                    }
                    else{
                        System.out.println("You dont have money for that");
                    }
                    break;
                }
                if (count < id) {
                    count = pro.getProducts().get(i).size() + count;
                }
            }
        }
        else{
            System.out.println("We dont have such product");
        }

    }

    public void Notification(User user, Product product){
      double price = product.GetDiscount(user);
      user.MinimizeBalance(price);
      System.out.printf("%s bought %s for %.2f. The order was sent to the warehouse. \n", user.getName(),
              product.getName(), price);
        System.out.println(user.getBalance());
        /*System.out.println("Do you want to buy more?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if(str == "Yes" || str == "No" || str == "yes" || str == "no")
        {
            Scan(user, );
        }
        else {
            System.out.println("No such answer\n");
        }*/
    }
}
