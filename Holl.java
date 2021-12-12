package fiit.Lekaren;

public class Holl implements IBonus{
    User David;
    Pharmacist Oleg;

    public Holl (Storage sklad, User pokupatel){
        this.David = pokupatel;
        this.Oleg = new Pharmacist();
        sklad.Ping();
    }

    public Holl (){

    }

    @Override
    public void Free() {
        System.out.println("\nToday we give away " + Gematogen +  " for free" + "\nBecause our boss has a birthday today, he is " + absurd);
    }

    final void getBreak(){
        System.out.println("Will be in 10 minutes..");
    }
}
