package com.codeclan.toptenmovies;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 13/03/2017.
 */

public class RankingsTest {

    Rankings rankings;
    Movie movie1;
    Movie movie2;
    ArrayList<Movie> moviesToAdd;

    @Before
    public void before(){

        movie1 = new Movie("Mighty Ducks", "Family", 1);
        movie2 = new Movie("Withnail & I", "Comedy", 2);

        moviesToAdd = new ArrayList<Movie>();

        moviesToAdd.add(movie1);
        moviesToAdd.add(movie2);
    }

    @Test
    public void testInitializesWithEmptyArrayListOfMovies(){
        Rankings rankings = new Rankings();
        assertEquals(null, rankings.getMovieByRanking(1));
    }

    @Test
    public void testInitializesWithMovies(){
        Rankings rankings = new Rankings(moviesToAdd);
        assertEquals(movie1, rankings.getMovieByRanking(1));
    }
}
