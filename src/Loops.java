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
            Scanner in = new Scanner(System.in);
            String character = in.next();
            if (Functions.isInteger(character)) {
                int number = Integer.parseInt(character);
                if (number == 1) {
                    loop1();
                }

                else if (number == 2) {
                    newClass.addAnimalToList();
                    newClass.addAnimalToFile();
                    continue;

                } else if (number == 3) {
                    System.out.println("Dziękujemy za skorzystanie z programu AtTheVet");
                    break;
                } else {
                    continue;
                }


            }
        }
    }

    public void loop1 ()throws IOException{
        while (true) {
            System.out.println("1. Wyświetl liste\n2. Wyszukaj z listy\n3. Edytuj liste\n4. Wyjscie");
            character = in.next();
            if (Functions.isInteger(character)) {
                number = Integer.parseInt(character);
                if (number == 1) {
                    loop2();
                }
                else if (number == 2) {
                    searchFromList();
                } else if (number == 3) {
                    break;
                } else if (number == 4) {
                    break;
                } else {
                    continue;
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
                } else if (number == 2) {
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
                } else if (number == 4) {
                    for (Variables animal : newClass.animals){
                        if (animal instanceof Others)
                            newClass.getAnimlasFromList(animal);
                        continue;
                    }
                } else if (number == 5) {

                    break;
                } else {
                    continue;
                }
            }
        }
    }
    public void searchFromList ()throws IOException{
        Scanner search = new Scanner(System.in);
        System.out.println("Podaj nazwisko właściciela:");
        String userInput = search.nextLine();
        System.out.println("Podaj imię zwierzaka:");
        String userInput2 = search.nextLine();
       for (Variables animal : newClass.animals) {
            if(animal.owner.equalsIgnoreCase(userInput) || animal.name.equalsIgnoreCase(userInput2)) {
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
            }




        }

    }


}

