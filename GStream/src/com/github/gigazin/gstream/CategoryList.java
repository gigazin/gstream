package com.github.gigazin.gstream;

public class CategoryList {
    private PrimaryNode firstNode;
    private PrimaryNode lastNode;
    private int nodeQuantity;

    public boolean isEmpty() {
        return this.firstNode == null && this.lastNode == null && this.nodeQuantity == 0;
    }

    public PrimaryNode search(String categoryName) {
        PrimaryNode nodeToReturn;
        if (this.isEmpty()) {
            return null;
        } else {
            nodeToReturn = this.firstNode;
            if (this.nodeQuantity == 1) {
                if (categoryName.equals(this.firstNode.getInfo().getCategoryName())) {
                    return nodeToReturn;
                } else {
                    return null;
                }
            } else {
                if (categoryName.equals(this.firstNode.getInfo().getCategoryName())) {
                    return nodeToReturn;
                } else if (categoryName.equals(this.lastNode.getInfo().getCategoryName())) {
                    return nodeToReturn;
                } else {
                    do {
                        if (categoryName.equals(nodeToReturn.getInfo().getCategoryName())) {
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

    public void insert(Category category, Movie movie) {
        PrimaryNode newNode = new PrimaryNode(category);
        PrimaryNode auxiliaryNode;
        auxiliaryNode = search(category.getCategoryName());
        if (auxiliaryNode == null) {
            if (this.isEmpty()) {
                this.firstNode = newNode;
                this.lastNode = newNode;
                this.nodeQuantity++;
                this.firstNode.setPrevious(this.lastNode);
                this.lastNode.setNext(this.firstNode);
            } else if (this.nodeQuantity == 1) {
                if (category.compareTo(this.firstNode.getInfo()) < 0) {
                    this.firstNode.setPrevious(newNode);
                    newNode.setNext(this.firstNode);
                    newNode.setPrevious(this.lastNode);
                    this.lastNode.setNext(newNode);
                    this.firstNode = newNode;
                    this.nodeQuantity++;
                } else if (category.compareTo(this.lastNode.getInfo()) >= 0) {
                    newNode.setNext(this.firstNode);
                    newNode.setPrevious(this.lastNode);
                    this.lastNode.setNext(newNode);
                    this.lastNode = newNode;
                    this.nodeQuantity++;
                }
            } else if (category.compareTo(this.firstNode.getInfo()) < 0) {
                this.firstNode.setPrevious(newNode);
                newNode.setNext(this.firstNode);
                newNode.setPrevious(this.lastNode);
                this.lastNode.setNext(newNode);
                this.firstNode = newNode;
                this.nodeQuantity++;
            } else if (category.compareTo(this.lastNode.getInfo()) >= 0) {
                newNode.setNext(this.firstNode);
                newNode.setPrevious(this.lastNode);
                this.lastNode.setNext(newNode);
                this.lastNode = newNode;
                this.nodeQuantity++;
            } else {
                auxiliaryNode = this.firstNode;
                do {
                    auxiliaryNode = auxiliaryNode.getNext();
                } while (category.compareTo(auxiliaryNode.getInfo()) > 0);
                auxiliaryNode.getPrevious().setNext(newNode);
                newNode.setPrevious(auxiliaryNode.getPrevious());
                newNode.setNext(auxiliaryNode);
                auxiliaryNode.setPrevious(newNode);
                this.nodeQuantity++;
            }
        }

    }

    public void remove(String categoryName) {
        PrimaryNode auxiliaryNode;
        if (this.isEmpty()) {
            System.out.println("ERROR: The list has no movies registered!");
            return;
        } else if (this.nodeQuantity == 1) {
            if (categoryName.equals(this.firstNode.getInfo().getCategoryName())) {
                this.firstNode = null;
                this.lastNode = null;
                this.nodeQuantity = 0;
            } else {
                System.out.println("ERROR: Movie not found/registered!");
                return;
            }
        } else if (categoryName.equals(this.firstNode.getInfo().getCategoryName())) {
            this.firstNode = this.firstNode.getNext();
            this.firstNode.setPrevious(this.lastNode);
            this.lastNode.setNext(this.firstNode);
            this.nodeQuantity--;
        } else if (categoryName.equals(this.lastNode.getInfo().getCategoryName())) {
            this.lastNode = this.lastNode.getPrevious();
            this.lastNode.setNext(this.firstNode);
            this.firstNode.setPrevious(this.lastNode);
            this.nodeQuantity--;
        } else {
            auxiliaryNode = search(categoryName);
            if (auxiliaryNode == null) {
                System.out.println("ERROR: Category not found/registered!");
                return;
            } else {
                auxiliaryNode.getPrevious().setNext(auxiliaryNode.getNext());
                auxiliaryNode.getNext().setPrevious(auxiliaryNode.getPrevious());
                this.nodeQuantity--;
            }
        }
        System.out.println("INFO: Category removed successfully!");
    }

    public void showCategories() {
        PrimaryNode auxiliaryNode;
        if (this.isEmpty()) {
            System.out.println("ERROR: There are no registered categories!");
        } else {
            auxiliaryNode = this.firstNode;
            do {
                System.out.println(auxiliaryNode.getInfo().getCategoryName());
                auxiliaryNode = auxiliaryNode.getNext();
            } while (auxiliaryNode != this.firstNode);
        }
    }

    public void showCategory(String categoryName) {
        PrimaryNode searchMovie;
        searchMovie = search(categoryName);
        if (searchMovie == null) {
            System.out.println("ERROR: Category not found/registered!");
        } else {
            System.out.println(searchMovie.getInfo());
        }
    }

    public void showList() {
        PrimaryNode auxiliaryNode;
        if (this.isEmpty()) {
            System.out.println("ERROR: There are no categories registered!");
        } else {
            auxiliaryNode = this.firstNode;
            do {
                System.out.println(auxiliaryNode.getInfo());
                auxiliaryNode = auxiliaryNode.getNext();
            } while (auxiliaryNode != this.firstNode);
        }
    }

}
