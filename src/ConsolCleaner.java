import java.util.Scanner;

public class ConsolCleaner {
    
    private String nextLine;

    public void askForPause() {
        System.out.println("\nPress Any Key To Continue...");
        nextLine = new Scanner(System.in).nextLine();  
        
    }

    public void cleanConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
}