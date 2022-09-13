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
                System.out.println("indtast virkiligt navn");
                String realName = sc.next();
                sc.nextLine();
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
                System.out.println("indtast året han blev lavet");
                int creationYear = 0;
                boolean creationLoopEndValue = true;
                do{
                    if (sc.hasNextInt()){
                        creationYear = sc.nextInt();
                        creationLoopEndValue = false;
                    } else {
                        System.out.println("indtast året han blev lavet i hele tal");
                        sc.nextLine();
                    }
                }while (creationLoopEndValue);
                System.out.println("indtast superkraft");
                String superPower = sc.next();
                sc.nextLine();
                System.out.println("Indtast styrkeværdi 1.0 svarer til normalt menneske");
                double strenght = 0;
                boolean strenghtLoopEndValue = true;
                do{
                    if (sc.hasNextInt()){
                        strenght = sc.nextInt();
                        strenghtLoopEndValue = false;
                    } else {
                        System.out.println("indtast styrkeværdi i tal 1.0 svarer til normal mennske");
                        sc.nextLine();
                    }
                }while (strenghtLoopEndValue);
                database.superhero(superHeroName, realName, humanOrNot, creationYear, superPower, strenght);
            }
        }
            while (menuValg != 9) ;
    }
}