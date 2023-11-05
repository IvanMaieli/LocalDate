import java.time.LocalDate;

public class ContoCorrenteController {


    private double monthlyLimit;
    private double dailyLimit;
    private ContoCorrente cc;
    private LocalDate ld = LocalDate.now();

    public ContoCorrenteController(ContoCorrente cc, double monthlyLimit, double dailyLimit) {
        this.cc = cc;
        this.monthlyLimit = monthlyLimit;
        this.dailyLimit = dailyLimit;
    }

    public double getMonthlyLimit() {
        return this.monthlyLimit;
    }

    public double getDailyLimit() {
        return this.dailyLimit;
    }

    public LocalDate getLd() {
        return this.ld;
    }

    public boolean checkChangingMonth(int lastDay, int currentDay) {
        int lastMonth = this.getLd().plusDays(lastDay).getMonthValue();
        int currentMonth = this.getLd().plusDays(currentDay).getMonthValue();
        return lastMonth != currentMonth;
    }

    public boolean checkPositive(double money) {
       return money >= 0;
    }

    public boolean checkEnoughMoney(double money) {
        return this.checkPositive(money) && money <= this.cc.getMoney();
    }

    private boolean checkMonthly(double money) {
        return money <= this.getMonthlyLimit();
    }

    private boolean checkDaily(double money) {
        return money <= this.getDailyLimit();
    }

    public boolean checkLimits(double monthlyMoney, double dailyMoney) {
        return this.checkMonthly(monthlyMoney) && this.checkDaily(dailyMoney);
    }


}
