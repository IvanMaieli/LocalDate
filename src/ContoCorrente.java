public class ContoCorrente {
    private double money;

    public ContoCorrente(){
        this.money = 0;
    }

    public ContoCorrente(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double addedMoney) {
        this.money += addedMoney;
    }

    public void takeMoney(double subMoney) {
        this.money -= subMoney;
    }
}
