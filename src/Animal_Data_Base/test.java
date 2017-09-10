

/*
Najpierw zróbcie tak, żeby klasy poszczególnych zwierząt sie czyms roznily. Czyli żeby np Dog  miał zmienną 'int liczbaZjedzonychKapci' a Cat  'int wydajnoscMiaukniecNaMnnute' albo cos w tym stylu
I tak jak powiedzialem - przeniescioe zmienna String category; z klasy Variables do klasy Others - bo Dog i Cat niepotrzebnie ją dziedziczą.


Wtedy robicie zapis i odczyt do/z pliku.

Zauważcie, że każde zwierze bedzie inaczej zapisane, bo oprocz wspolnych danych (imie, wiek itd) trzeba bedzie zapisywac liczbaZjedzonychKapci dla psa, kategorie dla Others itd

W takim wypadku, mając w liscie kolejno Dog, Cat, Others plik niech wyglada w ten sposob:


Dog
liczbaZjedzonychKapci
nazwiskowlasciciela
rasa
imiezwierzaka
wiek
Cat
wydajnoscMiaukniecNaMinute
nazwiskowlasciciela
rasa
imiezwierzaka
wiek
Others
kategoriazwierzaka (tzn gatunek)
nazwiskowlasciciela
rasa
imiezwierzaka
wiek









    public void saveListToFile() {
    <otwieramy plik - jeden dla wszystkich zwierząt. Jeśli jest opcja otwarcia go z nadpisaniem, to jej używamy. Jak nie - czyścimy go inną metodą, żeby był pusty przed zapisem>

        for (Variable animal in database) {
            if (animal instanceof Dog) {//sprawdzamy czy zwierze jest psem
            <wpisz do pliku 'Dog'>
                        Dog d = (Dog) animal; //!! konwertujemy sobie zwierze na psa (ważne, żeby dostać sie do zmiennej, ktora ma tylko pies)
            <wpisz do pliku dog.liczbaZjedzonychKapci>
            } else if (animal instanceof Cat) {
            <wpisz do pliku 'Cat'>
            } else if (animal instanceof Cat) {
            <wpisz do pliku 'Others'>
            }

        <wpisz do pliku linijka po linijce wszystkie pozostale cechy z wspolne - czyli ze zmiennej animal (klasy Variable): wlasciciel, rasa, imie, wiek.
                    Zmienna Dog d; nie bedzie widoczna poza ifem, w ktorym została stworzona, a i nie jest potrzebna do wypisania cech wspolnych>


        }

    <poza petla juz, zamykamy plik i jest git>
    }



    public void loadListFromFile() {
        //ta metoda musi być 'odwrotna' do tej wyjżej
    <pobieramy pierwsza linijke - to bedzie napis Dog, Cat lub Others>

        Zwierze z;

        while (dopoki nie ma konca pliku) {
            if (pierwszaLinijka.equals("Dog")) {
                z = new Dog();
                z.liczbaZjedzonychKapci = <odczyt drugiej linijki>
            } else if (to samo dla kota i others) {
            ...
            }

        <a teraz odczytujemy po kolei linijki wspolnych cech i ladujemy do zmiennej 'z'

            z.owner = <3cia linijka>
        ...

            database.add(z);//dodajemy zwierzaka do listy
        }


    }
*/