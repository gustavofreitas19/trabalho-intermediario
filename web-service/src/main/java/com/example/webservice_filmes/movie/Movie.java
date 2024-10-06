package com.example.webservice_filmes.movie;

public class Movie {
    private String title;
    private String year;
    private String plot;

    // Construtores, getters e setters
    public Movie() {}

    public Movie(String title, String year, String plot) {
        this.title = title;
        this.year = year;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
