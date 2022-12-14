import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Database database = new Database();
    Scanner sc = new Scanner(System.in);

    private void getMenu() {
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
            System.out.println("(5) for at søge og redigere efter en superhelt");
            System.out.println("(6) for at søge og slette en superhelt");
            System.out.println("(9) for at afslutte");
            menuValg = sc.next();
            sc.nextLine();
            switch (menuValg) {
                case "1":
                    program.getCreateHero();
                    break;
                case "2":
                    program.getList();
                    break;
                case "3":
                    program.getSearch();
                    break;
                case "4":
                    program.getAdvancedSearch();
                    break;
                case "5":
                    program.getSearchAndEdit();
                    break;
                case "6":
                    program.getSearchAndDelete();
                    break;
                case "9":
                    velkommenLoopEndValue = false;
                    break;
                default:
                    System.out.println("indtast et tal fra menues for at fortsætte");
                    System.out.println("--------------");
                }
            }
        while (velkommenLoopEndValue);
        }

    private void getCreateHero() {
        System.out.println("indtast superheltens navn");
        String superHeroName = sc.next();
        sc.nextLine();
        System.out.println("indtast virkiligt navn");
        String realName = sc.next();
        sc.nextLine();
        System.out.println("menneske eller ej (j)a/(n)ej");
        String jaNej;
        boolean humanOrNot = false;
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
        ArrayList<Superhero> searchResult = database.advancedHeroSearch(advancedHeroSearchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Der findes ingen superhelt i databasen som hedder " + advancedHeroSearchTerm);
        } else if (searchResult.size() == 1) {
            System.out.println("en superhero fundet");
            Superhero superhero = searchResult.get(0);
            System.out.println("Superheltenavn: " + superhero.getSuperHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er menneske: " + superhero.isHumanOrNot());
            System.out.println("Styrke : " + superhero.getStrenght());
            System.out.println("-----------");
        } else {
            System.out.println("flere superhelte som matcher dit søgeterm fundet");
            for (Superhero superhero : searchResult) {
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
        ArrayList<Superhero> searchResult = database.searchAndEdit(searchAndEditTerm);
        if (searchResult.size() == 0) {
            System.out.println("Der findes ingen superhelt i databasen som hedder " + searchAndEditTerm);
        }
        else if (searchResult.size() == 1) {
            System.out.println("en superhero fundet");
            Superhero editHero = searchResult.get(0);
            System.out.println("Redigerer supherhelt: " + editHero.getSuperHeroName());
            System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");
            System.out.println("Superheltnavn: " + editHero.getSuperHeroName());
            String newSuperHeroName = sc.nextLine().trim();
            sc.nextLine();
            if (!newSuperHeroName.isEmpty())
                editHero.setSuperHeroName(newSuperHeroName);

            System.out.println("Superkraft: " + editHero.getSuperPower());
            String newSuperPower = sc.nextLine().trim();
            if (!newSuperPower.isEmpty())
                editHero.setSuperPower(newSuperPower);

            System.out.println("Virkelight navn: " + editHero.getRealName());
            String newRealName = sc.nextLine().trim();
            if (!newRealName.isEmpty())
                editHero.setRealName(newRealName);

            System.out.println("Oprindelsesår: " + editHero.getCreationYear());
            boolean newCreationYearLoopEndValue = true;
            do {
                String newCreationYear = sc.nextLine().trim();
                try {
                    if (!newCreationYear.isEmpty())
                        editHero.setCreationYear(newCreationYear);
                    newCreationYearLoopEndValue = false;
                } catch(NumberFormatException e){
                    System.out.println("indtast året han blev lavet i hele tal");
                }
            }while (newCreationYearLoopEndValue);

            System.out.println("Menneske eller ej (j)a/(n)ej: " + editHero.isHumanOrNot());
            String newHumanOrNot = null;
            boolean humanLoopEndValue = true;
            do {
                String jaNej = sc.nextLine();
                if (jaNej.isEmpty()) {
                    humanLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("j")) {
                    newHumanOrNot = String.valueOf(true);
                    humanLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("n")) {
                    newHumanOrNot = String.valueOf(false);
                    humanLoopEndValue = false;
                }else{
                    System.out.println("indtast j eller n");
                }
            } while (humanLoopEndValue);
            editHero.setHumanOrNot(newHumanOrNot);

            System.out.println("Styrkeværdi: " + editHero.getStrenght());
            boolean newStrenghtLoopEndValue = true;
            do {
                String newStrenght = sc.nextLine().trim();
                try {
                    if (!newStrenght.isEmpty())
                        editHero.setStrenght(newStrenght);
                    newStrenghtLoopEndValue = false;
                } catch(NumberFormatException e){
                    System.out.println("indtast styrkeværdi i tal");
                }
            }while (newStrenghtLoopEndValue);
        }
        else {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(i + 1 + ":" + searchResult.get(i));
            }
            System.out.println("flere superhelte som matcher dit søgeterm fundet" + "\nindtast nr på den superhelt der skal redigeres:");
            int nr = 0;
            boolean selectorLoopEndValue = true;
            do {
                if(sc.hasNextInt())
                    nr = sc.nextInt();
                sc.nextLine();
                if (nr <= 0) {
                    System.out.println("indtast nr på den superhelt der skal redigeres: ");
                } else if (nr -1 >= searchResult.size()){
                    System.out.println("indtast nr på den superhelt der skal redigeres: ");
                } else {
                    selectorLoopEndValue = false;
                }
            } while (selectorLoopEndValue);

            Superhero editHero = searchResult.get(nr - 1);

            System.out.println("Redigerer supherhelt: " + editHero.getSuperHeroName());
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
            boolean newCreationYearLoopEndValue = true;
            do {
            String newCreationYear = sc.nextLine().trim();
                try {
                    if (!newCreationYear.isEmpty())
                        editHero.setCreationYear(newCreationYear);
                    newCreationYearLoopEndValue = false;
                    } catch(NumberFormatException e){
                        System.out.println("indtast året han blev lavet i hele tal");
                    }
            }while (newCreationYearLoopEndValue);

            System.out.println("Menneske eller ej (j)a/(n)ej: " + editHero.isHumanOrNot());
            String newHumanOrNot = null;
            boolean humanLoopEndValue = true;
            do {
                String jaNej = sc.nextLine();
                if (jaNej.isEmpty()) {
                    humanLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("j")) {
                    newHumanOrNot = String.valueOf(true);
                    humanLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("n")) {
                    newHumanOrNot = String.valueOf(false);
                    humanLoopEndValue = false;
                }else{
                    System.out.println("indtast j eller n");
                }
            } while (humanLoopEndValue);
            editHero.setHumanOrNot(newHumanOrNot);

            System.out.println("Styrkeværdi: " + editHero.getStrenght());
            boolean newStrenghtLoopEndValue = true;
            do {
                String newStrenght = sc.nextLine().trim();
                try {
                    if (!newStrenght.isEmpty())
                        editHero.setStrenght(newStrenght);
                    newStrenghtLoopEndValue = false;
                } catch(NumberFormatException e){
                    System.out.println("indtast styrkeværdi i tal");
                }
            }while (newStrenghtLoopEndValue);
        }
    }
    private void getSearchAndDelete() {
        System.out.println("Indtast det du vil søge efter");
        String searchAndEditTerm = sc.next();
        ArrayList<Superhero> searchResult = database.searchAndEdit(searchAndEditTerm);
        if (searchResult.size() == 0) {
            System.out.println("Der findes ingen superhelt i databasen som hedder " + searchAndEditTerm);
        } else if (searchResult.size() == 1) {
            System.out.println("en superhero fundet");
            Superhero deleteHero = searchResult.get(0);
            System.out.println("er du sikker på at du vil slette \n" + searchResult.get(0) + "\n (j)a/(n)ej");
            boolean deleteLoopEndValue = true;
            do {
                String jaNej = sc.nextLine();
                if (jaNej.equalsIgnoreCase("j")) {
                    database.deleteSuperHero(deleteHero);
                    deleteLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("n")) {
                    deleteLoopEndValue = false;
                } else {
                    System.out.println("indtast j eller n");
                }
            } while (deleteLoopEndValue);

        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(i + 1 + ":" + searchResult.get(i));
            }
            System.out.println("superhelte der matcher dit søgeterm fundet \nindtast nr på den superhelt der skal redigeres:");
            int nr = 0;
            boolean selectorLoopEndValue = true;
            do {
                if(sc.hasNextInt())
                    nr = sc.nextInt();
                sc.nextLine();
                if (nr <= 0) {
                    System.out.println("indtast nr på den superhelt der skal slettes: ");
                } else if (nr -1 >= searchResult.size()){
                    System.out.println("indtast nr på den superhelt der skal slettes: ");
                } else {
                    selectorLoopEndValue = false;
                }
            } while (selectorLoopEndValue);

            Superhero deleteHero = searchResult.get(nr - 1);
            System.out.println("er du sikker på at du vil slette \n" + searchResult.get(nr - 1) + "\n (j)a/(n)ej");
            boolean deleteLoopEndValue = true;
            do {
                String jaNej = sc.nextLine();
                if (jaNej.equalsIgnoreCase("j")) {
                    database.deleteSuperHero(deleteHero);
                    deleteLoopEndValue = false;
                } else if (jaNej.equalsIgnoreCase("n")) {
                    deleteLoopEndValue = false;
                } else {
                    System.out.println("indtast j eller n");
                }
            } while (deleteLoopEndValue);
        }
    }
    public void startUp () {
        UI program = new UI();
        program.getMenu();
    }
}