import java.io.FileNotFoundException;
import java.util.Scanner;
import Animal_Data_Base.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Animals databaseFunctions = new Animals();;
        boolean loop1 = true;

        while (loop1) {
            Function.clearConsole();
            System.out.println("Witaj w Klinice.\nWybierz jedną z interesujacych Cię opcji:\n1.Lista zwierząt.\n2.Dodaj pacjenta.\n3.Wyjście.");
            Scanner in = new Scanner(System.in);
            String character = in.next();
            if (Function.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    databaseFunctions.animalsFromList();

                    break;
                }
                else if (number == 2) {
                    databaseFunctions.animalsToList();


                }
                else if (number == 3) {
                    System.out.println("Trzy");
                    loop1=false;
                }
                else {
                    continue;
                }

            }
        }
    }
}
