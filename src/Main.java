import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente contoCorrente = new ContoCorrente(4000);
        ContoCorrenteController contoCorrenteController = new ContoCorrenteController(contoCorrente, 5000, 600);

        int i = 0, j = 0;
        int scelta;
        double dailyTakenMoney = 0;
        double monthlyTakenMoney = 0;

        do {
            int month = contoCorrenteController.getLd().plusDays(j).getMonthValue();
            if(month != contoCorrenteController.getLd().plusDays(i).getMonthValue()) {
                monthlyTakenMoney = 0;
            }
            j = i;

            System.out.println(contoCorrenteController.getLd().plusDays(i));
            System.out.println("Denaro nel conto: " + contoCorrente.getMoney());
            System.out.println("Denaro gia' prelevato oggi(max " +
                    contoCorrenteController.getDailyLimit() + "€)" + ": " + dailyTakenMoney);
            System.out.println("Denaro gia' prelevato questo mese(max " +
                    contoCorrenteController.getMonthlyLimit() + "€)" + ": " + monthlyTakenMoney);
            System.out.println("\n1. Preleva denaro");
            System.out.println("2. Versa denaro");
            System.out.println("3. Termina giornata");
            System.out.println("4. Esci");
            System.out.print("Inserisci la tua scelta: ");

            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il denaro da prelevare: ");
                    double moneyToTake = scanner.nextDouble();
                    if(contoCorrenteController.checkEnoughMoney(moneyToTake) &&
                            contoCorrenteController.checkLimits(monthlyTakenMoney + moneyToTake,dailyTakenMoney + moneyToTake)) {
                        contoCorrente.takeMoney(moneyToTake);
                        dailyTakenMoney += moneyToTake;
                        monthlyTakenMoney += moneyToTake;
                    } else if(!contoCorrenteController.checkEnoughMoney(moneyToTake)) {
                        System.out.println("Impossibile prelevare, errore nell'inserimento della somma");
                    } else {
                        System.out.println("Impossibile prelevare, limiti superati");
                    }
                    break;

                case 2:
                    System.out.print("Inserisci il denaro da versare: ");
                    double money = scanner.nextDouble();
                    if(contoCorrenteController.checkPositive(money)) {
                        contoCorrente.addMoney(money);
                    } else {
                        System.out.println("Impossibile versare questa somma");
                    }
                    break;

                case 3:
                    dailyTakenMoney = 0;
                    i++;
                    break;

                default:
                    break;

            }

            System.out.println();

        } while(scelta != 4);

    }
}