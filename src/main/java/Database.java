import java.util.ArrayList;

public class Database {
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
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(advancedHeroSearchTerm)) {
                searchResult.add(hero);
            }
        }
        return searchResult;
    }

    public ArrayList<Superhero> searchAndEdit(String searchAndEditTerm) {
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero hero : superheroes) {
            if (hero.getSuperHeroName().contains(searchAndEditTerm)) {
                searchResult.add(hero);
            }
        }
        return searchResult;
    }
    public boolean deleteSuperHero (Superhero hero){
        boolean success = superheroes.remove(hero);
        return success;
    }
}