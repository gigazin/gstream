package com.github.gigazin.gstream;

public class PrimaryNode {
    private PrimaryNode next;
    private PrimaryNode previous;
    private Category info;

    public PrimaryNode(Category info) {
        this.info = info;
    }

    public void setNext(PrimaryNode next) {
        this.next = next;
    }

    public PrimaryNode getNext() {
        return this.next;
    }

    public void setPrevious(PrimaryNode previous) {
        this.previous = previous;
    }

    public PrimaryNode getPrevious() {
        return this.previous;
    }

    public void setInfo(Category info) {
        this.info = info;
    }

    public Category getInfo() {
        return this.info;
    }
}
