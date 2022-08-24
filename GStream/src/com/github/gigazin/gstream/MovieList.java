package com.github.gigazin.gstream;

import java.util.Scanner;

public class MovieList {
    private SecondaryNode firstNode;
    private SecondaryNode lastNode;
    private int nodeQuantity;

    public boolean isEmpty() {
        return this.firstNode == null && this.lastNode == null && this.nodeQuantity == 0;
    }

    public boolean isAlreadyRegistered(String title) {
        SecondaryNode auxiliaryNode;
        if (this.isEmpty()) {
            return false;
        } else {
            if (this.nodeQuantity == 1) {
                return title.equals(this.firstNode.getInfo().getMovieTitle());
            } else {
                auxiliaryNode = this.firstNode;
                do {
                    if (title.equals(this.firstNode.getInfo().getMovieTitle())) {
                        return true;
                    } else {
                        auxiliaryNode = auxiliaryNode.getNext();
                    }
                } while (auxiliaryNode != this.firstNode);
            }
        }
        return false;
    }

    public SecondaryNode search(String title) {
        SecondaryNode nodeToReturn;
        if (this.isEmpty()) {
            return null;
        } else {
            nodeToReturn = this.firstNode;
            if (this.nodeQuantity == 1) {
                if (title.equals(this.firstNode.getInfo().getMovieTitle())) {
                    return nodeToReturn;
                } else {
                    return null;
                }
            } else {
                if (title.equals(this.firstNode.getInfo().getMovieTitle())) {
                    return nodeToReturn;
                } else if (title.equals(this.lastNode.getInfo().getMovieTitle())) {
                    return nodeToReturn;
                } else {
                    do {
                        if (title.equals(nodeToReturn.getInfo().getMovieTitle())) {
                            return nodeToReturn;
                        } else {
                            nodeToReturn = nodeToReturn.getNext();
                        }
                    } while (nodeToReturn != this.firstNode);
                }
            }
        }
        return null;
    }

    public void insert(Movie movieToRegister) {
        SecondaryNode newNode = new SecondaryNode(movieToRegister);
        SecondaryNode auxiliaryNode;
        if (this.isEmpty()) { // Inserts on an empty list.
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.nodeQuantity++;
            this.firstNode.setPrevious(this.lastNode);
            this.lastNode.setNext(this.firstNode);
        } else if (this.nodeQuantity == 1) { // Inserts on a list with 1 node.
            if (movieToRegister.compareTo(this.firstNode.getInfo()) < 0) {
                this.firstNode.setPrevious(newNode);
                newNode.setNext(this.firstNode);
                newNode.setPrevious(this.lastNode);
                this.lastNode.setNext(newNode);
                this.firstNode = newNode;
                this.nodeQuantity++;
            } else if (movieToRegister.compareTo(this.lastNode.getInfo()) >= 0) {
                this.firstNode.setNext(newNode);
                newNode.setPrevious(this.firstNode);
                newNode.setNext(this.firstNode);
                this.lastNode = newNode;
                this.nodeQuantity++;
            }
        } else if (movieToRegister.compareTo(this.firstNode.getInfo()) < 0) { // Inserts at the head of a list with more than 1 node.
            newNode.setNext(this.firstNode);
            newNode.setPrevious(this.lastNode);
            this.firstNode.setPrevious(newNode);
            this.lastNode.setNext(newNode);
            this.firstNode = newNode;
            this.nodeQuantity++;
        } else if (movieToRegister.compareTo(this.lastNode.getInfo()) >= 0) { // Inserts at the tail of a list with more than 1 node.
            this.firstNode.setPrevious(newNode);
            newNode.setNext(this.firstNode);
            newNode.setPrevious(this.lastNode);
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
            this.nodeQuantity++;
        } else { // Inserts at the middle of a list with more than 1 node.
            auxiliaryNode = this.firstNode;
            do {
                auxiliaryNode = auxiliaryNode.getNext();
            } while (movieToRegister.compareTo(auxiliaryNode.getInfo()) > 0);
            auxiliaryNode.getPrevious().setNext(newNode);
            newNode.setPrevious(auxiliaryNode.getPrevious());
            newNode.setNext(auxiliaryNode);
            auxiliaryNode.setPrevious(newNode);
            this.nodeQuantity++;
        }
        System.out.println("INFO: Movie registered successfully!");
    }

