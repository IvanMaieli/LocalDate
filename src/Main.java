import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Oggetto Conto Corrente
        ContoCorrente contoCorrente = new ContoCorrente(4000);

        //Controllore delle azioni che coinvolgono il Conto Corrente
        ContoCorrenteController contoCorrenteController = new ContoCorrenteController(contoCorrente, 5000, 600);
        
        //ConsoleCleaner per gestire la visualizzazione nella console
        ConsolCleaner cleaner = new ConsolCleaner();

        //Iteratore che gestisce l'incremento dei giorni, sfruttando la classe LocalDate
        int i = 0;
        //Altro iteratore, utile per gestire il cambio dei mesi
        int j = 0;
        //Scelta per lo switch
        int scelta;
        //Contatore dei soldi prelevati in un giorno
        double dailyTakenMoney = 0;
        //Contatore dei soldi prelevati in un mese
        double monthlyTakenMoney = 0;

        do {
            //Se il mese cambia
            if(contoCorrenteController.checkChangingMonth(j, i)) {
                monthlyTakenMoney = 0;
            }
            j = i;

            //Menu
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
                    //Prendo in input la somma da prelevare
                    double moneyToTake = scanner.nextDouble();
                    //Se la somma è idonea a certi controlli
                    if(contoCorrenteController.checkEnoughMoney(moneyToTake) &&
                            contoCorrenteController.checkLimits(monthlyTakenMoney + moneyToTake, dailyTakenMoney + moneyToTake)) {
                        contoCorrente.takeMoney(moneyToTake);
                        //La somma viene aggiunta alla sommatoria giornaliera
                        dailyTakenMoney += moneyToTake;
                        //E a quella mensile
                        monthlyTakenMoney += moneyToTake;
                    } else if(!contoCorrenteController.checkEnoughMoney(moneyToTake)) {
                        System.out.println("Impossibile prelevare, errore nell'inserimento della somma");
                    } else {
                        System.out.println("Impossibile prelevare, limiti superati");
                    }
                    break;

                case 2:
                    System.out.print("Inserisci il denaro da versare: ");
                    //Inserimento denaro da versare
                    double money = scanner.nextDouble();
                    //Controllo se la somma è positiva
                    if(contoCorrenteController.checkPositive(money)) {
                        //Aggiungo i soldi al conto
                        contoCorrente.addMoney(money);
                    } else {
                        System.out.println("Impossibile versare questa somma");
                    }
                    break;

                case 3:
                    //Se cambio il giorno azzero il prelievo giornaliero
                    dailyTakenMoney = 0;
                    //Incremento il giorno
                    i++;
                    break;

                default:
                    break;

            }

            cleaner.askForPause();
            cleaner.cleanConsole();
            
        } while(scelta != 4);

    }
}