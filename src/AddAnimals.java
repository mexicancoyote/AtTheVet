import java.util.Scanner;


public class AddAnimals {

    public static void  addAnimals (){

        boolean loop2=true;

        while (loop2) {
            Function.clearConsole();
            System.out.println("Wybierz rase: 1. Pies 2. Kot 3.Inne Zwierzatko Wyjscie 0.");
            Scanner in = new Scanner(System.in);
            String character = in.next();
            if (Function.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    System.out.println("Wybrałes psa");
                    AddAnimalToList.addAnimalToListDogs();
                } else if (number == 2) {
                    System.out.println("Wybrałes kota");
                    AddAnimalToList.addAnimalToListCats();
                } else if (number == 3) {
                    System.out.println("Wybrałes inna");
                    AddAnimalToList.addAnimalToListOther();

                } else if (number == 0){
                    break;
                }

                else {
                    continue;
                }

            }

        }
        while (loop2) {
            Function.clearConsole();
            System.out.println("Witaj w Klinice.\nWybierz jedną z interesujacych Cię opcji:\n1.Lista zwierząt.\n2.Dodaj pacjenta.\n3.Wyjście.");
            Scanner in = new Scanner(System.in);
            String character = in.next();
            if (Function.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    System.out.println("Jeden");
                    break;
                }
                else if (number == 2) {
                    System.out.println("Dwa");
                    AddAnimals.addAnimals();
                    break;
                }
                else if (number == 3) {
                    System.out.println("Trzy");
                    loop2=false;
                }
                else {
                    continue;
                }

            }
        }
    }

}