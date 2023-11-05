import java.time.LocalDate;

public class ContoCorrenteController {

    //Limite mensile
    private double monthlyLimit;
    //Limite giornaliero
    private double dailyLimit;
    //Conto corrente da gestire
    private ContoCorrente cc;
    //Local date per gestire i limiti
    private LocalDate ld = LocalDate.now();

    //Costruttore, si passano il conto corrente da gestire e i limiti
    public ContoCorrenteController(ContoCorrente cc, double monthlyLimit, double dailyLimit) {
        this.cc = cc;
        this.monthlyLimit = monthlyLimit;
        this.dailyLimit = dailyLimit;
    }

    //Getter del limite mensile
    public double getMonthlyLimit() {
        return this.monthlyLimit;
    }

    //Getter del limite giornaliero
    public double getDailyLimit() {
        return this.dailyLimit;
    }

    //Getter del LocalDate
    public LocalDate getLd() {
        return this.ld;
    }

    //Metodo che si occupa di confrontare i giorni al fine di capire se cambia il mese
    public boolean checkChangingMonth(int lastDay, int currentDay) {
        int lastMonth = this.getLd().plusDays(lastDay).getMonthValue();
        int currentMonth = this.getLd().plusDays(currentDay).getMonthValue();
        return lastMonth != currentMonth;
    }

    //Controlla se il parametro passato non è negativo
    public boolean checkPositive(double money) {
       return money >= 0;
    }

    //Controlla se è minore del denaro già presente nel conto
    public boolean checkEnoughMoney(double money) {
        return this.checkPositive(money) && money <= this.cc.getMoney();
    }

    //Controlla se rispetta il limite mensile
    private boolean checkMonthly(double money) {
        return money <= this.getMonthlyLimit();
    }

    //Controlla se rispetta il limite giornaliero
    private boolean checkDaily(double money) {
        return money <= this.getDailyLimit();
    }

    //Controlla, attraverso i metodi privati, se rispetta tutti i limiti
    public boolean checkLimits(double monthlyMoney, double dailyMoney) {
        return this.checkMonthly(monthlyMoney) && this.checkDaily(dailyMoney);
    }


}
