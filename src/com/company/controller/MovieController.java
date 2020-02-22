package com.company.controller;

import com.company.movie.Movie;
import com.company.service.MovieService;

import java.util.Scanner;

public class MovieController {
    private MovieService movieService = MovieService.getInstance();

    public void creatMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Name of Movie!");
        String name = scanner.nextLine();
        System.out.println("Please Enter Ganre of Movie");
        String ganre = scanner.nextLine();
        Movie movie = new Movie(name, ganre);
        movieService.creatMovie(movie);
    }

    public void updateMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Movie id");
        int id = scanner.nextInt();
        Movie movie = movieService.selectMovieById(id);
        System.out.println("Movie Name : " + movie.getName());
        System.out.println("Movie Ganre : " + movie.getGanre());
        System.out.println("Please Enter New Name");
        Scanner scanner1 = new Scanner(System.in);
        String newName = scanner1.nextLine();
        System.out.println("Please Enter New Ganre");
        String newGanre = scanner1.nextLine();
        movie.setGanre(newGanre);
        movie.setName(newName);
        movieService.updateMovie(id, movie);


    }

    public void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Id of the movie you are going to delete");
        int id = scanner.nextInt();
        movieService.deleteMovie(id);
    }

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("____________________");
            System.out.println("       MENU          ");
            System.out.println("PRESS 1 FOR CREATING MOVIE !!!");
            System.out.println("PRESS 2 FOR UPDATING MOVIE !!!");
            System.out.println("PRESS 3 FOR DELETING MOVIE !!!");
            System.out.println("PRESS 4 FOR EXIT !!!");
            System.out.println("_____________________");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    creatMovie();
                    break;
                case 2:
                    updateMovie();
                    break;
                case 3:
                    deleteMovie();
                    break;
                case 4:
                    break;
            }
        }
        while (num != 4);
    }
}