    public void remove(String title) {
        SecondaryNode auxiliaryNode;
        if (this.isEmpty()) {
            System.out.println("ERROR: The list has no movies registered!");
            return;
        } else if (this.nodeQuantity == 1) {
            if (title.equals(this.firstNode.getInfo().getMovieTitle())) {
                this.firstNode = null;
                this.lastNode = null;
                this.nodeQuantity = 0;
            } else {
                System.out.println("ERROR: Movie not found/registered!");
                return;
            }
        } else if (title.equals(this.firstNode.getInfo().getMovieTitle())) {
            this.firstNode = this.firstNode.getNext();
            this.firstNode.setPrevious(this.lastNode);
            this.lastNode.setNext(this.firstNode);
            this.nodeQuantity--;
        } else if (title.equals(this.lastNode.getInfo().getMovieTitle())) {
            this.lastNode = this.lastNode.getPrevious();
            this.lastNode.setNext(this.firstNode);
            this.firstNode.setPrevious(this.lastNode);
            this.nodeQuantity--;
        } else {
            auxiliaryNode = search(title);
            if (auxiliaryNode == null) {
                System.out.println("ERROR: Movie not found/registered!");
                return;
            } else {
                auxiliaryNode.getPrevious().setNext(auxiliaryNode.getNext());
                auxiliaryNode.getNext().setPrevious(auxiliaryNode.getPrevious());
                this.nodeQuantity--;
            }
        }
        System.out.println("INFO: Movie removed successfully!");
    }

    public void editMovieInfo(String title) {
        Scanner in = new Scanner(System.in);
        String movieTitle, movieGenre, movieAgeRating;
        int movieYearOfRelease;
        SecondaryNode searchToEdit, searchToCheckDuplicate;
        searchToEdit = search(title);
        if (searchToEdit == null) {
            System.out.println("ERROR: Movie not found/registered!");
        } else {
            System.out.print("Title: ");
            movieTitle = in.nextLine();
            searchToCheckDuplicate = search(movieTitle);
            while (searchToCheckDuplicate != null) {
                System.out.println("ERROR: There is already a movie registered with this title!");
                System.out.print("Enter the title again: ");
                movieTitle = in.nextLine();
                searchToCheckDuplicate = search(movieTitle);
            }
            System.out.print("Genre: ");
            movieGenre = in.nextLine();
            System.out.print("Age Rating: ");
            movieAgeRating = in.nextLine();
            System.out.print("Year of Release: ");
            movieYearOfRelease = in.nextInt();
            searchToEdit.getInfo().setMovieTitle(movieTitle);
            searchToEdit.getInfo().setMovieGenre(movieGenre);
            searchToEdit.getInfo().setMovieAgeRating(movieAgeRating);
            searchToEdit.getInfo().setMovieYearOfRelease(movieYearOfRelease);
            System.out.println("INFO: Movie updated successfully!");
        }
    }

    public void showMovie(String title) {
        SecondaryNode searchMovie;
        searchMovie = search(title);
        if (searchMovie == null) {
            System.out.println("ERROR: Movie not found/registered!");
        } else {
            System.out.println(searchMovie.getInfo());
        }
    }

    public void showList() {
        SecondaryNode auxiliaryNode;
        if (this.isEmpty()) {
            System.out.println("ERROR: The list has no movies registered!");
        } else {
            auxiliaryNode = this.firstNode;
            do {
                System.out.println(auxiliaryNode.getInfo());
                auxiliaryNode = auxiliaryNode.getNext();
            } while (auxiliaryNode != this.firstNode);
        }
    }

}