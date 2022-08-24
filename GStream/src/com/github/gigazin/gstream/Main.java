package com.github.gigazin.gstream;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Movie movie;
        Category category;
        MovieList listOfMovies = new MovieList();
        CategoryList listOfCategories = new CategoryList();
        String categoryName, movieTitle, movieGenre, movieAgeRating;
        int movieYearOfRelease;
        char option;
        do {
            menu();
            System.out.print("Enter your option: ");
            option = in.next().charAt(0);
            in.nextLine();
            switch (option) {
                case '1' -> { // Register a new movie.
                    System.out.print("Category: ");
                    categoryName = in.nextLine();
                    System.out.print("Title: ");
                    movieTitle = in.nextLine();
                    if (listOfMovies.isAlreadyRegistered(movieTitle)) {
                        System.out.println("ERROR: This movie is already registered!");
                    } else {
                        System.out.print("Genre: ");
                        movieGenre = in.nextLine();
                        System.out.print("Age Rating: ");
                        movieAgeRating = in.nextLine();
                        System.out.print("Year of Release: ");
                        movieYearOfRelease = in.nextInt();
                        movie = new Movie(movieTitle, movieGenre, movieAgeRating, movieYearOfRelease);
                        category = new Category(categoryName);
                        listOfMovies.insert(movie);
                        listOfCategories.insert(category, movie);
                    }
                } // Register a new movie.
                case '2' -> { // Delete a movie.
                    System.out.print("Enter the movie title: ");
                    movieTitle = in.nextLine();
                    listOfMovies.remove(movieTitle);
                } // Delete a movie.
                case '3' -> { // Modify a movie.
                    System.out.print("Enter the movie title: ");
                    movieTitle = in.nextLine();
                    listOfMovies.editMovieInfo(movieTitle);
                } // Modify a movie.
                case '4' -> { // Show all categories.
                    System.out.println("====================================== CATEGORIES ======================================");
                    listOfCategories.showCategories();
                    System.out.println("====================================== ////////// ======================================");
                } // Show all categories.
                case '5' -> { // Show all registered movies.
                    System.out.println("====================================== MOVIES ======================================");
                    listOfMovies.showList();
                    System.out.println("====================================== ////// ======================================");
                } // Show all registered movies.
                case '6' -> { // Show movies from a given category.
                    System.out.print("Enter the category: ");
                    System.out.println("====================================== MOVIES ======================================");
                    categoryName = in.nextLine();
                    listOfCategories.showCategory(categoryName);
                    System.out.println("====================================== ////// ======================================");
                } // Show movies from a given category.
                case '7' -> { // Search a movie.
                    System.out.print("Enter the movie title: ");
                    movieTitle = in.nextLine();
                    listOfMovies.showMovie(movieTitle);
                } // Search a movie.
                case '0' -> { // Finish the application.
                    System.out.println("INFO: Application finished successfully!");
                } // Finish the application.
                default -> { // Invalid option.
                    System.out.println("ERROR: Invalid option!");
                } // Invalid option.
            }
        } while (option != '0');
    }

    public static void menu() {
        System.out.println("1 - Register a new movie.");
        System.out.println("2 - Remove a movie.");
        System.out.println("3 - Modify a movie.");
        System.out.println("4 - Show all categories.");
        System.out.println("5 - Show all movies.");
        System.out.println("6 - Show movies from a given category.");
        System.out.println("7 - Search a movie.");
        System.out.println("0 - Finish the application.");
    }

}
