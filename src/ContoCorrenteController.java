import java.time.LocalDate;

public class ContoCorrenteController {

    private double dailyLimit;
    private double monthlyLimit;
    private ContoCorrente cc;
    private LocalDate ld = LocalDate.now();

    public ContoCorrenteController(ContoCorrente cc, double dailyLimit, double monthlyLimit) {
        this.cc = cc;
        this.dailyLimit = dailyLimit;
        this.monthlyLimit = monthlyLimit;
    }

    public double getDailyLimit() {
        return this.dailyLimit;
    }

    public double getMonthlyLimit() {
        return this.monthlyLimit;
    }

    public LocalDate getLd() {
        return this.ld;
    }

    public boolean checkPositive(double money) {
       return money >= 0;
    }

    public boolean checkEnoughMoney(double money) {
        return checkPositive(money) && money <= this.cc.getMoney();
    }

    public boolean checkDaily(double money) {
        return money <= this.getDailyLimit();
    }

    public boolean checkMonthly(double money) {
        return money <= this.monthlyLimit;
    }
}
