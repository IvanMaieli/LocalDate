import java.util.Scanner;

public class ConsoleCleaner {

    //Input
    private String nextLine;


    //Chiede di premere un tasto
    public void askForPause() {
        System.out.println("\nPress Any Key To Continue...");
        nextLine = new Scanner(System.in).nextLine();  
    }

    //Pulisce la console
    public void cleanConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
}
