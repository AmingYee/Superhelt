import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database database = new Database();
        System.out.println("Velkommen til superhelteverdenen!");
        System.out.println("---------------------------------------");

        int menuValg;
        do {
            System.out.println("(1) for at oprette ny superhelt");
            System.out.println("(2) for at se liste");
            System.out.println("(9) for at afslutte");
            menuValg = sc.nextInt();
            sc.nextLine();

            if (menuValg == 1) {
                System.out.println("Velkommen til superhelte database");
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
                    if (jaNej.contains("j")){
                        humanOrNot = true;
                        humanLoopEndValue = false;
                    }
                    else if (jaNej.contains("n")){
                        humanOrNot = false;
                        humanLoopEndValue = false;
                    }
                    else {
                        System.out.println("indtast j eller n");
                    }
                } while(humanLoopEndValue);
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
            else if (menuValg == 2) {
                System.out.println("Liste af superhelte");
                for (Superhero superhero : database.getAllSuperHeroes()) {
                    System.out.println("Superheltenavn: " + superhero.getSuperHeroName());
                    System.out.println("Superkraft: " + superhero.getSuperPower());
                    System.out.println("Virkeligt navn: " + superhero.getRealName());
                    System.out.println("Oprindelsesår: " + superhero.getCreationYear());
                    System.out.println("Er menneske: " + superhero.isHumanOrNot());
                    System.out.println("Styrke : " + superhero.getStrenght());
                }
            }
            }
        while (menuValg != 9);
        }

    }