import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void createSuperHero() {
        //Arrange
        Database database = new Database();
        int expectedSize = 1;
        //Act
        database.createSuperHero("wen", "ye" , true , 1302234 , "sdfbge" , 2345);
        ArrayList<Superhero> results = database.getAllSuperHeroes();
        int actualSize=results.size();
        //Assert
        assertEquals(expectedSize, actualSize);
    }
    @Test
    void searchFor(){
        //Arrange
        Database database = new Database();
        //should be false
        int expectedSize = 2;
        //Act
        database.createSuperHero("wen", "ye" , true , 1302234 , "sdfbge" , 2345);
        database.createSuperHero("wen2", "ye" , true , 1302234 , "sdfbge" , 2345);
        ArrayList<Superhero> results = database.advancedHeroSearch("lol");
        int actualSize=results.size();
        //Assert
        assertEquals(expectedSize, actualSize);
    }
    @Test
    void searchFor2(){
        //Arrange
        Database database = new Database();
        int expectedSize = 0;
        //Act
        database.createSuperHero("wen", "ye" , true , 1302234 , "sdfbge" , 2345);
        database.createSuperHero("wen2", "ye" , true , 1302234 , "sdfbge" , 2345);
        ArrayList<Superhero> results = database.searchAndEdit("Superman");
        int actualSize = results.size();
        //Assert
        assertEquals(expectedSize, actualSize);
    }
    @Test
    void deleteSuperhero(){
        //Arange
        Database database = new Database();
        //Act
        ArrayList<Superhero> results = database.getAllSuperHeroes();
        Superhero superhero = results.get(0);
        boolean actualResult = database.deleteSuperHero(superhero);
        boolean expectedResult = true;
        //Assert
        assertEquals(expectedResult , actualResult);

        int expectedSize = results.size() -1;
        ArrayList<Superhero> resultsAfterDelete = database.getAllSuperHeroes();
        int actualSize = resultsAfterDelete.size();

        assertEquals(expectedSize , actualSize);
    }
}