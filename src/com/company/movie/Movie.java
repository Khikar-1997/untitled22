package com.company.movie;

import java.util.Objects;

public class Movie {
    private String name;
    private String ganre;

    public Movie(String name, String ganre) {
        this.name = name;
        if (ganre.equals(String.valueOf(Ganre.valueOf(ganre)))) {
            this.ganre = ganre;
        }
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(ganre, movie.ganre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ganre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", ganre='" + ganre + '\'' +
                '}';
    }
}
