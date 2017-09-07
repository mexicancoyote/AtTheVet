

import Animal_Data_Base.*;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class AddAnimalToList {


    public static void addAnimalToList() {
        String owner;
        String category;
        String breed;
        String name;
        List<Dogs> dogs = new LinkedList<>();
        List<Cats> cats = new LinkedList<>();
        List<Others> others = new LinkedList<>();


        Scanner input = new Scanner(System.in);


        System.out.println("Podaj nazwisko właściciela");
        owner = input.next();
        System.out.println("Podaj gatunek pacjenta");
        category = input.next();
        System.out.println("Podaj rase");
        breed = input.next();
        System.out.println("Podaj imie zwierzaka");
        name = input.next();

        boolean loop3 = true;
        while (loop3) {

            System.out.println("podaj wiek zwierzaka");
            String age = input.next();
        if (Function.isInteger(age)) {
            int number = Integer.parseInt(age);
            if (number<0){
                System.out.println("dopiero go planujecie czy co ?");
            }
            if (number==0){
                System.out.println("młodziutka bestia");
                dogs.add(new Dogs(owner, category, breed, name, number));
                break;
            }
            if (number>0){
            dogs.add(new Dogs(owner, category, breed, name, number));
                break;

            }
            else {
                continue;
            }
        }

    }
}
}