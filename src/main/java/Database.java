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
                return søgeResultat;
            }
        } return null;
    }
}