public class Superhero {
    private String superHeroName;
    private String realName;
    private boolean humanOrNot;
    private int creationYear;
    private String superPower;
    private double strenght;
    private String heroSearchTerm;

    public Superhero(String superHeroName , String realName , boolean humanOrNot , int creationYear , String superPower , double strenght){
        this.superHeroName = superHeroName;
        this.realName = realName;
        this.humanOrNot = humanOrNot;
        this.creationYear = creationYear;
        this.superPower = superPower;
        this.strenght = strenght;
    }
    public String getSuperHeroName() {
        return superHeroName;
    }
    public String getRealName() {
        return realName;
    }
    public String isHumanOrNot() {
        String humanJaNej = "";
        if(humanOrNot==true) {
            humanJaNej = "Ja";
        }
        else if (humanOrNot==false){
            humanJaNej = "Nej";
        }
        return humanJaNej;
    }
    public int getCreationYear() {
        return creationYear;
    }
    public String getSuperPower() {
        return superPower;
    }
    public double getStrenght() {
        return strenght;
    }
}
