import java.time.LocalDate;

public class ContoCorrenteController {

    private final double dailyLimit = 300;
    private final double monthlyLimit = 4000;
    private ContoCorrente cc;
    private LocalDate ld = LocalDate.now();

    public ContoCorrenteController(ContoCorrente cc) {
        this.cc = cc;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public LocalDate getLd() {
        return ld;
    }

    public boolean checkDaily(double money) {
        if(money <= dailyLimit) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMonthly(double money) {
        if(money <= monthlyLimit) {
            return true;
        } else {
            return false;
        }
    }
}
