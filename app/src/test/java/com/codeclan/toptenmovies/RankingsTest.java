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
    Movie movie3;
    Movie movie4;
    Movie movie10;
    ArrayList<Movie> moviesToAdd;

    @Before
    public void before(){

        movie1 = new Movie("Mighty Ducks", "Family", 1);
        movie2 = new Movie("Withnail & I", "Comedy", 2);
        movie3 = new Movie("Young Guns", "Teen", 4);
        movie4 = new Movie("Aladdin", "Childrens", 3);
        movie10 = new Movie("St Elmo's Fire", "Teen", 10);

        moviesToAdd = new ArrayList<Movie>();

        moviesToAdd.add(movie1);
        moviesToAdd.add(movie2);
        moviesToAdd.add(movie3);
        moviesToAdd.add(movie4);
        moviesToAdd.add(movie10);
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

    @Test
    public void testOrdersMoviesInArrayByRanking(){
        Rankings rankings = new Rankings(moviesToAdd);
        assertEquals(movie3, rankings.getMovieByRanking(4));
    }

    @Test
    public void testAddToEndOfList(){
        Movie newMovie = new Movie("The Fisher King", "Drama", 5);
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.addToBottomOfList(newMovie);
        assertEquals(newMovie, rankings.getMovieByRanking(10));
    }

    @Test
    public void testAddToBottomChangesMovieRanking(){
        Movie newMovie = new Movie("The Fisher King", "Drama", 5);
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.addToBottomOfList(newMovie);
        assertEquals(10, newMovie.getRanking());
    }
}
