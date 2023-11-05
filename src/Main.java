import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente contoCorrente = new ContoCorrente(50);
        ContoCorrenteController contoCorrenteController = new ContoCorrenteController(contoCorrente);

        int i  = 0;
        while (true) {
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
                    double takeMoney = scanner.nextDouble();
                    if(contoCorrenteController.checkDaily(takeMoney) == true) {
                        contoCorrente.takeMoney(takeMoney);
                    } else {
                        System.out.println("Impossibile prelevare, limite di " + contoCorrenteController.getDailyLimit()+ "€ superato\n\n");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;

            }
        }

    }
}