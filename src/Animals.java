import Animal_Data_Base.Dogs;
import Animal_Data_Base.Fish;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class Animals {
    Variables animal;
    String ownerStr;
    String breedStr;
    String nameStr;
    String ageStr;
    String howManyScalesStr;
    int howManyScales = 0;
    String howManyBarksStr;
    int howManyBarks = 0;
    String category;

    List<Variables> animals = new LinkedList<>();

    public void addAnimalToList() throws IOException {


        int genre = 0;

        Scanner input = new Scanner(System.in);
        boolean loop1 = true;
        do {
            System.out.println("Dodaj pacjenta:\n1.Psa.\n2.Rybkę.\n3.Inne.\n4.Wyjscie.");
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
        ownerStr = input.next();
        System.out.println("Podaj rasę: ");
        breedStr = input.next();
        System.out.println("Podaj imię zwierzaka: ");
        nameStr = input.next();
        do {
            System.out.println("Podaj wiek zwierzaka: ");
            ageStr = input.next();
            if (Functions.isInteger(ageStr)) {
                ageInt = Integer.parseInt(ageStr);
            }
        }
        while (!(ageInt > 0));


        if (genre == 1) {

            do {
                System.out.println("Ile razy pies szczeka: ");
                howManyBarksStr = input.next();
                if (Functions.isInteger(howManyBarksStr)) {
                    howManyBarks = Integer.parseInt(howManyBarksStr);
                }
            }
            while (!(howManyBarks > 0));
            animal = new Dogs(howManyBarks, ownerStr, breedStr, nameStr, ageInt );
            System.out.println("Dodałeś nowego psa do bazy pacjentów.\n");
        } else if (genre == 2) {

            do {
                System.out.println("Ile łusek ma rybka: ");
                howManyScalesStr = input.next();
                if (Functions.isInteger(howManyScalesStr)) {
                    howManyScales = Integer.parseInt(howManyScalesStr);
                }
            }
            while (!(howManyScales > 0));
            animal = new Fish(howManyScales, ownerStr, breedStr, nameStr, ageInt);
            System.out.println("Dodałeś nową rybkę do bazy pacjentów.\n");
        } else {
            System.out.println("Podaj gatunek zwierzęcia: ");
            category = input.next();
            animal = new Others(ownerStr, breedStr, nameStr, ageInt, category);
            System.out.println("Dodałeś nowego zwierzaka do bazy pacjentów.\n");
        }
        animals.add(animal);
        addAnimalToFile();


    }

    public void addAnimalToFile() throws IOException {


        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("animalsDataBase", false), "UTF-8"));
        for (Variables animal : animals) {
            if (animal instanceof Dogs) {
                Dogs d = (Dogs) animal;
                writer.write("Dogs:" + "\n");
                writer.write(d.howManyBarks + "\n");
            } else if (animal instanceof Fish) {
                Fish f = (Fish) animal;
                writer.write("Fish:" + "\n");
                writer.write(f.howManyScales + "\n");
            } else if (animal instanceof Others) {
                Others o = (Others) animal;
                writer.write("Others:" + "\n");
                writer.write(o.category + "\n");
            }
            writer.write(animal.owner + "\n");
            writer.write(animal.breed + "\n");
            writer.write(animal.name + "\n");
            writer.write(animal.age + "\n");

        }
        writer.flush();
        writer.close();
    }


    public void getAnimlasFromList(Variables animal) {

        System.out.print("Nazwisko: " + animal.owner + " ");
        System.out.print("Rasa: " + animal.breed + " ");
        System.out.print("Imię zwierzęcia: " + animal.name + " ");
        System.out.print("Wiek zwierzęcia: " + animal.age + " ");
        if (animal instanceof Dogs)
            System.out.print("Ilość szczeknięć: " + ((Dogs) animal).howManyBarks + "\n");
        if (animal instanceof Fish)
            System.out.print("Ilość łusek: " + ((Fish) animal).howManyScales + "\n");
        if (animal instanceof Others)
            System.out.print("Gatunek: " + ((Others) animal).category + "\n");
    }

    public void getAnimalsFromFileToList() throws IOException {
        Scanner read = new Scanner(new File("animalsDataBase"));
        String content;

        while (read.hasNext()) {
            content = read.nextLine();
            int ageInt;
            System.out.println("W bazie znajduje sie aktualnie ");
            if ("Dogs:".equals(content)) {
                howManyBarks=Integer.parseInt(read.nextLine());
                animal = new Dogs();
            }
            else if ("Fish:".equals(content)){
                howManyScales=Integer.parseInt(read.nextLine());
                animal = new Fish();
            }
            else if ("Others:".equals(content)){
                category=read.nextLine();
                animal = new Others();
            }
            animal.owner=read.nextLine();
            animal.breed=read.nextLine();
            animal.name=read.nextLine();
            animal.age=Integer.parseInt(read.nextLine());
            animals.add(animal);
        }
    }
}







