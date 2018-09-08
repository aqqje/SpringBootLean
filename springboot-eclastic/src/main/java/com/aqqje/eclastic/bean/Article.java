package com.aqqje.eclastic.bean;

public class Article {
    private String author;
    private String type;
    private Integer id;

    public Article() {
    }

    public Article(Integer id, String author, String type) {
        this.author = author;
        this.type = type;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
