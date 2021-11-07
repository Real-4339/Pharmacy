package fiit.Lekaren;

class Pharmacist extends Storage {

    public void Hello(User user){
        System.out.printf("Welcome %s, your balance is %.2f.How can i help you?\n", user.getName(), user.getBalance());
    }

    /*public void PrintProducts(){
        for (int i = 0; i < products.length; i++) {
            System.out.printf("Product %d %s for %ld", i, products.getName(), products.getPrice());
        }
    }*/

    public void Notification(User user, Product product){
      double price = product.GetDiscount(user);
      user.MinimizeBalance(price);
      System.out.printf("%s bought %s for %ld.The order was sent to the warehouse ", user.getName(),
              product.getName(), price);
    }
}
