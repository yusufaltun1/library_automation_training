package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity
{
    private String name;
    private String author;
    private String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
