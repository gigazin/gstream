package com.github.gigazin.gstream;

public class Movie implements Comparable<Movie> {
    private String movieTitle;
    private String movieGenre;
    private String movieAgeRating;
    private int movieYearOfRelease;

    public Movie(String title, String genre, String ageRating, int year) {
        this.movieTitle = title;
        this.movieGenre = genre;
        this.movieAgeRating = ageRating;
        this.movieYearOfRelease = year;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return this.movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieAgeRating() {
        return this.movieAgeRating;
    }

    public void setMovieAgeRating(String movieAgeRating) {
        this.movieAgeRating = movieAgeRating;
    }

    public int getMovieYearOfRelease() {
        return this.movieYearOfRelease;
    }

    public void setMovieYearOfRelease(int movieYearOfRelease) {
        this.movieYearOfRelease = movieYearOfRelease;
    }

    public String toString() {
        return "Title: " + this.movieTitle + "\n" +
                "Genre: " + this.movieGenre + "\n" +
                "Age Rating: " + this.movieAgeRating + "\n" +
                "Year of release: " + this.movieYearOfRelease;
    }

    @Override
    public int compareTo(Movie titleToCompare) {
        return this.movieTitle.compareTo(titleToCompare.movieTitle);
    }

}