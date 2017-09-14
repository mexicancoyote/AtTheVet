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
        while(true) {
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
                    break;
                }
            }
        }
    }

    public void loop1 ()throws IOException{
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
    public void searchFromList ()throws IOException{
        Scanner search = new Scanner(System.in);
        System.out.println("Wyszukaj zwierzaka.\n\nPodaj nazwisko właściciela:");
        String userInput = search.nextLine();
        System.out.println("Podaj imię zwierzaka:");
        String userInput2 = search.nextLine();
        int index= 0;
       for (Variables animal : newClass.animals) {
            if(animal.owner.equalsIgnoreCase(userInput) || animal.name.equalsIgnoreCase(userInput2)) {
                index = newClass.animals.indexOf(animal);
                System.out.println("\nNazwisko właściciela: "+animal.owner +"\nImię zwierzaka: "+animal.name+"\nRasa: "+animal.breed+"\nWiek: "+animal.age);
                if (animal instanceof Dogs) {
                    System.out.println("Ilość szczeknięć na minutę: "+((Dogs) animal).howManyBarks+"\n");
                }
                if (animal instanceof Fish) {
                    System.out.println("Ilość łusek na cm2: "+((Fish) animal).howManyScales+"\n");
                }
                if (animal instanceof Others){
                    System.out.println("Gatunek: "+((Others) animal).category+"\n");
                }



        System.out.println("Co dalej chcesz zrobić z elementem listy ?"+"\n\n"+"1.Usuń element.\n2.Edytuj element.\n3.Wyjscie.");
        character = in.next();
        if (Functions.isInteger(character)) {
        number = Integer.parseInt(character);
            if(number==1){
                System.out.println("Czy napewno chcesz usunąć "+ userInput2+"?");
                userInput = in.next();
                if (userInput.equalsIgnoreCase("tak")) {
                    newClass.animals.remove(index);
                    newClass.addAnimalToFile();
                    System.out.println("Element został usunięty.");
                }
                else {
                    System.out.println("Nie wprowadzono żadnych zmian.");
                    loop1();
                }
            }
            if(number==2){
               // animal.owner
                //newClass.animals.set(index, );
            }
            if(number==3){
                mainLoop();
            }
        }
        }
        }
    }


    public void editList (){

    }
    public void deleteList (){


    }
}

