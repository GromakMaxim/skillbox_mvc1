package org.example.web.dto;

import javax.validation.constraints.Digits;

public class Book {
    private int id;
    private String author;
    private String title;

    @Digits(integer = 4, fraction = 0)
    private int size;

    public Book() {
    }

    public Book(int id, String author, String title, int size) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
