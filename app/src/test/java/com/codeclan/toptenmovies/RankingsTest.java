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
    Movie movie5;
    Movie movie6;
    Movie movie7;
    Movie movie8;
    Movie movie9;
    Movie movie10;
    ArrayList<Movie> moviesToAdd;

    @Before
    public void before(){

        movie1 = new Movie("Mighty Ducks", "Family", 1);
        movie2 = new Movie("Withnail & I", "Comedy", 2);
        movie3 = new Movie("Young Guns", "Teen", 4);
        movie4 = new Movie("Aladdin", "Childrens", 3);
        movie5 = new Movie("The Godfather", "Drama", 5);
        movie6 = new Movie("Rocky", "Sports", 6);
        movie7 = new Movie("Step Up", "Dance", 7);
        movie8 = new Movie("M*A*S*H", "Comedy", 8);
        movie9 = new Movie("The Graduate", "Drama", 9);
        movie10 = new Movie("St Elmo's Fire", "Teen", 10);

        moviesToAdd = new ArrayList<Movie>();

        moviesToAdd.add(movie1);
        moviesToAdd.add(movie2);
        moviesToAdd.add(movie3);
        moviesToAdd.add(movie4);
        moviesToAdd.add(movie5);
        moviesToAdd.add(movie6);
        moviesToAdd.add(movie7);
        moviesToAdd.add(movie8);
        moviesToAdd.add(movie9);
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

    @Test
    public void testFindByTitle(){
        Rankings rankings = new Rankings(moviesToAdd);
        assertEquals(movie1, rankings.findByTitle("Mighty Ducks"));
    }

    @Test
    public void testIncreaseRanking(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.increaseRanking("Withnail & I");
        assertEquals(1, movie2.getRanking());
    }

    @Test
    public void increaseRankingChangesRanking(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.increaseRanking("Withnail & I");
        assertEquals(movie2, rankings.getMovieByRanking(1));
    }

    @Test
    public void increaseRankingAltersArrayOrder(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.increaseRanking("Withnail & I");
        assertEquals(movie1, rankings.getMovieByRanking(2));
    }

    @Test
    public void decreaseRankingChangesRanking(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.decreaseRanking("Young Guns");
        assertEquals(5, movie3.getRanking());
    }

    @Test
    public void decreaseRankingChangesRankingOfOtherMovies(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.decreaseRanking("Young Guns");
        assertEquals(4, movie5.getRanking());
    }

    @Test
    public void decreaseRankingChangesOrderOfArray(){
        Rankings rankings = new Rankings(moviesToAdd);
        rankings.decreaseRanking("Young Guns");
        assertEquals(movie3, rankings.getMovieByRanking(5));
        assertEquals(movie5, rankings.getMovieByRanking(4));
        assertEquals(movie6, rankings.getMovieByRanking(6));
    }
}
