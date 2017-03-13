package com.codeclan.toptenmovies;

import java.util.ArrayList;

/**
 * Created by user on 13/03/2017.
 */

public class Rankings {

    Movie[] movies;

    public Rankings(){
        this.movies = new Movie[10];
    }

    public Rankings(ArrayList<Movie> moviesToAdd){
        this.movies = new Movie[10];
        for (Movie movieToAdd : moviesToAdd){
            int ranking = movieToAdd.getRanking();
            int index = ranking - 1;
            this.movies[index] = movieToAdd;
        }
    }

    public Movie getMovieByRanking(int ranking){
        return this.movies[ranking - 1];
    }

    public void addToBottomOfList(Movie movie){
        this.movies[9] = movie;
        movie.setRanking(10);
    }

}
