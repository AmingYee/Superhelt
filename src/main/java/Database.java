import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperHero(String superHeroName, String realName, boolean humanOrNot, int creationYear, String superPower, double strenght) {
        superheroes.add(new Superhero(superHeroName, realName, humanOrNot, creationYear, superPower, strenght));
    }

    public ArrayList<Superhero> getAllSuperHeroes() {
        return superheroes;
    }

    public Superhero heroSearch(String heroSearchTerm) {
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().equalsIgnoreCase(heroSearchTerm)) {
                return hero;
            } else if (hero.getSuperHeroName().contains(heroSearchTerm)) {
                return hero;
            }
        }
        return null;
    }

    public ArrayList<Superhero> advancedHeroSearch(String advancedHeroSearchTerm) {
        ArrayList<Superhero> søgeResultat = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(advancedHeroSearchTerm)) {
                søgeResultat.add(hero);
            }
            return superheroes;
        }
        return null;
    }

    public ArrayList<Superhero> searchAndEdit(String searchAndEditTerm) {
        ArrayList<Superhero> søgeResultat = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(searchAndEditTerm)) {
                søgeResultat.add(hero);
            }
            for (int i = 0; i < søgeResultat.size(); i++) {
                System.out.println(i + 1 + ":" + søgeResultat.get(i));
            }
            return superheroes;
        } return null;
    }
}
 /*   public void advancedHeroSearch(String advancedHeroSearchTerm) {
        ArrayList<Superhero> søgeResultat = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(advancedHeroSearchTerm)) {
                søgeResultat.add(hero);
            }
        }
        if (!søgeResultat.isEmpty())
            for (Superhero hero : søgeResultat)
                System.out.println(hero);
        else
            System.out.println("Der findes ingen personer i listen med navn: " + "\"" + advancedHeroSearchTerm + "\"");

        for (int i = 0; i < søgeResultat.size(); i++) {
            System.out.println(i + 1 + ":" + søgeResultat.get(i));
        }
        System.out.println("indtast nr på den person der skal redigeres:");
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
    }*/