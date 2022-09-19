import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Database database = new Database();
    Scanner sc = new Scanner(System.in);

    private void getvelkommen() {
        System.out.println("Velkommen til superhelteverdenen!");
        System.out.println("---------------------------------------");
        UI program = new UI();
        String menuValg;
        boolean velkommenLoopEndValue = true;
        System.out.println("Velkommen til superhelte database");
        do {
            System.out.println("(1) for at oprette ny superhelt");
            System.out.println("(2) for at se liste");
            System.out.println("(3) for at søge på enkelt superhelt i listen");
            System.out.println("(4) for at søge på flere superhelte i listen");
            System.out.println("(5) for at redigere");
            System.out.println("(9) for at afslutte");
            menuValg = sc.next();
            sc.nextLine();
            if (menuValg.equals("1")) {
                program.getOpret();
            } else if (menuValg.equals("2")) {
                program.getList();
            } else if (menuValg.equals("3")) {
                program.getSearch();
            } else if (menuValg.equals("4")) {
                program.getAdvancedSearch();
            } else if (menuValg.equals("5")) {
                program.getSearchAndEdit();
            } else if (menuValg.equals("9")) {
                velkommenLoopEndValue = false;
            } else {
                System.out.println("indtast et tal fra menues for at fortsætte");
                System.out.println("--------------");
            }
        }
        while (velkommenLoopEndValue);
    }
    private void getOpret() {
        System.out.println("indtast superheltens navn");
        String superHeroName = sc.next();
        sc.nextLine();
        System.out.println("indtast virkiligt navn");
        String realName = sc.next();
        sc.nextLine();
        System.out.println("menneske eller ej (j)a/(n)ej");
        String jaNej;
        Boolean humanOrNot = false;
        boolean humanLoopEndValue = true;
        do {
            jaNej = sc.next();
            if (jaNej.equalsIgnoreCase("j")) {
                humanOrNot = true;
                humanLoopEndValue = false;
            } else if (jaNej.equalsIgnoreCase("n")) {
                humanOrNot = false;
                humanLoopEndValue = false;
            } else {
                System.out.println("indtast j eller n");
            }
        } while (humanLoopEndValue);
        System.out.println("indtast året han blev lavet");
        sc.nextLine();
        int creationYear = 0;
        boolean creationLoopEndValue = true;
        do {
            if (sc.hasNextInt()) {
                creationYear = sc.nextInt();
                sc.nextLine();
                creationLoopEndValue = false;
            } else {
                System.out.println("indtast året han blev lavet i hele tal");
                sc.nextLine();
            }
        } while (creationLoopEndValue);
        System.out.println("indtast superkraft");
        String superPower = sc.next();
        sc.nextLine();
        System.out.println("Indtast styrkeværdi 1.0 svarer til normalt menneske");
        double strenght = 0;
        boolean strenghtLoopEndValue = true;
        do {
            if (sc.hasNextDouble()) {
                strenght = sc.nextDouble();
                strenghtLoopEndValue = false;
            } else {
                System.out.println("indtast styrkeværdi i tal 1.0 svarer til normal mennske");
                sc.nextLine();
            }
        } while (strenghtLoopEndValue);
        database.createSuperHero(superHeroName, realName, humanOrNot, creationYear, superPower, strenght);
    }
    private void getList() {
        System.out.println("Liste af superhelte");
        for (Superhero superhero : database.getAllSuperHeroes()) {
            System.out.println("Superheltenavn: " + superhero.getSuperHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er menneske: " + superhero.isHumanOrNot());
            System.out.println("Styrke : " + superhero.getStrenght());
            System.out.println("-----------");
        }
    }
    private void getSearch() {
        System.out.println("Indtast det du vil søge efter");
        String heroSearchTerm = sc.next();
        if (database.heroSearch(heroSearchTerm) != null) {
            System.out.println("hero found: " + database.heroSearch(heroSearchTerm));
        } else {
            System.out.println("Findes ikke i databasen");
        }

    }
    private void getAdvancedSearch() {
        String advancedHeroSearchTerm = sc.next();
        ArrayList<Superhero> søgeResultat = database.advancedHeroSearch(advancedHeroSearchTerm);

        if (søgeResultat.isEmpty()) {
            System.out.println("no superheroes matching search term found");
        } else if (søgeResultat.size() == 1) {
            System.out.println("single superhero found");
            Superhero superhero = søgeResultat.get(0);
            System.out.println("Superheltenavn: " + superhero.getSuperHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er menneske: " + superhero.isHumanOrNot());
            System.out.println("Styrke : " + superhero.getStrenght());
            System.out.println("-----------");
        } else {
            System.out.println("multiple superheroes found");
            for (Superhero superhero : søgeResultat) {
                System.out.println("Superheltenavn: " + superhero.getSuperHeroName());
                System.out.println("Superkraft: " + superhero.getSuperPower());
                System.out.println("Virkeligt navn: " + superhero.getRealName());
                System.out.println("Oprindelsesår: " + superhero.getCreationYear());
                System.out.println("Er menneske: " + superhero.isHumanOrNot());
                System.out.println("Styrke : " + superhero.getStrenght());
                System.out.println("-----------");
            }
        }
    }
    private void getSearchAndEdit() {
        System.out.println("Indtast det du vil søge efter");
        String searchAndEditTerm = sc.next();
        ArrayList<Superhero> søgeResultat = database.searchAndEdit(searchAndEditTerm);
        if (database.searchAndEdit(searchAndEditTerm) != null) {
            for (int i = 0; i < søgeResultat.size(); i++) {
                System.out.println(i + 1 + ":" + søgeResultat.get(i));
            }
            System.out.println("indtast nr på den superhelt der skal redigeres:");
            int nr = sc.nextInt();
            sc.nextLine();
            Superhero editHero = søgeResultat.get(nr - 1);
            System.out.println("Editperson: " + editHero);
            System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");
            System.out.println("Superheltnavn: " + editHero.getSuperHeroName());
            String newSuperHeroName = sc.nextLine();
            if (!newSuperHeroName.isEmpty())
                editHero.setSuperHeroName(newSuperHeroName);

            System.out.println("Superkraft: " + editHero.getSuperPower());
            String newSuperPower = sc.nextLine();
            if (!newSuperPower.isEmpty())
                editHero.setSuperPower(newSuperPower);

            System.out.println("Virkelight navn: " + editHero.getRealName());
            String newRealName = sc.nextLine();
            if (!newRealName.isEmpty())
                editHero.setRealName(newRealName);

            System.out.println("Oprindelsesår: " + editHero.getCreationYear());
            String newCreationYear = sc.nextLine();
            if (!newCreationYear.isEmpty())
                editHero.setCreationYear(newCreationYear);

            System.out.println("Menneske eller ej (j)a/(n)ej: " + editHero.isHumanOrNot());
            String newHumanOrNot = sc.nextLine();
            if (!newHumanOrNot.isEmpty())
                editHero.setHumanOrNot(newHumanOrNot);

            System.out.println("Styrkeværdi: " + editHero.getStrenght());
            String newStrenght = sc.nextLine();
            if (!newStrenght.isEmpty())
                editHero.setStrenght(newStrenght);
        }
        else{
            System.out.println("Der findes ingen superhelt i databasen som hedder " + searchAndEditTerm);
        }
    }

    public void startUp () {
        UI program = new UI();
        program.getvelkommen();
    }
}