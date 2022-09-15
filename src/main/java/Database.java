import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperHero(String superHeroName, String realName, boolean humanOrNot, int creationYear, String superPower, double strenght) {
        superheroes.add(new Superhero(superHeroName, realName, humanOrNot, creationYear, superPower, strenght));
    }
    public ArrayList<Superhero> getAllSuperHeroes(){
        return superheroes;
    }
    public Superhero heroSearch (String heroSearchTerm){
        for (Superhero hero : superheroes){
            if (hero.getSuperHeroName().equalsIgnoreCase(heroSearchTerm)){
                return hero;
            }
            else if (hero.getSuperHeroName().contains(heroSearchTerm)){
                return hero;
            }
        }
        return null;
    }
}
