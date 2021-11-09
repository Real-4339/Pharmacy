package fiit.Lekaren;

class Pharmacist extends Storage {

    public void Hello(User user){
        System.out.printf("Welcome %s, your balance is %.2f.How can i help you?\n", user.getName(), user.getBalance());
    }

    public void PrintProducts(Storage pro){
        int a = 0;
        System.out.println("\nOur products:\n");
        for (int i = 0; i < pro.getProducts().size(); i++) {
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
                System.out.printf("Product id:%d \n -%s, for %.2f\n", a, pro.getProducts().get(i).get(y).getName(), pro.getProducts().get(i).get(y).getPrice());
                a++;
            }
        }
    }

    public void Notification(User user, Product product){
      double price = product.GetDiscount(user);
      user.MinimizeBalance(price);
      System.out.printf("%s bought %s for %ld.The order was sent to the warehouse ", user.getName(),
              product.getName(), price);
    }
}
