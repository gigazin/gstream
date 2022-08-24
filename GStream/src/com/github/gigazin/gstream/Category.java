package com.github.gigazin.gstream;

public class Category implements Comparable <Category> {
    private String categoryName;
    private MovieList movieList;

    public Category(String name) {
        this.categoryName = name;
    }

    public void setCategoryName(String newName) {
        this.categoryName = newName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setMovieList(MovieList newMovieList) {
        this.movieList = newMovieList;
    }

    public MovieList getMovieList() {
        return this.movieList;
    }

    public String toString() {
        return "Category: " + this.categoryName + "\n" +
                "Movies: " + this.movieList;
    }

    public int compareTo(Category nameToCompare) {
        return this.categoryName.compareTo(nameToCompare.categoryName);
    }
}
