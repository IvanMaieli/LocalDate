import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente contoCorrente = new ContoCorrente(50);
        ContoCorrenteController contoCorrenteController = new ContoCorrenteController(contoCorrente);

        int i  = 0;
        double dailyTakenMoney;
        double monthlyTakenMoney = 0;
        while (true) {
            dailyTakenMoney = 0;
            monthlyTakenMoney += dailyTakenMoney;

            System.out.println(contoCorrenteController.getLd().plusDays(i));
            System.out.println("Denaro nel conto: " + contoCorrente.getMoney());
            System.out.println("1. Preleva denaro");
            System.out.println("2. Versa denaro");
            System.out.println("3. Termina giornata");
            System.out.print("Inserisci la tua scelta: ");

            int scelta = scanner.nextInt();
            switch(scelta){
                case 1:
                    System.out.print("Inserisci il denaro da prelevare: ");
                    double money = scanner.nextDouble();
                    if(contoCorrenteController.checkEnoughMoney(money) == true && contoCorrenteController.checkDaily(dailyTakenMoney) == true) {
                            contoCorrente.takeMoney(money);
                    } else if(contoCorrenteController.checkEnoughMoney(money) == false) {
                        System.out.println("Non è presente abbastanza denaro nel conto");
                    } else {
                        System.out.println("Impossibile prelevare, limite di " + contoCorrenteController.getDailyLimit()+ "€ superato\n\n");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    i++;
                    break;
                default:
                    break;

            }

        }

    }
}