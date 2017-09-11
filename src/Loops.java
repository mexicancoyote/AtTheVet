import Animal_Data_Base.Dogs;
import Animal_Data_Base.Fish;
import Animal_Data_Base.Others;
import Animal_Data_Base.Variables;

import java.io.IOException;
import java.util.Scanner;

public class Loops {
    boolean loop0 = true;
    Scanner in = new Scanner(System.in);
    String character;
    int number;
    Animals newClass = new Animals();

    public void loop1 ()throws IOException{
        while (loop0) {
            System.out.println("1. Wyświetl liste\n2. Wyszukaj z listy\n3. Edytuj liste\n4. Wyjscie");
            character = in.next();
            if (Functions.isInteger(character)) {
                number = Integer.parseInt(character);
                if (number == 1) {
                    loop2();
                }

                else if (number == 2) {


                    break;

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
        while (loop0) {
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
}
