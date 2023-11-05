import java.time.LocalDate;

public class ContoCorrenteController {
    private ContoCorrente cc;
    private LocalDate ld = LocalDate.now();

    public ContoCorrenteController(ContoCorrente cc) {
        this.cc = cc;
    }

    public boolean checkDaily(double money, double limit) {
        return true;
    }
}
