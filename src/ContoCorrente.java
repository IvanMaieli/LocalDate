public class ContoCorrente {
    
    //Denaro nel conto
    private double money;


    //Costruttore 1, mette a 0 il denaro
    public ContoCorrente(){
        this.money = 0;
    }

    //Costruttore 2, inizializza ad un parametro il denaro
    public ContoCorrente(double money) {
        this.money = money;
    }

    //Getter del denaro
    public double getMoney() {
        return money;
    }

    //Versamento del denaro
    public void addMoney(double addedMoney) {
        this.money += addedMoney;
    }

    //Prelievo del denaro
    public void takeMoney(double subMoney) {
        this.money -= subMoney;
    }
}
