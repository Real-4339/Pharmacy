package fiit.Lekaren;

 public class User {
    private String name;
    private String adress;
    private double balance;
    private double spent;

    public String getName(){return name;}
    public String getAdress(){return adress;}
    public double getBalance(){return balance;}
    public double getSpent(){return spent;}

    private void setName(String Name){ name = Name;}
    private void setAdress(String Adress){ adress = Adress;}
    private void setBalance(double Balance){ balance = Balance;}
    private void setSpent(double Spent){ spent = Spent;}


    public User (String name, String adress, int balance)
    {
       this.setName(name);
       this.setAdress(adress);
       this.setBalance(balance);
    }

    public User (String name, String adress, double balance, double spent)
    {
       this.setName(name);
       this.setAdress(adress);
       this.setBalance(balance);
       this.setSpent(spent);
    }

    public User (String name, String adress, int balance, int spent)
    {
       this.setName(name);
       this.setAdress(adress);
       this.setBalance(balance);
       this.setSpent(spent);
    }

    public void MinimizeBalance (double price)
    {
       balance -= price;
       spent += price;
    }

    @Override
    public String toString() {
       return "User{" +
               "name='" + name + '\'' +
               ", adress='" + adress + '\'' +
               ", balance=" + balance +
               ", spent=" + spent +
               '}';
    }
 }
