public class Database {
    private Superhero[] liste = new Superhero[5];
    private int index = 0;
    public void superhero(String superHeroName, String realName , boolean humanOrNot , int creationYear , String superPower , double strenght){
        Superhero hero = new Superhero(superHeroName, realName , humanOrNot , creationYear , superPower , strenght);
        liste[index] = hero;
        index = +1;

        for (Superhero superhero : liste){
            System.out.println(superhero);
        }
        System.out.println("---------------");
    }
}
