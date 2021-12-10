package fiit.Lekaren;

import fiit.Lekaren.Colours.Colours;

import java.util.ArrayList;
import java.util.Scanner;

class Pharmacist {

    public void Hello(User user){
        System.out.printf("Welcome" + Program.colours.getANSI_RED() + " %s" + Program.colours.getAnsiReset() + ", your balance is" + Program.colours.getANSI_BLUE() + " %.2f$" + Program.colours.getAnsiReset() +
                ". How can i help you?\n", user.getName(), user.getBalance());
    }

    public int PrintProducts(Storage pro){
        int a = 0;
        System.out.println("\nOur products:\n___________________________________");
        String[] arr = {"Antibiotics", "Antiviral", "PainKillers", "Steroids", "Vitamins"};
        for (int i = 0; i < pro.getProducts().size(); i++) {
            System.out.println("\nIn class " + Program.colours.getANSI_CYAN() + arr[i] + Program.colours.getAnsiReset() + ", we have products: ");
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
                System.out.printf("Product "+ Program.colours.getANSI_GREEN() +"id:%d"+ Program.colours.getAnsiReset() +"\n -"+ Program.colours.getANSI_YELLOW() + "%s"+ Program.colours.getAnsiReset()+", for "+ Program.colours.getANSI_BLUE() + "%.2f$" + Program.colours.getAnsiReset() +"\nIn amount: %d\n", a, pro.getProducts().get(i).get(y).getName(),
                        pro.getProducts().get(i).get(y).getPrice(), pro.getProducts().get(i).get(y).getNumber());
                a++;
            }
        }
        return a;
    }

    public int CountProducts(Storage pro){
        int a = 0;
        for (int i = 0; i < pro.getProducts().size(); i++) {
            for(int y = 0; y < pro.getProducts().get(i).size(); y++){
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
        } finally {
            System.out.println("Moving on..");
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
        // a - amount of all products
        // I count gonna be as min value. If in first group only 2 products, and we have id = 20, then its, not first group, checking another groups.
        if(id >= 0 && id < a){
            for(int i = 1; i <= pro.getProducts().size(); i++) {
                if (count > id) { // if min > id, then we are in the right group look for.
                    count -= id; // our counting starts at 0 to max element, where a is 0 + max;
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
                if (count <= id) { // if still id bigger, going to the next group.
                    count = pro.getProducts().get(i).size() + count;
                }
            }
        }
        System.out.println("We dont have such product");
        return 0;
    }

    public void Sertain(User user, Storage pro){
        System.out.println("\nOf course, what do you want?");
        Scanner input = new Scanner(System.in);
        String str;
        int amount = 0;
        int first = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        str = input.nextLine();
        str.replaceAll("[\r\n]", "");
        for (int i = 0; i < pro.getProducts().size(); i++){
            for (int y = 0; y < pro.getProducts().get(i).size(); y++){
                if (str.substring(1, 5).equals(pro.getProducts().get(i).get(y).getName().substring(1, 5))){
                    num.add(y);
                    first = i;
                }
            }
        }
        if (num.size() > 1) {
            System.out.println("Yes, we have that product, but also we have different variations of it.");
            for (int a = 0; a < num.size(); a++) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\n| name: " + pro.getProducts().get(first).get(num.get(a)).getName()
                        + "\n| manufacturer: " + pro.getProducts().get(first).get(num.get(a)).getManufacturer()
                        + "\n| country: " + pro.getProducts().get(first).get(num.get(a)).getCountry_manufacturer()
                        + "\n| for: " + pro.getProducts().get(first).get(num.get(a)).getPrice() + "$"
                        + "\n| format: " + pro.getProducts().get(first).get(num.get(a)).getFormat()
                        + "\n| in dose: " + pro.getProducts().get(first).get(num.get(a)).getCount()
                        + "\n| in count: X" + pro.getProducts().get(first).get(num.get(a)).getNumber()
                        + "\n| " + pro.getProducts().get(first).get(num.get(a)).getDescribe()
                        + "\n---------------------------------------------------------------"
                );
            }
            System.out.println("\nWhich one do you want ? _(Enter price)_");
            double Price = 0;
            boolean aWhat = true;
                while (aWhat) {
                    str = input.nextLine();
                    str.replaceAll("[\r\n]", "");
                    try {
                        Price = Double.valueOf(str);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Put only numbers...");
                        continue;
                    }
                    for (int a = 0; a < num.size(); a++) {
                        if (Price == pro.getProducts().get(first).get(num.get(a)).getPrice()){
                            System.out.println("\nNow enter format: ");
                            str = input.nextLine();
                            str.replaceAll("[\r\n]", "");
                            if (str.equals(pro.getProducts().get(first).get(num.get(a)).getFormat())) {
                                int tmp = num.get(a);
                                num.clear();
                                num.add(tmp);
                            }
                        }
                    }
                    if (num.size() != 1) {
                        System.out.println("You entered wrong price or format(Starts with capital!).");
                        continue;
                    }
                    aWhat = false;
                }
            System.out.println("How much of it do you want ?");
            str = input.nextLine();
            try {
                amount = Integer.valueOf(str);
            }
            catch (NumberFormatException e){
                System.out.println("Put only numbers...");
            }
            if(pro.getProducts().get(first).get(num.get(0)).getPrice()*amount < user.getBalance())
            {
                Notification(user, pro.getProducts().get(first).get(num.get(0)), amount, pro, first);
            }
            else{
                System.out.println("You dont have money for that.");
            }
            return;
        }
        if (num.size() == 1) {
            System.out.println("-----------------------------------------------------------------"
                    + "\n| Yes, we have that product," + pro.getProducts().get(first).get(num.get(0)).getName()
                    + "\n| manufacturer: " + pro.getProducts().get(first).get(num.get(0)).getManufacturer()
                    + "\n| country: " + pro.getProducts().get(first).get(num.get(0)).getCountry_manufacturer()
                    + "\n| for: " + pro.getProducts().get(first).get(num.get(0)).getPrice() + "$"
                    + "\n| format: " + pro.getProducts().get(first).get(num.get(0)).getFormat()
                    + "\n| in dose: " + pro.getProducts().get(first).get(num.get(0)).getCount()
                    + "\n| in count: X" + pro.getProducts().get(first).get(num.get(0)).getNumber()
                    + "\n| " + pro.getProducts().get(first).get(num.get(0)).getDescribe()
                    + "\n---------------------------------------------------------------"
                    +"\nHow much of it do you want ?");
            str = input.nextLine();
            try {
                amount = Integer.valueOf(str);
            }
            catch (NumberFormatException e){
                System.out.println("Put only numbers...");
            }
            if(pro.getProducts().get(first).get(num.get(0)).getPrice()*amount < user.getBalance())
            {
                Notification(user, pro.getProducts().get(first).get(num.get(0)), amount, pro, first);
            }
            else{
                System.out.println("You dont have money for that.");
            }
        }
        else {
            System.out.println("\nWe dont have such product, or it could run out.");
        }
    }

    public void Notification(User user, Product product, int amount, Storage polka, int i){
        double price = product.GetDiscount(user) * amount;
        if(product.getPrice() * amount != price) {
            System.out.printf("You got discount on your purchases, new price: "+ Program.colours.getANSI_BLUE() + "%.2f$\n" + Program.colours.getAnsiReset(), product.getPrice() - product.GetDiscount(user));
            price = (product.getPrice() - product.GetDiscount(user)) * amount;
        }
        user.MinimizeBalance(price);
        polka.MinimizeAmount(product,amount, i);
        System.out.printf(Program.colours.getANSI_RED() + "%s" + Program.colours.getAnsiReset() + " bought %d " + Program.colours.getANSI_YELLOW() + "%s"+ Program.colours.getAnsiReset() +
                        " for " + Program.colours.getANSI_BLUE() + "%.2f$" + Program.colours.getAnsiReset() + ". The order was sent to the warehouse. \n", user.getName(), amount,
                product.getName(), price);
    }

}
