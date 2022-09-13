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
            System.out.println("(9) for at afslutte");
            menuValg = sc.nextInt();
            sc.nextLine();

            if (menuValg == 1) {
                System.out.println("Velkommen til superhelte database");
                System.out.println("indtast superheltens navn");
                String superHeroName = sc.next();
                sc.nextLine();
                System.out.println("superheltens navn: " + superHeroName);
                System.out.println("indtast virkiligt navn");
                String realName = sc.next();
                sc.nextLine();
                System.out.println("virkeligt navn: " + realName);
                System.out.println("menneske eller ej true/false");
                Boolean humanOrNot = null;
                boolean humanLoopEndValue = true;
                do{
                    if (sc.hasNextBoolean()) {
                        humanOrNot = sc.nextBoolean();
                        sc.nextLine();
                        humanLoopEndValue = false;
                    } else {
                        System.out.println("indtast true/false i små bogstaver");
                        sc.nextLine();
                    }
                }while(humanLoopEndValue);
                System.out.println("er han menneske: " + humanOrNot);
                System.out.println("indtast året han blev lavet");
                int creationYear = sc.nextInt();
                sc.nextLine();
                System.out.println("året han blev lavet: " + creationYear);
                System.out.println("indtast superkraft");
                String superPower = sc.next();
                sc.nextLine();
                System.out.println("superkraft: " + superPower);
                System.out.println("Indtast styrkeværdi");
                double strenght = sc.nextInt();
                sc.nextLine();
                System.out.println("styrke værdi: " + strenght);
                database.superhero(superHeroName, realName, humanOrNot, creationYear, superPower, strenght);
            }
        }
            while (menuValg != 9) ;
    }
}