package com.company.service;

import com.company.movie.Movie;

import java.sql.*;

public class MovieService {
    private static MovieService movieService = null;

    private MovieService() {
    }

    public static MovieService getInstance() {
        if (movieService == null) {
            MovieService movieService1 = new MovieService();
            movieService = movieService1;
            return movieService;
        } else return movieService;
    }

    public void creatMovie(Movie movie) {
        try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/my_application", "root", "root")) {
            if (con != null) {
                String quary = "INSERT INTO movies(name,ganre) VALUES(?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(quary);
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setString(2, movie.getGanre());

                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println("!!");
        }
    }

    public Movie selectMovieById(int id) {
        Movie movie = new Movie();
        try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/my_application", "root", "root")) {
            if (con != null) {
                String query = "SELECT* FROM movies WHERE movie_id=?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    movie.setName(resultSet.getString("name"));
                    movie.setGanre(resultSet.getString("ganre"));
                }
                return movie;
            }
        } catch (SQLException e) {
            System.out.println("!!!");
            return movie;
        }
        return movie;
    }

    public void updateMovie(int id, Movie movie) {
        try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/my_application", "root", "root")) {
            if (con != null) {
                String quary = "UPDATE movies SET name=?, ganre=? WHERE movie_id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(quary);
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setString(2, movie.getGanre());
                preparedStatement.setInt(3, id);

                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println("!!!!!");
        }

    }

    public void deleteMovie(int id) {
        try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/my_application", "root", "root")) {
            if (con != null) {
                String quary = "DELETE FROM movies WHERE movie_id=?";
                PreparedStatement preparedStatement = con.prepareStatement(quary);
                preparedStatement.setInt(1, id);
                preparedStatement.execute();

            }
        } catch (SQLException e) {
            System.out.println("!!!!!");
        }
    }
}
