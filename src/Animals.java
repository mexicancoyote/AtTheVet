import Animal_Data_Base.Dogs;
import Animal_Data_Base.Fish;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.LinkedList;

public class Animals {
    List<Variables> animals = new LinkedList<>();

    public void addAnimal() {
        int genre = 0;
        Scanner input = new Scanner(System.in);
        boolean loop1 = true;
        do {
            System.out.println("Dodaj pacjenta:\n1.Psa.\n2.Rybkę.\n3.Inne.\n0.Anuluj.");
            String userInput = input.next();
            if (Functions.isInteger(userInput)) {
                genre = Integer.parseInt(userInput);
                if (genre == 0) {
                    break;
                }
            }
        }
        while (genre != 1 && genre != 2 && genre != 3);

        int ageInt = 0;
        System.out.println("Podaj nazwisko właściciela: ");
        String ownerStr = input.next();
        System.out.println("Podaj rasę: ");
        String breedStr = input.next();
        System.out.println("Podaj imię zwierzaka: ");
        String nameStr = input.next();
        do{
            System.out.println("Podaj wiek zwierzaka: ");
            String ageStr = input.next();
            if (Functions.isInteger(ageStr)) {
                ageInt = Integer.parseInt(ageStr);
            }
        }
        while(!(ageInt>0));


        if (genre==1) {
            int howManyBarks = 0;
            do{System.out.println("Ile razy pies szczeka: ");
                String howManyBarksStr = input.next();
                if (Functions.isInteger(howManyBarksStr)) {
                    howManyBarks = Integer.parseInt(howManyBarksStr);
                }
            }
            while(!(howManyBarks>0));
            Variables animal = new Dogs(ownerStr, breedStr, nameStr, ageInt, howManyBarks);
            animals.add(animal);
            System.out.println("Dodałeś nowego psa do bazy pacjentów.\n");
        }
        else if (genre==2) {
            int howManyScales = 0;
            do{System.out.println("Ile łusek ma rybka: ");
                String howManyScale = input.next();
                if (Functions.isInteger(howManyScale)) {
                    howManyScales = Integer.parseInt(howManyScale);
                }
            }
            while(!(howManyScales>0));
            Variables animal = new Fish(ownerStr, breedStr, nameStr, ageInt, howManyScales);
            animals.add(animal);
            System.out.println("Dodałeś nową rybkę do bazy pacjentów.\n");
        }
        else{
            System.out.println("Podaj gatunek zwierzęcia: ");
            String category = input.next();
            Variables animal = new Others(ownerStr, breedStr, nameStr, ageInt, category);
            animals.add(animal);
            System.out.println("Dodałeś nowego zwierzaka do bazy pacjentów.\n");
        }


    }
    public void getAnimlas(){
        System.out.println("Pacjent 0 to: "+ animals.get(0));
    }

}
/*import Animal_Data_Base.Cats;
import Animal_Data_Base.Dogs;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

    public void animalsToList () throws FileNotFoundException{

        PrintWriter zapis = new PrintWriter("animalsDataBase.txt");
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
        /*zapis.print(owner);
        zapis.print(category);
        zapis.print(breed);
        zapis.print(name);


        zapis.close();
        Scanner odczyt = new Scanner(new File("animalsDataBase.txt"));
        System.out.println(odczyt.nextLine());*/
        /* boolean loop3 = true;

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
    public void animalsFromList (){
        boolean loop3=true;
        while (loop3) {
            Function.clearConsole();
            System.out.println("Wybierz rase którą chcesz odnależć : \n1. Pies \n2. Kot \n3.Inne Zwierzatko \nWyjscie 0.");
            Scanner in = new Scanner(System.in);
            String character = in.next();


            if (Function.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    System.out.println("psy w naszej bazie\n");
                    System.out.println(database.size());

                    break;
                } else if (number == 2) {
                    System.out.println("koty w naszej bazie\n");

                    break;
                } else if (number == 3) {
                    System.out.println("inne zwierzeta w naszej bazie\n");
                    database.get(0);
                    break;
                } else if (number == 0) {
                    break;
                } else {
                    continue;
                }

            }

        }


    }
}*/