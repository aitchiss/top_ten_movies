package com.codeclan.toptenmovies;

/**
 * Created by user on 13/03/2017.
 */

public class Movie {

    String title;
    String genre;
    int ranking;

    public Movie(String title, String genre, int ranking){
        this.title = title;
        this.genre = genre;
        this.ranking = ranking;
    }

    public String getTitle(){
        return this.title;
    }

    public String getGenre() {
        return genre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }




    @Override
    public String toString(){
        return "Title: '" + this.title + "', Genre: '" + this.genre + "', Ranking: " + this.ranking;
    }
}
