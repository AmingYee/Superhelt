import java.util.Scanner;

public class UI {
    Database database = new Database();
    Scanner sc = new Scanner(System.in);
    private void getvelkommen() {
        System.out.println("Velkommen til superhelteverdenen!");
        System.out.println("---------------------------------------");
        UI program = new UI();
        int menuValg;
        System.out.println("Velkommen til superhelte database");
        do {
            System.out.println("(1) for at oprette ny superhelt");
            System.out.println("(2) for at se liste");
            System.out.println("(3) for at søge i listen");
            System.out.println("(9) for at afslutte");
            menuValg = sc.nextInt();
            sc.nextLine();

            if (menuValg == 1) {
                program.getOpret();
            } else if (menuValg == 2) {
                program.getList();
            } else if (menuValg == 3) {
                program.getSearch();
            }
        }
        while (menuValg != 9);
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
        int creationYear = 0;
        boolean creationLoopEndValue = true;
        do {
            if (sc.hasNextInt()) {
                creationYear = sc.nextInt();
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
            if (sc.hasNextInt()) {
                strenght = sc.nextInt();
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

    public void startUp() {
        UI program = new UI();
        program.getvelkommen();
    }
}