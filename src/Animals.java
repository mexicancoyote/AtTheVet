import Animal_Data_Base.Cats;
import Animal_Data_Base.Dogs;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Animals {
    List<Variables> database = new LinkedList<>();
    String owner;
    String category;
    String breed;
    String name;
    Scanner input = new Scanner(System.in);

    public void animals() {
        System.out.println("Podaj nazwisko właściciela");
        owner = input.next();
        System.out.println("Podaj gatunek pacjenta");
        category = input.next();
        System.out.println("Podaj rase");
        breed = input.next();
        System.out.println("Podaj imie zwierzaka");
        name = input.next();

        boolean loop2 = true;
        while (loop2) {

            System.out.println("podaj wiek zwierzaka");
            String age = input.next();
            if (Function.isInteger(age)) {
                int number = Integer.parseInt(age);
                if (number < 0) {
                    System.out.println("dopiero go planujecie czy co ?");
                }
                if (number == 0) {
                    System.out.println("młodziutka bestia");
                    break;
                }
                if (number > 0) {
                    break;

                } else {
                    continue;
                }
            }
        }
        boolean loop3 = true;

        while (loop3) {
            Function.clearConsole();
            System.out.println("Wybierz rase: 1. Pies 2. Kot 3.Inne Zwierzatko Wyjscie 0.");
            Scanner in = new Scanner(System.in);
            String character = in.next();


            if (Function.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    System.out.println("Pomyślnie zapisałeś 'psa' w naszej bazie\n");
                    database.add(new Dogs(owner, category, breed, name, number));
                    break;
                } else if (number == 2) {
                    System.out.println("Pomyślnie zapisałeś 'kota' w naszej bazie\n");
                    database.add(new Cats(owner, category, breed, name, number));
                    break;
                } else if (number == 3) {
                    System.out.println("Pomyślnie zapisałeś 'inne zwierzatko' w naszej bazie\n");
                    database.add(new Others(owner, category, breed, name, number));
                    break;
                } else if (number == 0) {
                    break;
                } else {
                    continue;
                }

            }

        }

    }

}