package com.github.gigazin.gstream;

public class SecondaryNode {
    private SecondaryNode next;
    private SecondaryNode previous;
    private Movie info;

    public SecondaryNode(Movie info) {
        this.info = info;
    }

    public SecondaryNode getNext() {
        return this.next;
    }

    public void setNext(SecondaryNode next) {
        this.next = next;
    }

    public SecondaryNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(SecondaryNode previous) {
        this.previous = previous;
    }

    public Movie getInfo() {
        return this.info;
    }

    public void setInfo(Movie info) {
        this.info = info;
    }
}
