import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Velkommen til superhelte database");
        System.out.println("indtast superheltens navn");
        String superHeroName = sc.next();
        System.out.println("indtast virkiligt navn");
        String virkeligtNavn = sc.next();
        System.out.println("er han menneske eller ej");
        String humanOrNot = sc.next();
        System.out.println("indtast året han blev lavet");
        int creationYear = sc.nextInt();
        System.out.println("Indtast styrkeværdi");
        int Strenght = sc.nextInt();
    }
}