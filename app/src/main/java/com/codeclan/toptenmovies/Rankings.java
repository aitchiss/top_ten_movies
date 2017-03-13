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

    public Movie findByTitle(String title){
        for (Movie movie : this.movies){
            if (movie.getTitle() == title){
                return movie;
            }
        }
        return null;
    }

    public void increaseRanking(String title){
        Movie movie = findByTitle(title);
        int oldRanking = movie.getRanking();
        int newRanking = oldRanking - 1;

        //change the other movie rankings first

        int startIndex = (newRanking - 1);
        for (int i = startIndex; i < 10; i++){
            Movie movieToChange = this.movies[i];
            movieToChange.setRanking(i + 2);
        }

        //update the movie to its new ranking
        movie.setRanking(newRanking);

        //make sure sorted correctly
        sortListOrderByRanking();

    }

    public void sortListOrderByRanking(){
        //sort the array into the correct order - couldn't get them to sort otherwise, so takes a
        //copy and then puts the items back into the first array in the right position

        Movie[] copyOfArray = new Movie[10];
        copyOfArray = java.util.Arrays.copyOfRange(this.movies, 0, 9);

        for (Movie movieToOrder : copyOfArray){
            int ranking = movieToOrder.getRanking();
            int properIndexPosition = ranking - 1;
            this.movies[properIndexPosition] = movieToOrder;
        }
    }



}
