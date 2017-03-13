package com.codeclan.toptenmovies;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by user on 13/03/2017.
 */

public class MovieTest {

    Movie movie;

    @Before
    public void before(){
        String title = "Mighty Ducks";
        String genre = "Family";
        int ranking = 1;

        movie = new Movie(title, genre, ranking);
    }

    @Test
    public void movieHasTitle(){
        assertEquals("Mighty Ducks", movie.getTitle());
    }

    @Test
    public void movieHasGenre(){
        assertEquals("Family", movie.getGenre());
    }

    @Test
    public void movieHasRanking(){
        assertEquals(1, movie.getRanking());
    }

    @Test
    public void canSetTitle(){
        movie.setTitle("Mighty Ducks: We Are The Champions");
        assertEquals("Mighty Ducks: We Are The Champions", movie.getTitle());
    }

    @Test
    public void canSetGenre(){
        movie.setGenre("Sports");
        assertEquals("Sports", movie.getGenre());
    }

    @Test
    public void canSetRanking(){
        movie.setRanking(2);
        assertEquals(2, movie.getRanking());
    }
}
