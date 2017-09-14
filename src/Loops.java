import Animal_Data_Base.Dogs;
import Animal_Data_Base.Fish;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Loops {
    Scanner in = new Scanner(System.in);
    String character;
    int number;
    Animals newClass = new Animals();

    public void beforeLoop () throws IOException{
        newClass.getAnimalsFromFileToList();
    }
    public void mainLoop ()throws IOException{
        boolean loop = true;
        while(loop) {
            System.out.println("Witaj w Klinice.\nWybierz jedną z interesujacych Cię opcji:\n1.Lista zwierząt.\n2.Dodaj pacjenta.\n3.Wyjście.");
            character = in.next();
            if (Functions.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    loop1();
                }
                else if (number == 2) {
                    newClass.addAnimalToList();
                    newClass.addAnimalToFile();
                    continue;
                }
                else if (number == 3) {
                    System.out.println("Dziękujemy za skorzystanie z programu AtTheVet");
                loop=false;
                }
            }
        }
    }

    public void loop1() throws IOException{
        while (true) {
            System.out.println("1. Wyświetl listę.\n2. Zarządzaj listą.\n3. Wyjscie.");
            character = in.next();
            if (Functions.isInteger(character)) {
                number = Integer.parseInt(character);
                if (number == 1) {
                    loop2();
                }
                else if (number == 2) {
                    searchFromList();
                }
                else if (number == 3) {
                   mainLoop();
                }
            }
        }
    }

    public void loop2 ()throws IOException{
        while (true) {
            System.out.println("\n1. Wyświetl wszystkie elementy listy\n2. Wyświetl wszystkie Psy\n3. Wyświetl wszystkie Rybki \n4. Wyświetl wszystkie zwierzęta w kategorii inne\n5. Wyjscie");
            character = in.next();
            if (Functions.isInteger(character)) {
                number = Integer.parseInt(character);
                if (number == 1) {
                    for (int i = 0; i < newClass.animals.size(); i++) {
                        newClass.getAnimlasFromList(newClass.animals.get(i));
                        continue;
                    }
                }
                else if (number == 2) {
                    for (Variables animal : newClass.animals) {
                        if (animal instanceof Dogs)
                            newClass.getAnimlasFromList(animal);
                        continue;
                    }
                }
                else if (number == 3) {
                    for (Variables animal : newClass.animals){
                        if (animal instanceof Fish)
                            newClass.getAnimlasFromList(animal);
                        continue;
                    }
                }
                else if (number == 4) {
                    for (Variables animal : newClass.animals){
                        if (animal instanceof Others)
                            newClass.getAnimlasFromList(animal);
                        continue;
                    }
                }
                else if (number == 5) {

                    break;
                }
            }
        }
    }
    public void searchFromList() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Wyszukaj zwierzaka.\n\nPodaj nazwisko właściciela:");
        String userInput = in.nextLine();
        System.out.println("Podaj imię zwierzaka:");
        String userInput2 = in.nextLine();
        for(Variables animal : newClass.animals) {
            int index = newClass.animals.indexOf(animal);
            if (animal.owner.equalsIgnoreCase(userInput) || animal.name.equalsIgnoreCase(userInput2)) {

                System.out.println("\nNazwisko właściciela: " + animal.owner + "\nImię zwierzaka: " + animal.name + "\nRasa: " + animal.breed + "\nWiek: " + animal.age);
                if (animal instanceof Dogs) {
                    System.out.println("Ilość szczeknięć na minutę: " + ((Dogs) animal).howManyBarks + "\n");
                }
                if (animal instanceof Fish) {
                    System.out.println("Ilość łusek na cm2: " + ((Fish) animal).howManyScales + "\n");
                }
                if (animal instanceof Others) {
                    System.out.println("Gatunek: " + ((Others) animal).category + "\n");
                }

            System.out.println("Co chcesz zrobić z elementem listy?" + "\n" + "1.Usuń element.\n2.Edytuj element.\n3.Wyjscie.");
            character = in.next();
            if (Functions.isInteger(character)) {
                number = Integer.parseInt(character);
                if (number == 1) {
                    deleteList(index);
                }
                if (number == 2) {
                    editList(animal);
                }
                if (number == 3) {
                    return;
                }
            }
        }
        if (!animal.owner.equalsIgnoreCase(userInput) && !animal.name.equalsIgnoreCase(userInput2)){
            System.out.println("Podane wartości nie pasują do listy\n");

        }
    }
    }


    public void editList(Variables animals)throws IOException{
        Scanner edit = new Scanner(System.in);
        int number;
        for(Variables animal : newClass.animals) {
        System.out.println("Wpisz nową wartość lub wciśnij enter, by przejść dalej.\n");
        System.out.println("Zmień nazwisko właściciela:");
        String userInput = edit.nextLine();
        if (!(userInput.equals(""))){
            animals.owner=userInput;
            System.out.println("Zedytowano pomyślnie");
        }
        System.out.println("Zmień rasę zwierzaka:");
         userInput = edit.nextLine();
        if (!(userInput.equals(""))){
            animals.breed = userInput;
            System.out.println("Zedytowano pomyślnie");
        }
        System.out.println("Zmień imię zwierzaka:");
        userInput = edit.nextLine();
        if (!(userInput.equals(""))){
            animals.name = userInput;
            System.out.println("Zedytowano pomyślnie");
        }
        System.out.println("Zmień wiek zwierzaka:");
        userInput = edit.nextLine();
        if (!(userInput.equals(""))){
        while (true) {
            if (Functions.isInteger(userInput)) {
                number = Integer.parseInt(userInput);
                if (number < 0) {
                    System.out.println("Podaj dodatnią wartość.");
                    continue;
                }
                if (number >= 0) {
                    animals.age = number;
                    System.out.println("Zedytowano pomyślnie");
                    break;
                }
            }
        }
        }

            if (animal instanceof Dogs){
                System.out.println("pieseł");
            }
            if (animal instanceof Fish){
                System.out.println("rybcia");
            }
            else {
                System.out.println("kupa");
            }



    }
    }

    public void deleteList (int index)throws IOException{
        System.out.println("Czy napewno chcesz usunąć?(Tak/Nie)");
        String userInput = in.next();
        if (userInput.equalsIgnoreCase("Tak")) {
            newClass.animals.remove(index);
            newClass.addAnimalToFile();
            System.out.println("Element został usunięty.\n");
        }
        else {
            System.out.println("Nie wprowadzono żadnych zmian.\n");
            return;
        }
    }

}


