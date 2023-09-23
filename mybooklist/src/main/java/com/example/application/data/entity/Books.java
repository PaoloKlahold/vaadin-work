package com.example.application.data.entity;

import java.time.LocalDate;

public class Books {

    private Integer id;
    private String bookName;
    private String autorName;
    private String genreType;
    private String theme;
    private LocalDate startDate;
    private LocalDate finishDate;
    private boolean favorite;

    public Integer getId() {
        return id;
    }
    public void getId(Integer id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Books)) {
            return false;
        }
        Books other = (Books) obj;
        return id == other.id;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAutorName() {
        return autorName;
    }
    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public String getGenre() {
        return theme;
    }
    public void setGenre(String genreType) {
        this.genreType = genreType;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public boolean getFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }


}
