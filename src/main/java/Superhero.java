public class Superhero {
    private String superHeroName;
    private String realName;
    private boolean humanOrNot;
    private int creationYear;
    private String superPower;
    private double strenght;

    public Superhero(String superHeroName, String realName, boolean humanOrNot, int creationYear, String superPower, double strenght) {
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
        if (humanOrNot) {
            humanJaNej = "Ja";
        } else if (!humanOrNot) {
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

    public void setSuperHeroName(String newSuperHeroName) {
        superHeroName = newSuperHeroName;
    }

    public void setRealName(String newRealName) {
        realName = newRealName;
    }

    public void setHumanOrNot(String newHumanOrNot) {
        humanOrNot = Boolean.parseBoolean(newHumanOrNot);
    }

    public void setCreationYear(String newCreationYear) {
        creationYear = Integer.parseInt(newCreationYear);
    }

    public void setSuperPower(String newSuperPower) {
        superPower = newSuperPower;
    }

    public void setStrenght(String newStrenght) {
        strenght = Double.parseDouble(newStrenght);
    }

    public String toString() {
        return "Superheltenavn: " + superHeroName + "\nSuperkraft: " + superPower + "\nVirkeligt navn: " + realName + "\nOprindelsesår: " + creationYear + "\nEr menneske: " + humanOrNot + "\nStyrke:" + strenght;
    }
}
